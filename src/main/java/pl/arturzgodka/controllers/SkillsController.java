package pl.arturzgodka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.arturzgodka.apihandlers.ItemHandlerApi;
import pl.arturzgodka.apihandlers.SkillHandlerApi;
import pl.arturzgodka.datamodel.HeroSkillDataModel;
import pl.arturzgodka.datamodel.ItemDataModel;
import pl.arturzgodka.jsonmappers.SkillMapper;
import pl.arturzgodka.token.FetchToken;

import java.util.*;

import static pl.arturzgodka.controllers.HeroClassesAndSkillsLists.getHeroClassSkillsList;
import static pl.arturzgodka.controllers.HeroClassesAndSkillsLists.getSearchedSkillName;

@Controller
public class SkillsController {
    private final SkillMapper skillMapper = new SkillMapper();

    @RequestMapping("skills/heroClasses.html")
    public String getHeroesList(Model model) {
        model.addAttribute("heroClassesList", HeroClassesAndSkillsLists.heroClasses);
        return "heroClasses";
    }

    @RequestMapping("skills/{heroClasses}")
    public String getSkills(Model model, @PathVariable(value="heroClasses") String heroClass) {

        List<HeroSkillDataModel> skillsMapped = getSkillsToDisplay(heroClass);

        model.addAttribute("skills", skillsMapped);
        model.addAttribute("heroClass", heroClass);

        return "skills";
    }

    @GetMapping("skills/skillSearch")
    public String searchSkillForm(Model model, @RequestParam String skillSearchName, @RequestParam String heroClassName) {

        List<HeroSkillDataModel> skillsMatched = getSkillsToDisplay(heroClassName, skillSearchName);

        model.addAttribute("skills", skillsMatched);
        model.addAttribute("heroClass", heroClassName);
        model.addAttribute("skillSearched", true); //flag to not display search bar after search was submitted and results are being displayed

        return "skills";
    }

    private List<HeroSkillDataModel> getSkillsToDisplay(String heroClassName, String skillSearchName) {
        String heroClassWithHyphenSeparator = heroClassName.replace(" ", "-");
        String skillSearchNameWithHyphenSeparator = skillSearchName.replaceAll(" ", "-");
        return skillMapper.mapSkillsToDataModel(heroClassWithHyphenSeparator, getSearchedSkillName(heroClassWithHyphenSeparator, skillSearchNameWithHyphenSeparator.toLowerCase()));
    }

    private List<HeroSkillDataModel> getSkillsToDisplay(String heroClassName) {
        return getSkillsToDisplay(heroClassName, "");
    }

}
