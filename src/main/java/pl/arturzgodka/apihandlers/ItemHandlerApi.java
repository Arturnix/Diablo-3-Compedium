package pl.arturzgodka.apihandlers;

import pl.arturzgodka.token.FetchToken;
import pl.arturzgodka.token.Token;

public class ItemHandlerApi {
    public static String generateRequest(String itemSlugAndId, FetchToken fetchToken) {

        String apiEndpoint = BaseUrlParts.BASE_ITEM_API + itemSlugAndId;
        String localeAndToken = BaseUrlParts.BASE_LOCALE_AND_TOKEN + Token.getAccess_token();

        return fetchToken.fetchAPIResourceRequest(apiEndpoint + localeAndToken);
    }
}
