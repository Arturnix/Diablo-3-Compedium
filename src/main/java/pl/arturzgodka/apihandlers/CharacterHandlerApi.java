package pl.arturzgodka.apihandlers;

import pl.arturzgodka.token.FetchToken;
import pl.arturzgodka.token.Token;

public class CharacterHandlerApi {
    //Hero ID: 170761702
    //zrobic jako static?
    public static String generateRequest(String battleTag, String heroId, FetchToken fetchToken) { //token przypisywać ze zmiennej. Pobieram token kiedy program startuje i wrzucam go do stałej.

        String apiEndpoint = BaseUrlParts.BASE_PROFILE_API + battleTag.replace('#', '-') +
                BaseUrlParts.BASE_HERO_API + heroId;
        String localeAndToken = BaseUrlParts.BASE_LOCALE_AND_TOKEN + Token.getAccess_token();

        return fetchToken.fetchAPIResourceRequest(apiEndpoint + localeAndToken);
    }
}