package pl.arturzgodka.jsonmappers;

import pl.arturzgodka.apihandlers.BaseUrlParts;
import pl.arturzgodka.apihandlers.ItemHandlerApi;
import pl.arturzgodka.datamodel.ItemArmorDataModel;
import pl.arturzgodka.datamodel.ItemDataModel;
import pl.arturzgodka.datamodel.ItemWeaponDataModel;
import pl.arturzgodka.token.FetchToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemMapper {

    //TODO improve naming of methods

    public List<ItemDataModel> getItemsOfAnyType(List<String> itemsOfSelectedType) {

        List<ItemDataModel> items = new ArrayList<>();
        FetchToken fetchToken = new FetchToken();

        for (String item : itemsOfSelectedType) {
            ItemDataModel itemDataModel = mapItemToDataModelSearchItem(ItemHandlerApi.generateRequest(item, fetchToken));
            items.add(itemDataModel);
        }

        return items;
    }

    public ItemDataModel mapItemToDataModelSearchItem(String itemData) {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = null;

        try {
            node = objectMapper.readTree(itemData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        if(node.has("armor")) {
            return createArmorDataModelToItemsListView(node);
        } else {
            return  createWeaponDataModelToItemsListView(node);
        }
    }

    private List<String> fetchItemBodyPartSlots(JsonNode node) {

        List<String> itemBodyPartSlots = new ArrayList<>();

        for(int i = 0; i < node.get("slots").size(); i++) {
            itemBodyPartSlots.add(node.get("slots").get(i).asText());
        }

        return itemBodyPartSlots;
    }

    private Map<String, List<String>> fetchItemAttributes(JsonNode node) {

        Map<String, List<String>> mapItemAttributes = new HashMap<>();

        mapItemAttributes.put("primary", attributesList(node, "primary"));
        mapItemAttributes.put("secondary", attributesList(node, "secondary"));

        return mapItemAttributes;
    }

    private List<String> attributesList(JsonNode node, String key) {

        if(node.get("attributes") == null) {
            return new ArrayList<>();
        }

        List<String> attributesList = new ArrayList<String>();

        for(int i = 0; i < getAttributesSize(node, key); i++) {
            attributesList.add(node.get("attributes").get(key).get(i).get("text").asText());
        }

        return attributesList;
    }

    private int getAttributesSize(JsonNode node, String key) {

        if(node.get("attributes") == null) {
            return 0;
        }

        return node.get("attributes").get(key).size();
    }

    private String getMinDamage(JsonNode node) {

        int minDamageEndIndex = node.get("damage").asText().indexOf("-");

        return node.get("damage").asText().substring(0, minDamageEndIndex);
    }

    private String getMaxDamage(JsonNode node) {

        int maxDamageStartIndex = node.get("damage").asText().indexOf("-")+1;
        int maxDamageEndIndex = node.get("damage").asText().indexOf(" ");

        return node.get("damage").asText().substring(maxDamageStartIndex, maxDamageEndIndex);
    }

    private String getFlavorTextDescription(JsonNode node) {

        if(node.get("flavorText") == null) {
            return null;
        }

        return node.get("flavorText").asText()
                .replace(".” –", ".”<br/>–")
                .replace(". –", ".<br/>-")
                .replace("”.–", ".”<br/>–")
                .replace(".” -", ".”<br/>-")
                .replace("” –", "”<br/>–");
    }

    private List<String> fetchRandomAffixes(JsonNode node) {

        if(node.get("randomAffixes") == null) {
            return new ArrayList<>();
        }

        List<String> randomAffixesList = new ArrayList<String>();

        for(int i = 0; i < getRandomAffixesSize(node); i++) {
            randomAffixesList.add(node.get("randomAffixes").get(0).get("oneOf").get(i).get("text").asText());
        }

        return randomAffixesList;
    }

    private int getRandomAffixesSize(JsonNode node) {

        if(node.get("randomAffixes") == null) {
            return 0;
        }

        return node.get("randomAffixes").get(0).get("oneOf").size();
    }

    private String getSetName(JsonNode node) {

        if(!node.has("setName")) {
            return null;
        } else {
            return node.get("setName").asText();
        }
    }

    private String getSetDescription(JsonNode node) {

        if(!node.has("setDescriptionHtml")) {
            return null;
        } else {
            return node.get("setDescriptionHtml").asText();
        }
    }

    private String getIconURL(JsonNode node) {
        return BaseUrlParts.BASE_MEDIA_BLIZZARD_ITEM_ICON_URL + node.get("icon").asText() + ".png";
    }

    private ItemArmorDataModel createArmorDataModelToItemsListView(JsonNode node) {

        return new ItemArmorDataModel(
                node.get("name").asText(),
                node.get("requiredLevel").asInt(),
                node.get("typeName").asText(),
                getFlavorTextDescription(node),
                fetchRandomAffixes(node),
                getSetName(node),
                getSetDescription(node),
                getIconURL(node),
                node.get("armor").asText(),
                fetchItemAttributes(node)
        );
    }

    private ItemWeaponDataModel createWeaponDataModelToItemsListView(JsonNode node) {

        return new ItemWeaponDataModel(
                node.get("name").asText(),
                node.get("requiredLevel").asInt(),
                node.get("typeName").asText(),
                getFlavorTextDescription(node),
                fetchRandomAffixes(node),
                getSetName(node),
                getSetDescription(node),
                getIconURL(node),
                getMinDamage(node),
                getMaxDamage(node),
                fetchItemAttributes(node)
        );
    }
}