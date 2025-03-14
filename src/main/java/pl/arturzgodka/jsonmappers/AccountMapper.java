package pl.arturzgodka.jsonmappers;

import pl.arturzgodka.datamodel.AccountDataModel;
import pl.arturzgodka.datamodel.CharacterDataModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountMapper {

    public AccountDataModel mapAccountToDataModel(String accountData) {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = null;

        try {
            node = objectMapper.readTree(accountData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return new AccountDataModel(
                node.get("battleTag").asText(),
                node.get("paragonLevel").asInt(),
                node.get("guildName").asText(),
                fetchHeroesList(node),
                node.get("highestHardcoreLevel").asInt(),
                sumEliteKills(node)
        );
    }

    public List<CharacterDataModel> fetchHeroesList(String accountData) {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = null;

        try {
            node = objectMapper.readTree(accountData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return fetchHeroesList(node);
    }

    private Map<String, Integer> sumEliteKills(JsonNode node) {

        int kills = 0;
        for(int i = 0; i < node.get("heroes").size(); i++) {
            kills += Integer.parseInt(node.get("heroes").get(i).get("kills").get("elites").asText());
        }
        Map<String, Integer> mapKills = new HashMap<String, Integer>();
        mapKills.put("elites", kills);

        return mapKills;
    }

    private List<CharacterDataModel> fetchHeroesList(JsonNode node) {

        List<CharacterDataModel> heroes = new ArrayList<>();
        for(int i = 0; i < node.get("heroes").size(); i++) {
                CharacterDataModel characterDataModel = new CharacterDataModel(
                        node.get("heroes").get(i).get("id").asInt(),
                        node.get("heroes").get(i).get("name").asText(),
                        node.get("heroes").get(i).get("class").asText(),
                        node.get("heroes").get(i).get("level").asInt(),
                        node.get("heroes").get(i).get("paragonLevel").asInt(),
                        node.get("heroes").get(i).get("hardcore").asBoolean(),
                        node.get("heroes").get(i).get("gender").asInt()
                );
                heroes.add(characterDataModel);
            }
        return heroes;
    }
}
