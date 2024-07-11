package pl.arturzgodka.jsonmappers;

import pl.arturzgodka.apihandlers.ItemHandlerApi;
import pl.arturzgodka.apihandlers.SkillHandlerApi;
import pl.arturzgodka.datamodel.HeroSkillDataModel;
import pl.arturzgodka.datamodel.ItemArmorDataModel;
import pl.arturzgodka.datamodel.ItemDataModel;
import pl.arturzgodka.datamodel.ItemWeaponDataModel;
import pl.arturzgodka.token.FetchToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemMapper {

    private List<String> fetchItemBodyPartSlots(JsonNode node) {

        List<String> itemBodyPartSlots = new ArrayList<>();

        for(int i = 0; i < node.get("slots").size(); i++) {
            itemBodyPartSlots.add(node.get("slots").get(i).asText());
        }

        return itemBodyPartSlots;
    }

    private Map<String, List<String>> fetchItemAttrtibutes(JsonNode node) {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, List<String>> mapItemAttributes = objectMapper.convertValue(node.get("attributes"), Map.class);

        return mapItemAttributes;
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

    private ItemDataModel createArmorDataModel(JsonNode node) {

        return new ItemArmorDataModel(
                fetchItemBodyPartSlots(node),
                node.get("id").asText(),
                node.get("name").asText(),
                node.get("requiredLevel").asInt(),
                fetchItemAttrtibutes(node),
                node.get("armor").asText()
        );
    }

    private ItemArmorDataModel createArmorDataModelToItemsListView(JsonNode node) { //te 2 moetody zrobic w 1 i dac if w zaleznosci od tego co ma zostac zwrocone? Czy armor czy weapon type.

        return new ItemArmorDataModel(
                node.get("name").asText(),
                node.get("requiredLevel").asInt(),
                node.get("armor").asText()
        );
    }

    private ItemWeaponDataModel createWeaponDataModelToItemsListView(JsonNode node) {

        return new ItemWeaponDataModel(
                node.get("name").asText(),
                node.get("requiredLevel").asInt(),
                getMinDamage(node),
                getMaxDamage(node)
        );
    }

    private ItemDataModel createWeaponDataModel(JsonNode node) {

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

    public List<ItemDataModel> getItemsOfSelectedType(List<String> itemsOfSelectedType) {

        List<ItemDataModel> items = new ArrayList<>();
        FetchToken fetchToken = new FetchToken();

        for (String item : itemsOfSelectedType) {
            ItemDataModel itemDataModel = mapItemToDataModel(ItemHandlerApi.generateRequest(item, fetchToken));
            items.add(itemDataModel);
        }

        return items;
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
}