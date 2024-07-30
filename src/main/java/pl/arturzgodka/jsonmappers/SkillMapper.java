package pl.arturzgodka.jsonmappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.arturzgodka.apihandlers.BaseUrlParts;
import pl.arturzgodka.apihandlers.SkillHandlerApi;
import pl.arturzgodka.datamodel.HeroSkillDataModel;
import pl.arturzgodka.datamodel.SkillDataModel;
import pl.arturzgodka.token.FetchToken;

import java.util.ArrayList;
import java.util.List;

public class SkillMapper {

    public List<HeroSkillDataModel> mapSkillsToDataModel(String heroClass, List<String> heroSkills) {

        List<HeroSkillDataModel> skills = new ArrayList<>();
        FetchToken fetchToken = new FetchToken();

        for (String skill : heroSkills) {
            HeroSkillDataModel heroSkillDataModel = fetchSkillsAndRunes(SkillHandlerApi.generateRequest(heroClass, skill, fetchToken));
            skills.add(heroSkillDataModel);
        }

        return skills;
    }

    private HeroSkillDataModel fetchSkillsAndRunes(String accountData) {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = null;

        try {
            node = objectMapper.readTree(accountData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return fetchSkill(node);
    }


    private HeroSkillDataModel fetchSkill(JsonNode node) {

        return new HeroSkillDataModel(
                node.get("skill").get("name").asText(),
                node.get("skill").get("level").asInt(),
                node.get("skill").get("description").asText(),
                BaseUrlParts.BASE_MEDIA_BLIZZARD_URL + node.get("skill").get("icon").asText() + ".png",
                fetchSkillRunes(node)
        );
    }

    private List<SkillDataModel> fetchSkillRunes(JsonNode node) {

        List<SkillDataModel> runes = new ArrayList<>();

        if (node.has("runes")) {
            for (int i = 0; i < node.get("runes").size(); i++) {
                SkillDataModel skillDataModel = new SkillDataModel(
                        node.get("runes").get(i).get("name").asText(),
                        node.get("runes").get(i).get("level").asInt(),
                        node.get("runes").get(i).get("description").asText()
                );
                runes.add(skillDataModel);
            }

            return runes;

        } else {

            return runes;
        }
    }
}
