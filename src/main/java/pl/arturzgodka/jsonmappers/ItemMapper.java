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

    public ItemArmorDataModel mapItemToArmorTypeDataModel(String itemData) {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = null;

        try {
            node = objectMapper.readTree(itemData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return createArmorDataModelToItemsListView(node);
    }

    public ItemWeaponDataModel mapItemToWeaponTypeDataModel(String itemData) {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = null;

        try {
            node = objectMapper.readTree(itemData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return createWeaponDataModelToItemsListView(node);
    }

    public List<ItemArmorDataModel> getItemsOfArmorType(List<String> itemsOfSelectedType) {

        List<ItemArmorDataModel> items = new ArrayList<>();
        FetchToken fetchToken = new FetchToken();

        for (String item : itemsOfSelectedType) {
            ItemArmorDataModel itemArmorDataModel = mapItemToArmorTypeDataModel(ItemHandlerApi.generateRequest(item, fetchToken));
            items.add(itemArmorDataModel);
        }

        return items;
    }

    public List<ItemWeaponDataModel> getItemsOfWeaponType(List<String> itemsOfSelectedType) {

        List<ItemWeaponDataModel> items = new ArrayList<>();
        FetchToken fetchToken = new FetchToken();

        for (String item : itemsOfSelectedType) {
            ItemWeaponDataModel itemWeaponDataModel = mapItemToWeaponTypeDataModel(ItemHandlerApi.generateRequest(item, fetchToken));
            items.add(itemWeaponDataModel);
        }

        return items;
    }

    public ItemDataModel mapItemToDataModel(String itemData) {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = null;

        try {
            node = objectMapper.readTree(itemData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        if(node.has("armor")) {
            return createArmorDataModel(node);
        } else {
            return  createWeaponDataModel(node);
        }
    }

    private List<String> fetchItemBodyPartSlots(JsonNode node) {

        List<String> itemBodyPartSlots = new ArrayList<>();

        for(int i = 0; i < node.get("slots").size(); i++) {
            itemBodyPartSlots.add(node.get("slots").get(i).asText());
        }

        return itemBodyPartSlots;
    }

    private Map<String, List<String>> fetchItemAttrtibutes(JsonNode node) {

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
        String minDamage = node.get("damage").asText().substring(0, minDamageEndIndex);

        return minDamage;
    }

    private String getMaxDamage(JsonNode node) {

        int maxDamageStartIndex = node.get("damage").asText().indexOf("-")+1;
        int maxDamageEndIndex = node.get("damage").asText().indexOf(" ");
        String maxDamage = node.get("damage").asText().substring(maxDamageStartIndex, maxDamageEndIndex);

        return maxDamage;
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

    private ItemDataModel createArmorDataModel(JsonNode node) { //TODO czy dodac pole typeName i pozostale? Sprawdzić gdzie taka instancja jest wykorzystywana.

        return new ItemArmorDataModel(
                fetchItemBodyPartSlots(node),
                node.get("id").asText(),
                node.get("name").asText(),
                node.get("requiredLevel").asInt(),
                fetchItemAttrtibutes(node),
                node.get("armor").asText()
        );
    }

    private ItemArmorDataModel createArmorDataModelToItemsListView(JsonNode node) { //TODO te 2 metody zrobic w 1 i dac if w zaleznosci od tego co ma zostac zwrocone? Czy armor czy weapon type.

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
                fetchItemAttrtibutes(node)
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
                fetchItemAttrtibutes(node)
        );
    }

    private ItemDataModel createWeaponDataModel(JsonNode node) { //TODO czy dodac pole typeName i pozostale rowniez tutaj?

        return new ItemWeaponDataModel(
                fetchItemBodyPartSlots(node),
                node.get("id").asText(),
                node.get("name").asText(),
                node.get("requiredLevel").asInt(),
                fetchItemAttrtibutes(node),
                getMinDamage(node),
                getMaxDamage(node)
        );
    }
}