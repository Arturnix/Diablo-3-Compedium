package pl.arturzgodka.jsonmappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.arturzgodka.datamodel.AccountDataModel;
import pl.arturzgodka.datamodel.CharacterDataModel;
import pl.arturzgodka.datamodel.SkillDataModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SkillMapper {

    private SkillDataModel fetchSkill(JsonNode node) {

        return new SkillDataModel(
                node.get("skill").get("slug").asText(),
                node.get("skill").get("name").asText(),
                node.get("skill").get("level").asInt(),
                node.get("skill").get("description").asText()
        );
    }

    public SkillDataModel mapSkillToDataModel(String accountData) {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = null;

        try {
            node = objectMapper.readTree(accountData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return fetchSkill(node);
    }
}
