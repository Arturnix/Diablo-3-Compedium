package pl.arturzgodka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.arturzgodka.datamodel.HeroSkillDataModel;
import pl.arturzgodka.jsonmappers.SkillMapper;

import java.util.*;

import static pl.arturzgodka.controllers.HeroClassesAndSkillsLists.getHeroClassSkillsList;

@Controller
public class SkillsController {
    private final SkillMapper skillMapper = new SkillMapper();

    @RequestMapping("/heroClasses.html")
    public String getHeroesList(Model model) { //model przakzuje aby miec pelne MVC
        model.addAttribute("heroClassesList", HeroClassesAndSkillsLists.heroClasses); //model.addStribute podake nazwe zmiennje i skad ma pchodzic wartosc dla tej zmiennej.
        return "heroClasses";
    }

    @RequestMapping("/{heroClasses}")
    public String getSkills(Model model, @PathVariable(value="heroClasses") String heroClass) {

        String heroClassWithHyphonSeparator = heroClass.replace(" ", "-");
        List<HeroSkillDataModel> skillsMapped = skillMapper.mapSkillsToDataModel(heroClassWithHyphonSeparator, getHeroClassSkillsList(heroClassWithHyphonSeparator)); //z innej klasy nie moge tak zrobic bo dostaję błąd, server status 500.

        model.addAttribute("skills", skillsMapped);
        model.addAttribute("heroClass", heroClass);

        return "skills";
    }

}
