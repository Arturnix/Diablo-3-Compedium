package pl.arturzgodka.apihandlers;

import pl.arturzgodka.token.FetchToken;
import pl.arturzgodka.token.Token;

public class SkillHandlerApi {

    //barbarian - hero class
    //bash - skill slug
    public static String generateRequest(String heroClassSlug, String skillSlug, FetchToken fetchToken) { //token przypisywać ze zmiennej. Pobieram token kiedy program startuje i wrzucam go do stałej.

        String apiEndpoint = BaseUrlParts.getBaseDataHeroApi() + heroClassSlug + BaseUrlParts.getBaseSkillApi() + skillSlug;
        String localeAndToken = BaseUrlParts.getBaseLocaleAndToken() + Token.getAccess_token();

        return fetchToken.fetchAPIResourceRequest(apiEndpoint + localeAndToken);
    }
}
