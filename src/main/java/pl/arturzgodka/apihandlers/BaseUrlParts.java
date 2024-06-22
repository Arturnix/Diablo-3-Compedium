package pl.arturzgodka.apihandlers;

public class BaseUrlParts {

    public static final String BASE_BLIZZARD_URL = "https://eu.api.blizzard.com/d3/";
    public static final String BASE_MEDIA_BLIZZARD_URL = "http://media.blizzard.com/d3/icons/skills/64/";
    public static final String BASE_PROFILE_API = BASE_BLIZZARD_URL + "profile/";
    public static final String BASE_HERO_API = "/hero/";
    public static final String BASE_SKILL_API = "/skill/";
    public static final String BASE_ITEM_API = BASE_BLIZZARD_URL + "data/item/";
    public static final String BASE_DATA_HERO_API = BASE_BLIZZARD_URL + "data/hero/";
    public static final String BASE_LOCALE_AND_TOKEN = "/?locale=pl_PL&access_token="; //zawsze wystepuja razem w stringu wiec dalem do jednego stringa
}
