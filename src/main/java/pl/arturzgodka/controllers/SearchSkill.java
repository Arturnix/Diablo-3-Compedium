package pl.arturzgodka.controllers;

import pl.arturzgodka.datamodel.HeroSkillDataModel;
import pl.arturzgodka.jsonmappers.SkillMapper;

import java.util.List;

import static pl.arturzgodka.controllers.HeroClassesAndSkillsLists.getMatchedSkillName;

public class SearchSkill {

    public static List<HeroSkillDataModel> getSkillsToDisplay(String heroClassName, String skillSearchName) {
        SkillMapper skillMapper = new SkillMapper();
        String heroClassWithHyphenSeparator = heroClassName.replace(" ", "-");
        String skillSearchNameWithHyphenSeparator = skillSearchName.replaceAll(" ", "-");
        return skillMapper.mapSkillsToDataModel(heroClassWithHyphenSeparator, getMatchedSkillName(heroClassWithHyphenSeparator, skillSearchNameWithHyphenSeparator.toLowerCase()));
    }

    public static List<HeroSkillDataModel> getSkillsToDisplay(String heroClassName) {
        return getSkillsToDisplay(heroClassName, "");
    }
}
