package pl.arturzgodka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.arturzgodka.datamodel.HeroSkillDataModel;
import pl.arturzgodka.jsonmappers.SkillMapper;

import java.util.Arrays;
import java.util.List;

@Controller
public class SkillsController {

    private final List<String> heroClasses = Arrays.asList("Barbarian", "Crusader", "Demon-Hunter", "Monk", "Necromancer", "Witch-Doctor", "Wizard");
    private final List<String> barbarianSkills = Arrays.asList("bash", "hammer-of-the-ancients", "cleave", "ground-stomp", "rend", "leap", "overpower", "frenzy",
            "seismic-slam", "revenge", "threatening-shout", "sprint", "weapon-throw", "earthquake", "whirlwind", "furious-charge",
            "ignore-pain", "battle-rage", "call-of-the-ancients", "ancient-spear", "war-cry", "wrath-of-the-berserker", "avalanche");

    private final List<String> crusaderSkills = Arrays.asList("punish", "shield-bash", "slash", "shield-glare", "sweep-attack", "iron-skin",
            "provoke", "smite", "blessed-hammer", "steed-charge", "laws-of-valor", "justice", "consecration", "laws-of-justice", "falling-sword",
            "blessed-shield", "condemn", "judgment", "laws-of-hope", "akarats-champion", "fist-of-the-heavens", "phalanx", "heavens-fury", "bombardment");
    private final SkillMapper skillMapper = new SkillMapper();
    private List<HeroSkillDataModel> barbarianSkillsFetched = skillMapper.fetchSkills("barbarian", barbarianSkills);
    private List<HeroSkillDataModel> crusaderSkillsFetched = skillMapper.fetchSkills("crusader", crusaderSkills);

    @RequestMapping("/heroClasses.html")
    public String getHeroesList(Model model) { //model przakzuje aby miec pelnie MVC
        model.addAttribute("heroClassesList", heroClasses); //model.addStribute podake nazwe zmiennje i skad ma pchodzic wartosc dla tej zmiennej.
        return "heroClasses";
    }

    @RequestMapping("/BarbarianSkills.html")
    public String getBarbarianSkills(Model model) {
        model.addAttribute("barbarianSkills", barbarianSkillsFetched);
        return "barbarianSkills";
    }

    @RequestMapping("/CrusaderSkills.html")
    public String getCrusaderSkills(Model model) {
        model.addAttribute("crusaderSkills", crusaderSkillsFetched);
        return "crusaderSkills";
    }
}
