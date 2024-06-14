package pl.arturzgodka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.arturzgodka.apihandlers.BaseUrlParts;
import pl.arturzgodka.apihandlers.SkillHandlerApi;
import pl.arturzgodka.token.FetchToken;
import pl.arturzgodka.token.Token;

@ExtendWith(MockitoExtension.class)
public class SkillHandlerApiTest {

    @Mock
    private FetchToken testObject;
    @Mock
    private SkillHandlerApi testSkillHandlerApi;

    @Test
    public void correctSkillFetchedContainsProvidedSlug() {

        String heroClass = "barbarian";
        String skillSlug = "bash";
        String token = Token.getAccess_token();
        String requestUrl = "https://eu.api.blizzard.com/d3/data/hero/" + heroClass + "/skill/" + skillSlug +
                "?locale=pl_PL&access_token=" + token;

        Mockito.when(testObject.fetchAPIResourceRequest(requestUrl)).thenReturn("bash");

        Assertions.assertTrue(testObject.fetchAPIResourceRequest(requestUrl).contains("bash"));
    }

    @Test
    public void fetchSkillFailedMissedCredentialsNotContainDesiredField() {

        String requestUrl = BaseUrlParts.getBaseDataHeroApi() + BaseUrlParts.getBaseSkillApi()
                + BaseUrlParts.getBaseLocaleAndToken();

        Mockito.when(testObject.fetchAPIResourceRequest(requestUrl)).thenReturn("");

        String fetchedSkill = testObject.fetchAPIResourceRequest(requestUrl);

        Assertions.assertFalse(fetchedSkill.contains("slug"));
    }

    @Test
    public void fetchSkillFailedMissedCredentials() {

        String requestUrlOK = BaseUrlParts.getBaseDataHeroApi() + "barbarian"
                + BaseUrlParts.getBaseSkillApi() + "bash"
                + BaseUrlParts.getBaseLocaleAndToken() + Token.getAccess_token();

        String requestUrlNOK = BaseUrlParts.getBaseDataHeroApi()
                + BaseUrlParts.getBaseSkillApi()
                + BaseUrlParts.getBaseLocaleAndToken();

        Mockito.when(testObject.fetchAPIResourceRequest(requestUrlOK)).thenReturn("bash");
        Mockito.when(testObject.fetchAPIResourceRequest(requestUrlNOK)).thenReturn("");

        String fetchedHeroOK = testObject.fetchAPIResourceRequest(requestUrlOK);
        String fetchedHeroNOK = testObject.fetchAPIResourceRequest(requestUrlNOK);

        Assertions.assertNotEquals(fetchedHeroOK, fetchedHeroNOK);
    }

    @Test
    public void fetchSkillFailedWrongSlugProvided() {

        Mockito.when(testSkillHandlerApi.generateRequest("barbarian", "bash", testObject))
                .thenReturn("bash");
        Mockito.when(testSkillHandlerApi.generateRequest("barbarian", " ", testObject))
                .thenReturn("");

        String fetchedHeroOK = testSkillHandlerApi.generateRequest("barbarian", "bash", testObject);
        String fetchedHeroNOK = testSkillHandlerApi.generateRequest("barbarian", " ", testObject);

        Assertions.assertNotEquals(fetchedHeroOK, fetchedHeroNOK);
    }

    @Test
    public void fetchSkillFailedWrongHeroClassProvided() {

        Mockito.when(testSkillHandlerApi.generateRequest("barbarian", "bash", testObject))
                .thenReturn("bash");
        Mockito.when(testSkillHandlerApi.generateRequest(" ", "bash", testObject))
                .thenReturn("");

        String fetchedHeroOK = testSkillHandlerApi.generateRequest("barbarian", "bash", testObject);
        String fetchedHeroNOK = testSkillHandlerApi.generateRequest(" ", "bash", testObject);

        Assertions.assertNotEquals(fetchedHeroOK, fetchedHeroNOK);
    }

    @Test
    public void fetchSkillFailedNullSlugProvided() {

        Mockito.when(testSkillHandlerApi.generateRequest("barbarian", "bash", testObject))
                .thenReturn("bash");
        Mockito.when(testSkillHandlerApi.generateRequest("barbarian", null, testObject))
                .thenReturn("");

        String fetchedHeroOK = testSkillHandlerApi.generateRequest("barbarian", "bash", testObject);
        String fetchedHeroNOK = testSkillHandlerApi.generateRequest("barbarian", null, testObject);

        Assertions.assertNotEquals(fetchedHeroOK, fetchedHeroNOK);
    }
}
