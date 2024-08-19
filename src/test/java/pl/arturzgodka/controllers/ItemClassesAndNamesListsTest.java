package pl.arturzgodka.controllers;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static pl.arturzgodka.controllers.ItemClassesAndNamesLists.getAllItemsOfSelectedType;
import static pl.arturzgodka.controllers.ItemClassesAndNamesLists.selectedItemsNamesToApi;

public class ItemClassesAndNamesListsTest {

    @Test
    void shouldReturnGreaterThan0SizeOfArmorTypeItems() {
        //given
        Set<String> armorItemTypes = ItemClassesAndNamesLists.getItemTypesNames("Armor");

        //when
        //then
        assertFalse(armorItemTypes.isEmpty());
    }

    @Test
    void shouldReturnGreaterThan0SizeOfWeaponTypeItems() {
        //given
        Set<String> weaponItemTypes = ItemClassesAndNamesLists.getItemTypesNames("Weapon");

        //when
        //then
        assertFalse(weaponItemTypes.isEmpty());
    }

    @Test
    void shouldThrowExceptionWhenItemTypeDoesntExistInMapAsAKey() {
        //given
        //when
        //then
        assertThrows(NullPointerException.class, () -> ItemClassesAndNamesLists.getItemTypesNames("wrongItemTypeProvided"));
    }

    @Test
    void shouldReturnArmorsList() {
        //given
        List<String> armors = getAllItemsOfSelectedType("Armor", "Armors");

        //when
        //then
        assertFalse(armors.isEmpty());
    }

    @Test
    void shouldReturnArmorItem() {
        //given
        List<String> armors = getAllItemsOfSelectedType("Armor", "Armors");

        //when
        //then
        assertTrue(armors.contains("godly-plate-of-the-whale-p43_RetroArmor_001"));
    }

    @Test
    void shouldReturnMacesList() {
        //given
        List<String> maces = getAllItemsOfSelectedType("Weapon", "Maces");

        //when
        //then
        assertFalse(maces.isEmpty());
    }

    @Test
    void shouldReturnMaceItem() {
        //given
        List<String> maces = getAllItemsOfSelectedType("Weapon", "Maces");

        //when
        //then
        assertTrue(maces.contains("club-Mace_1H_001"));
    }

    @Test
    void shouldReturnMatchedItemsList() {
        //given
        List<List<String>> matchedItemsFromSearchForm = selectedItemsNamesToApi("heart");

        //when
        //then
        assertThat(matchedItemsFromSearchForm.size(), is(3));
        assertThat(matchedItemsFromSearchForm.get(0).size(), is(5));
        assertThat(matchedItemsFromSearchForm.get(1).size(), is(1));
        assertThat(matchedItemsFromSearchForm.get(2).size(), is(1));
    }

    @Test
    void shouldReturnMatchedItem() {
        //given
        List<List<String>> matchedItemsFromSearchForm = selectedItemsNamesToApi("heart-of-iron");

        //when
        //then
        assertTrue(matchedItemsFromSearchForm.get(0).contains("heart-of-iron-P4_Unique_Chest_018"));
    }

    @Test
    void shouldReturnEmptyListWhenItemNotFound() {
        //given
        List<List<String>> matchedItemsFromSearchForm = selectedItemsNamesToApi("123");

        //when
        //then
        assertTrue(matchedItemsFromSearchForm.isEmpty());
    }
}
