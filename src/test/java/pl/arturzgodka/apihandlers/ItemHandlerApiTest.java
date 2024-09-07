package pl.arturzgodka.apihandlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.arturzgodka.token.FetchToken;
import pl.arturzgodka.token.Token;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class ItemHandlerApiTest {

    @Mock
    private FetchToken testObject;
    @Mock
    private ItemHandlerApi testItemHandlerApi;

    @Test
    public void shouldBuildCorrectRequestUrl() {
        //given
        String itemSlugAndId = "leorics-crown-Unique_Helm_002_p1";
        String token = "abc123";

        //when
        String requestUrl = BaseUrlParts.BASE_ITEM_API + itemSlugAndId + BaseUrlParts.BASE_LOCALE_AND_TOKEN + token;

        //then
        assertThat(requestUrl, is("https://eu.api.blizzard.com/d3/data/item/leorics-crown-Unique_Helm_002_p1/?locale=en_EU&access_token=abc123"));
    }

    @Test
    public void correctItemFetchedContainsProvidedSlugAndId() {
        //given
        String itemSlugAndId = "leorics-crown-Unique_Helm_002_p1";
        String token = Token.getAccess_token();
        String requestUrl = BaseUrlParts.BASE_ITEM_API + itemSlugAndId + BaseUrlParts.BASE_LOCALE_AND_TOKEN + token;

        //when
        Mockito.when(testObject.fetchAPIResourceRequest(requestUrl)).thenReturn("Leoric's Crown");

        //then
        Assertions.assertTrue(testObject.fetchAPIResourceRequest(requestUrl).contains("Leoric's Crown"));
    }

    @Test
    public void fetchItemFailedMissedCredentialsNotContainDesiredField() {
        //given
        String requestUrl = BaseUrlParts.BASE_ITEM_API
                + BaseUrlParts.BASE_LOCALE_AND_TOKEN;

        //when
        Mockito.when(testObject.fetchAPIResourceRequest(requestUrl)).thenReturn("");
        String fetchedItem = testObject.fetchAPIResourceRequest(requestUrl);

        //then
        Assertions.assertFalse(fetchedItem.contains("Leoric's Crown"));
    }

    @Test
    public void fetchItemShouldFailWhenMissedCredentials() {
        //given
        String itemSlugAndId = "leorics-crown-Unique_Helm_002_p1";
        String token = Token.getAccess_token();

        String requestUrlOK = BaseUrlParts.BASE_ITEM_API + itemSlugAndId
                + BaseUrlParts.BASE_LOCALE_AND_TOKEN + token;

        String requestUrlNOK = BaseUrlParts.BASE_ITEM_API
                + BaseUrlParts.BASE_LOCALE_AND_TOKEN;

        //when
        Mockito.when(testObject.fetchAPIResourceRequest(requestUrlOK)).thenReturn("Leoric's Crown");
        Mockito.when(testObject.fetchAPIResourceRequest(requestUrlNOK)).thenReturn("");

        String fetchedHeroOK = testObject.fetchAPIResourceRequest(requestUrlOK);
        String fetchedHeroNOK = testObject.fetchAPIResourceRequest(requestUrlNOK);

        //then
        Assertions.assertNotEquals(fetchedHeroOK, fetchedHeroNOK);
    }

    @Test
    public void fetchItemShouldFailWhenWrongSlugAndIdProvided() {
        //given
        String itemSlugAndIdOK = "leorics-crown-Unique_Helm_002_p1";
        String itemSlugAndIdNOK = " ";

        //when
        Mockito.when(testItemHandlerApi.generateRequest(itemSlugAndIdOK, testObject))
                .thenReturn("Leoric's Crown");
        Mockito.when(testItemHandlerApi.generateRequest(itemSlugAndIdNOK, testObject))
                .thenReturn("");

        String fetchedHeroOK = testItemHandlerApi.generateRequest(itemSlugAndIdOK, testObject);
        String fetchedHeroNOK = testItemHandlerApi.generateRequest(itemSlugAndIdNOK, testObject);

        //then
        Assertions.assertNotEquals(fetchedHeroOK, fetchedHeroNOK);
    }

    @Test
    public void fetchItemShouldFailWhenNullItemSlugAndIdProvided() {
        //given
        String itemSlugAndIdOK = "leorics-crown-Unique_Helm_002_p1";
        String itemSlugAndIdNull = null;

        //when
        Mockito.when(testItemHandlerApi.generateRequest(itemSlugAndIdOK, testObject))
                .thenReturn("Leoric's Crown");
        Mockito.when(testItemHandlerApi.generateRequest(itemSlugAndIdNull, testObject))
                .thenReturn("");

        String fetchedHeroOK = testItemHandlerApi.generateRequest(itemSlugAndIdOK, testObject);
        String fetchedHeroNOK = testItemHandlerApi.generateRequest(itemSlugAndIdNull, testObject);

        //then
        Assertions.assertNotEquals(fetchedHeroOK, fetchedHeroNOK);
    }
}
