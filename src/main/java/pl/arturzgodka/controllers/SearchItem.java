package pl.arturzgodka.controllers;

import pl.arturzgodka.apihandlers.ItemHandlerApi;
import pl.arturzgodka.datamodel.ItemDataModel;
import pl.arturzgodka.jsonmappers.ItemMapper;
import pl.arturzgodka.token.FetchToken;

import java.util.ArrayList;
import java.util.List;

public class SearchItem {

    public static String convertProvidedItemNameToSearchToAPIFormat(String itemSearchName) {
        return itemSearchName.toLowerCase().replace(" ", "-").replace("'", "");
    }

    public static List<List<String>> getMatchedItemsToAPI(String convertedItemName) {
        return ItemClassesAndNamesLists.selectedItemsNamesToApi(convertedItemName);
    }

    public static List<ItemDataModel> getSearchedItems(List<List<String>> itemsNamesToApi) {

        ItemMapper itemMapper = new ItemMapper();
        List<ItemDataModel> itemsMapped = new ArrayList<ItemDataModel>();
        FetchToken fetchToken = new FetchToken();

        for (List<String> itemCategory : itemsNamesToApi) {
            for(String itemName : itemCategory) {
                String itemJSON = ItemHandlerApi.generateRequest(itemName, fetchToken);
                itemsMapped.add(itemMapper.mapItemToDataModel(itemJSON));
            }
        }

        return itemsMapped;
    }
}
