package pl.arturzgodka;

import pl.arturzgodka.apihandlers.AccountHandlerApi;
import pl.arturzgodka.apihandlers.BaseUrlParts;
import pl.arturzgodka.token.FetchToken;
import pl.arturzgodka.token.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class AccountHandlerApiTest {

    @Mock //wskazac dokladnie, niezaleznie od stanu obiektu. Nie jest rzeczywsitym obiektem, nie ma żadnego stanu. Z punktu widzenia programu to jest null
    private FetchToken testObject;
    @Mock
    private AccountHandlerApi testAccountHandlerApi;

    @Test
    public void correctAccountFetchedContainsProvidedBattleTag() {

        String battleTag = "Ghall#2523";
        String urlRequest = "https://eu.api.blizzard.com/d3/profile/Ghall-2523/?locale=pl_PL&access_token=";
        String token = testObject.requestToken().getAccess_token();

        Mockito.when(testObject.fetchAPIResourceRequest(
                urlRequest + token)).thenReturn("Ghall#2523");

        Assertions.assertTrue(testObject.fetchAPIResourceRequest(
                urlRequest + token).contains(battleTag));
    }

    @Test
    public void fetchAccountFailedMissedCredentialsNotContainDesiredChar() {

        Mockito.when(testObject.fetchAPIResourceRequest(BaseUrlParts.BASE_PROFILE_API
                        + BaseUrlParts.BASE_LOCALE_AND_TOKEN))
                .thenReturn("");

        String fetchedAccount = testObject.fetchAPIResourceRequest(BaseUrlParts.BASE_PROFILE_API
                 + BaseUrlParts.BASE_LOCALE_AND_TOKEN);

        Assertions.assertFalse(fetchedAccount.contains("#"));
    }

    @Test
    public void fetchAccountFailedMissedCredentials() {

        Mockito.when(testObject.fetchAPIResourceRequest(BaseUrlParts.BASE_PROFILE_API + "Ghall-2523"
                        + BaseUrlParts.BASE_LOCALE_AND_TOKEN + Token.getAccess_token()))
                .thenReturn("Ghall#2523");

        Mockito.when(testObject.fetchAPIResourceRequest(BaseUrlParts.BASE_PROFILE_API + BaseUrlParts.BASE_LOCALE_AND_TOKEN))
                .thenReturn("");

        String fetchedAccountOK = testObject.fetchAPIResourceRequest(BaseUrlParts.BASE_PROFILE_API + "Ghall-2523"
                + BaseUrlParts.BASE_LOCALE_AND_TOKEN + Token.getAccess_token());

        String fetchedAccountNOK = testObject.fetchAPIResourceRequest(BaseUrlParts.BASE_PROFILE_API + BaseUrlParts.BASE_LOCALE_AND_TOKEN);

        Assertions.assertNotEquals(fetchedAccountOK, fetchedAccountNOK);
    }

    @Test
    public void fetchAccountFailedWrongBattleTagProvided() {

        Mockito.when(testAccountHandlerApi.generateRequest("Ghall-2523", testObject))
                .thenReturn("Ghall#2523");

        Mockito.when(testAccountHandlerApi.generateRequest(" ", testObject))
                .thenReturn("");

        String fetchedAccountOK = testAccountHandlerApi.generateRequest("Ghall-2523", testObject);
        String fetchedAccountNOK = testAccountHandlerApi.generateRequest(" ", testObject);

        Assertions.assertNotEquals(fetchedAccountOK, fetchedAccountNOK);
    }

    @Test
    public void fetchAccountFailedNullBattleTagProvided() {

        Mockito.when(testAccountHandlerApi.generateRequest("Ghall-2523", testObject))
                .thenReturn("Ghall#2523");

        /*Mockito.when(testAccountHandlerApi.generateRequest(null, testObject))
                .thenReturn("");*/
        String battleTag = null;
       Mockito.when(testObject.fetchAPIResourceRequest(BaseUrlParts.BASE_PROFILE_API + battleTag
                + BaseUrlParts.BASE_LOCALE_AND_TOKEN + Token.getAccess_token()))
                .thenReturn("");

        String fetchedAccountOK = testAccountHandlerApi.generateRequest("Ghall-2523", testObject);
        String fetchedAccountNOK = testObject.fetchAPIResourceRequest(BaseUrlParts.BASE_PROFILE_API + battleTag
                + BaseUrlParts.BASE_LOCALE_AND_TOKEN + Token.getAccess_token());

        Assertions.assertNotEquals(fetchedAccountOK, fetchedAccountNOK);
    }

    @Test
    public void fetchAccountFailedNullBattleTagProvidedThrowsException() {

        AccountHandlerApi testAccountHandlerApi = new AccountHandlerApi();
        String battleTag = null;

        Exception exception = Assertions.assertThrows(NullPointerException.class, ()-> {
            testAccountHandlerApi.generateRequest(battleTag, testObject);
        });

        String expectedMessage = "Cannot invoke \"String.replace(char, char)\" because \"battleTag\" is null";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}
