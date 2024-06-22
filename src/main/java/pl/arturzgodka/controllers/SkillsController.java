package pl.arturzgodka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.arturzgodka.datamodel.HeroSkillDataModel;
import pl.arturzgodka.jsonmappers.SkillMapper;

import java.util.*;

@Controller
public class SkillsController {
    private final SkillMapper skillMapper = new SkillMapper();
    private final Map<String, List<String>> heroClassSkillsMap = new HashMap<String, List<String>>() {{
        put("barbarian", HeroClassesAndSkillsLists.barbarianSkills);
        put("crusader", HeroClassesAndSkillsLists.crusaderSkills);
        put("demon-hunter", HeroClassesAndSkillsLists.demonHunterSkills);
        put("monk", HeroClassesAndSkillsLists.monkSkills);
        put("necromancer", HeroClassesAndSkillsLists.necromancerSkills);
        put("witch-doctor", HeroClassesAndSkillsLists.witchDoctorSkills);
        put("wizard", HeroClassesAndSkillsLists.wizardSkills);
    }};

    @RequestMapping("/heroClasses.html")
    public String getHeroesList(Model model) { //model przakzuje aby miec pelne MVC
        model.addAttribute("heroClassesList", HeroClassesAndSkillsLists.heroClasses); //model.addStribute podake nazwe zmiennje i skad ma pchodzic wartosc dla tej zmiennej.
        return "heroClasses";
    }

    @RequestMapping("/{heroClasses}")
    public String getSkills(Model model, @PathVariable(value="heroClasses") String heroClass) {

        String heroClassLoverCaseWithHyphonSeparator = heroClass.toLowerCase().replace(" ", "-");
        List<HeroSkillDataModel> skillsMapped = skillMapper.fetchSkills(heroClassLoverCaseWithHyphonSeparator, heroClassSkillsMap.get(heroClassLoverCaseWithHyphonSeparator)); //z innej klasy nie moge tak zrobic bo dostaję błąd

        model.addAttribute("skills", skillsMapped);
        model.addAttribute("heroClass", heroClass);
        return "skills";
    }

}
