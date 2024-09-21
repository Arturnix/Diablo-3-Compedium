package pl.arturzgodka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.arturzgodka.apihandlers.ItemHandlerApi;
import pl.arturzgodka.datamodel.ItemDataModel;
import pl.arturzgodka.jsonmappers.ItemMapper;
import pl.arturzgodka.token.FetchToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static pl.arturzgodka.controllers.SearchItem.*;

@Controller
public class ItemsController {

    private final ItemMapper itemMapper = new ItemMapper();

    @RequestMapping("items/itemsTypes.html")
    public String getItemTypes(Model model) {
        model.addAttribute("itemTypesList", ItemClassesAndNamesLists.itemTypes);
        return "itemsTypes";
    }

    @GetMapping("items/singleItem")
    public String searchItemForm(Model model, @RequestParam String itemSearchName) {

        List<List<String>> itemsNamesToApi = getMatchedItemsToAPI(convertProvidedItemNameToSearchToAPIFormat(itemSearchName));
        List<ItemDataModel> itemsMapped = getSearchedItems(itemsNamesToApi);

        model.addAttribute("itemsMapped", itemsMapped);

        return "items";
    }

    @RequestMapping(value="items/{itemTypes}", method = RequestMethod.GET)
    public String getItemTypesNames(Model model, @PathVariable(value="itemTypes") String itemType) {

        Set<String> itemTypeNames = ItemClassesAndNamesLists.getItemTypesNames(itemType);
        model.addAttribute("selectedItemType", itemType);
        model.addAttribute("itemTypesNames", itemTypeNames);

        return "itemTypes";
    }

    @RequestMapping("items/{selectedItemType}/")
    public String getSelectedTypeItems(Model model, @RequestParam String itemType, @PathVariable(value="selectedItemType") String selectedItem) {

        model.addAttribute("selectedItemType", itemType);

        List<ItemDataModel> itemsMapped = itemMapper.getItems(ItemClassesAndNamesLists.getAllItemsOfSelectedType(selectedItem, itemType));
        model.addAttribute("itemsMapped", itemsMapped);

        return "items";
    }

}
