package pl.arturzgodka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.arturzgodka.apihandlers.ItemHandlerApi;
import pl.arturzgodka.datamodel.ItemArmorDataModel;
import pl.arturzgodka.datamodel.ItemDataModel;
import pl.arturzgodka.jsonmappers.ItemMapper;

import java.util.List;
import java.util.Set;

@Controller
public class ItemsController {

    private final ItemMapper itemMapper = new ItemMapper();

    @RequestMapping("/itemsTypes.html")
    public String getItemTypes(Model model) {
        model.addAttribute("itemTypesList", ItemClassesAndNamesLists.itemTypes);
        return "itemsTypes";
    }

    @RequestMapping(value="/{itemTypes}", method = RequestMethod.GET)
    public String getItemTypesNames(Model model, @PathVariable(value="itemTypes") String itemType) {

        Set<String> itemTypeNames = ItemClassesAndNamesLists.getItemTypesNames(itemType);
        model.addAttribute("itemTypesNames", itemTypeNames);

        return "itemTypes";
    }

    @RequestMapping("/Armor/")
    public String getArmorTypeItems(Model model, @RequestParam String itemType) {

        //zrobic w petli dla kazdej listy przedmiotow z mapy
        List<ItemArmorDataModel> itemsMapped = itemMapper.getItemsOfArmorType(ItemClassesAndNamesLists.getArmorSelectedItemLists("Armor", itemType));

        model.addAttribute("selectedItemType", itemType);
        model.addAttribute("itemsMapped", itemsMapped);

        return "items";
    }
}
