package pl.arturzgodka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class SkillsController {

    private final List<String> heroClasses = Arrays.asList("Barbarian", "Crusader", "Demon-Hunter", "Monk", "Necromancer", "Witch-Doctor", "Wizard");

    @RequestMapping("/heroClassesList.html")
    public String getHeroesList(Model model) { //model przakzuje aby miec pelnie MVC
        model.addAttribute("heroClassesList", heroClasses); //model.addStribute podake nazwe zmiennje i skad ma pchodzic wartosc dla tej zmiennej.
        return "heroClasses";
    }
}
