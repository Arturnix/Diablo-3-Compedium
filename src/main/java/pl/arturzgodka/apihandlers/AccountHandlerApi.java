package pl.arturzgodka.apihandlers;


import pl.arturzgodka.token.FetchToken;
import pl.arturzgodka.token.Token;

public class AccountHandlerApi {
    public static String generateRequest(String battleTag, FetchToken fetchToken) {

        String apiEndpoint = BaseUrlParts.BASE_PROFILE_API + battleTag.replace('#', '-');
        String localeAndToken = BaseUrlParts.BASE_LOCALE_AND_TOKEN + Token.getAccess_token();

        return fetchToken.fetchAPIResourceRequest(apiEndpoint + localeAndToken);
    }
}