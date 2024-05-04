package pl.arturzgodka.apihandlers;

import pl.arturzgodka.token.FetchToken;
import pl.arturzgodka.token.Token;

public class HeroHandlerApi {
    //Hero ID: 170761702
    //zrobic jako static?
    public static String generateRequest(String battleTag, String heroId, FetchToken fetchToken) { //token przypisywać ze zmiennej. Pobieram token kiedy program startuje i wrzucam go do stałej.

        String apiEndpoint = BaseUrlParts.getBaseProfileApi() + battleTag.replace('#', '-') +
                BaseUrlParts.getBaseHeroApi() + heroId;
        String localeAndToken = BaseUrlParts.getBaseLocaleAndToken() + Token.getAccess_token();

        return fetchToken.fetchAPIResourceRequest(apiEndpoint + localeAndToken);
    }
}