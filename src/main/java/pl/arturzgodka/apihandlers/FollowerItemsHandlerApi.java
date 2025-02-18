package pl.arturzgodka.apihandlers;

import pl.arturzgodka.token.FetchToken;
import pl.arturzgodka.token.Token;

public class FollowerItemsHandlerApi {
    //Hero ID: 170761702
    public static String generateRequest(String battleTag, String heroId, FetchToken fetchToken) {

        String apiEndpoint = BaseUrlParts.BASE_PROFILE_API + battleTag.replace('#', '-') +
                BaseUrlParts.BASE_HERO_API + heroId;
        String localeAndToken = BaseUrlParts.BASE_LOCALE_AND_TOKEN_FOR_FOLLOWERS_ITEMS + Token.getAccess_token();

        return fetchToken.fetchAPIResourceRequest(apiEndpoint + localeAndToken);
    }
}
