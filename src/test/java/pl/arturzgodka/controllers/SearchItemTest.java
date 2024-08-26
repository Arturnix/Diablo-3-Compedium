package pl.arturzgodka.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import pl.arturzgodka.datamodel.ItemArmorDataModel;
import pl.arturzgodka.datamodel.ItemDataModel;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.arturzgodka.controllers.SearchItem.*;

public class SearchItemTest {

    @Test
    public void shouldReplaceSpaceWithHyphenToBuildCorrectApiPath() {
        //given
        String itemName = "Heart of iron";

        //when
        String convertedItemName = convertProvidedItemNameToSearchToAPIFormat(itemName);

        //then
        assertThat(convertedItemName, not(containsString(" ")));
        assertThat(convertedItemName, containsString("-"));
        assertThat(convertedItemName, is("heart-of-iron"));
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenNullItemNameProvidedToConvertItemName() {
        //given
        String itemName = null;

        //when
        //then
        assertThrows(NullPointerException.class, () -> convertProvidedItemNameToSearchToAPIFormat(itemName));
    }

    @Test
    public void shouldReturnEmptyStringWhenEmptyItemNameProvided() {
        //given
        String itemName = "";

        //when
        String convertedItemName = convertProvidedItemNameToSearchToAPIFormat(itemName);

        //then
        assertThat(convertedItemName, is(""));
        assertThat(convertedItemName, notNullValue());
    }

    @Test
    public void shouldReturnMatchedItemsList() {
        //given
        String itemName = "heart";

        //when
        List<List<String>> matchedItemNames = getMatchedItemsToAPI(itemName);

        //then
        assertThat(matchedItemNames, hasSize(3));
        assertThat(matchedItemNames.get(0), everyItem(containsString("heart")));
        assertThat(matchedItemNames.get(1), everyItem(containsString("heart")));
        assertThat(matchedItemNames.get(2), everyItem(containsString("heart")));
    }

    @Test
    public void shouldReturnEmptyListWhenNoMatchesFoundForProvidedItemName() {
        //given
        String itemName = "abc";

        //when
        List<List<String>> matchedItemNames = getMatchedItemsToAPI(itemName);

        //then
        assertThat(matchedItemNames, notNullValue());
        assertThat(matchedItemNames, hasSize(0));
        assertThat(matchedItemNames, empty());
    }

    @Test
    public void shouldReturnListOfAllItemsWhenEmptyStringProvidedAsItemName() {
        //given
        String itemName = "";

        //when
        List<List<String>> matchedItemNames = getMatchedItemsToAPI(itemName);

        //then
        assertThat(matchedItemNames, notNullValue());
        assertThat(matchedItemNames, hasSize(11)); //This value will change if new types are added.
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenNullItemNameProvidedToReturnMatchedItemNames() {
        //given
        String itemName = null;

        //when
        //then
        assertThrows(NullPointerException.class, () -> getMatchedItemsToAPI(itemName));
    }

    @Test
    public void shouldReturnMatchedItems() {
        //given
        String itemName = "heart-of-iron";
        List<ItemDataModel> itemsMatched = new ArrayList<>();
        ItemArmorDataModel itemArmorDataModel = new ItemArmorDataModel(null, null, "Heart of Iron", "87 - 107");

        //when
        List<List<String>> matchedItemNames = getMatchedItemsToAPI(itemName);
        itemsMatched.add(itemArmorDataModel);


        //then
        try (MockedStatic<SearchItem> searchItemMockedStatic = Mockito.mockStatic(SearchItem.class)) {
            searchItemMockedStatic.when(() -> SearchItem.getSearchedItems(matchedItemNames))
                    .thenReturn(itemsMatched);

            assertThat(getSearchedItems(matchedItemNames), hasSize(1));
            assertThat(getSearchedItems(matchedItemNames).get(0), instanceOf(ItemArmorDataModel.class));
            assertThat(getSearchedItems(matchedItemNames).get(0).getName(), equalTo("Heart of Iron"));
        }
    }

    @Test
    public void shouldReturnEmptyListWhenNoMatchFoundForProvidedItemName() {
        //given
        String itemName = "noMatch";
        List<ItemDataModel> itemsMatched = new ArrayList<>();

        //when
        List<List<String>> matchedItemNames = getMatchedItemsToAPI(itemName);

        //then
        try (MockedStatic<SearchItem> searchItemMockedStatic = Mockito.mockStatic(SearchItem.class)) {
            searchItemMockedStatic.when(() -> SearchItem.getSearchedItems(matchedItemNames))
                    .thenReturn(itemsMatched);

            assertThat(getSearchedItems(matchedItemNames), notNullValue());
            assertThat(getSearchedItems(matchedItemNames), hasSize(0));
            assertThat(getSearchedItems(matchedItemNames), empty());
        }
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenNullProvidedToGetMatchedItems() {
        //given
        List<List<String>> matchedItemNames = null;

        //when
        //then
        try (MockedStatic<SearchItem> searchItemMockedStatic = Mockito.mockStatic(SearchItem.class)) {
            searchItemMockedStatic.when(() -> SearchItem.getSearchedItems(matchedItemNames))
                    .thenThrow(NullPointerException.class);

            assertThrows(NullPointerException.class, () -> getSearchedItems(matchedItemNames));
        }
    }

}
