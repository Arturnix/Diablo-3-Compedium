package pl.arturzgodka.controllers;

import java.util.HashMap;
import java.util.Map;

public class ItemsNamesRepository {

    private final static Map<String, String> itemsNamesAndSlugs = new HashMap<String, String>() {{
        //armor
        put("Godly Plate of the Whale", "godly-plate-of-the-whale-p43_RetroArmor_001");
        put("Arkaine's Valor", "arkaines-valor-p43_RetroArmor_002");
        put("Mystery Chest Armor", "mystery-chest-armor-PH_ChestArmor");
        put("Cloth Tunic", "cloth-tunic-ChestArmor_001");
        put("Leather Doublet", "leather-doublet-ChestArmor_002");
        put("Heart of Iron", "heart-of-iron-P4_Unique_Chest_018");
    }};

    public static String getSearchedItemName(String searchItemName) {
        return itemsNamesAndSlugs.get(searchItemName);
    }

}
