package pl.arturzgodka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.arturzgodka.datamodel.HeroSkillDataModel;
import pl.arturzgodka.jsonmappers.SkillMapper;

import java.util.*;

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

        List<HeroSkillDataModel> skillsMapped = SearchSkill.getSkillsToDisplay(heroClass);

        model.addAttribute("skills", skillsMapped);
        model.addAttribute("heroClass", heroClass);

        return "skills";
    }

    @GetMapping("skills/skillSearch")
    public String searchSkillForm(Model model, @RequestParam String skillSearchName, @RequestParam String heroClassName) {

        List<HeroSkillDataModel> skillsMatched = SearchSkill.getSkillsToDisplay(heroClassName, skillSearchName);

        model.addAttribute("skills", skillsMatched);
        model.addAttribute("heroClass", heroClassName);
        model.addAttribute("skillSearched", true); //flag to not display search bar after search was submitted and results are being displayed

        return "skills";
    }

}
