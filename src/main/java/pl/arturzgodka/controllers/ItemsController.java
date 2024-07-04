package pl.arturzgodka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@Controller
public class ItemsController {

    @RequestMapping("/itemsTypes.html")
    public String getItemTypes(Model model) {
        model.addAttribute("itemTypesList", ItemClassesAndNamesLists.itemTypes);
        return "itemsTypes";
    }

    @RequestMapping(value="/{itemTypes}", method = RequestMethod.GET)
    public String getItemTypesNames(Model model, @PathVariable(value="itemTypes") String itemType) {

        Set<String> itemTypeNames = ItemClassesAndNamesLists.getItemTypesNames(itemType);
        model.addAttribute("armorNames", itemTypeNames);

        return "itemTypes";
    }
}
