package pl.arturzgodka.apihandlers;

import pl.arturzgodka.token.FetchToken;
import pl.arturzgodka.token.Token;

public class SkillHandlerApi {
    public static String generateRequest(String heroClassSlug, String skillSlug, FetchToken fetchToken) { //TODO token przypisywać ze zmiennej. Pobieram token kiedy program startuje i wrzucam go do stałej.

        String apiEndpoint = BaseUrlParts.BASE_DATA_HERO_API + heroClassSlug + BaseUrlParts.BASE_SKILL_API + skillSlug;
        String localeAndToken = BaseUrlParts.BASE_LOCALE_AND_TOKEN + Token.getAccess_token();

        return fetchToken.fetchAPIResourceRequest(apiEndpoint + localeAndToken);
    }
}
