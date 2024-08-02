package pl.arturzgodka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.arturzgodka.apihandlers.ItemHandlerApi;
import pl.arturzgodka.datamodel.ItemArmorDataModel;
import pl.arturzgodka.datamodel.ItemDataModel;
import pl.arturzgodka.datamodel.ItemWeaponDataModel;
import pl.arturzgodka.jsonmappers.ItemMapper;
import pl.arturzgodka.token.FetchToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static pl.arturzgodka.controllers.ItemClassesAndNamesLists.selectedItemNameToApi;
import static pl.arturzgodka.controllers.ItemsNamesRepository.getSearchedItemName;

@Controller
public class ItemsController {

    private final ItemMapper itemMapper = new ItemMapper();

    @RequestMapping("/itemsTypes.html")
    public String getItemTypes(Model model) {
        model.addAttribute("itemTypesList", ItemClassesAndNamesLists.itemTypes);
        return "itemsTypes";
    }

    @GetMapping("/singleItem")
    public String searchItemForm(Model model, @RequestParam String itemSearchName) {

        //TODO ujednolicic mapowanie obiektow i view dla nich czyli niech bedzie zwracana jedna templatka i dac pola tylko opcjonalnie w zaleznosci jakiego typu obiekt zostal zwrocony.

        FetchToken fetchToken = new FetchToken();
        String convertItemSearchName = itemSearchName.toLowerCase().replace(" ", "-").replace("'", "");
        List<List<String>> itemNameToApi = ItemClassesAndNamesLists.selectedItemNameToApi(convertItemSearchName);

        List<ItemDataModel> itemsMapped = new ArrayList<ItemDataModel>();

        for (List<String> s : itemNameToApi) {
            for(String x : s) {
                String itemJSON = ItemHandlerApi.generateRequest(x, fetchToken);
                itemsMapped.add(itemMapper.mapItemToDataModelSearchItem(itemJSON));
            }
        }

        model.addAttribute("itemsMapped", itemsMapped);

        return "items";
    }

    @RequestMapping(value="/{itemTypes}", method = RequestMethod.GET)
    public String getItemTypesNames(Model model, @PathVariable(value="itemTypes") String itemType) {

        Set<String> itemTypeNames = ItemClassesAndNamesLists.getItemTypesNames(itemType);
        model.addAttribute("selectedItemType", itemType);
        model.addAttribute("itemTypesNames", itemTypeNames);

        return "itemTypes";
    }

    @RequestMapping("/{selectedItemType}/")
    public String getSelectedTypeItems(Model model, @RequestParam String itemType, @PathVariable(value="selectedItemType") String selectedItem) {

        model.addAttribute("selectedItemType", itemType);

        if (selectedItem.equals("Armor")) {
            List<ItemArmorDataModel> itemsMapped = itemMapper.getItemsOfArmorType(ItemClassesAndNamesLists.getSelectedItemList(selectedItem, itemType));
            model.addAttribute("itemsMapped", itemsMapped);

            return "itemsArmor";

        } else {
            List<ItemWeaponDataModel> itemsMapped = itemMapper.getItemsOfWeaponType(ItemClassesAndNamesLists.getSelectedItemList(selectedItem, itemType));
            model.addAttribute("itemsMapped", itemsMapped);

            return "itemsWeapon";
        }
    }
}
