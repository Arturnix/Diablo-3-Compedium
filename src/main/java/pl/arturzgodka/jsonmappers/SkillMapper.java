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

    private HeroSkillDataModel fetchSkill(JsonNode node) {

        return new HeroSkillDataModel(
                node.get("skill").get("name").asText(),
                node.get("skill").get("level").asInt(),
                node.get("skill").get("description").asText(),
                BaseUrlParts.getBaseMediaIconApi() + node.get("skill").get("icon").asText() + ".png",
                fetchSkillRunes(node)
        );
    }

    private HeroSkillDataModel mapSkillToDataModel(String accountData) {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = null;

        try {
            node = objectMapper.readTree(accountData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return fetchSkill(node);
    }

    private List<SkillDataModel> fetchSkillRunes(JsonNode node) {

        List<SkillDataModel> runes = new ArrayList<>();

            for(int i = 0; i < node.get("runes").size(); i++) {
                SkillDataModel skillDataModel = new SkillDataModel(
                        node.get("runes").get(i).get("name").asText(),
                        node.get("runes").get(i).get("level").asInt(),
                        node.get("runes").get(i).get("description").asText()
                );
                runes.add(skillDataModel);
            }

        return runes;
    }

    public List<HeroSkillDataModel> fetchSkills(String heroClass, List<String> barbarianSkills) {

        List<HeroSkillDataModel> skills = new ArrayList<>();
        FetchToken fetchToken = new FetchToken();

        for (String skill : barbarianSkills) {
            HeroSkillDataModel heroSkillDataModel = mapSkillToDataModel(SkillHandlerApi.generateRequest(heroClass, skill, fetchToken));
            skills.add(heroSkillDataModel);
        }

        return skills;
    }
}
