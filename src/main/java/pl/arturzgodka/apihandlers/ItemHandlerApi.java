package pl.arturzgodka.apihandlers;

import pl.arturzgodka.token.FetchToken;
import pl.arturzgodka.token.Token;

public class ItemHandlerApi {
    //corrupted-ashbringer-Unique_Sword_2H_104_x1
    //veil-of-steel-p43_RetroHelm_003
    public static String generateRequest(String itemSlugAndId, FetchToken fetchToken) { //token przypisywać ze zmiennej. Pobieram token kiedy program startuje i wrzucam go do stałej.

        String apiEndpoint = BaseUrlParts.getBaseItemApi() + itemSlugAndId;
        String localeAndToken = BaseUrlParts.getBaseLocaleAndToken() + Token.getAccess_token();

        return fetchToken.fetchAPIResourceRequest(apiEndpoint + localeAndToken);
    }
}
