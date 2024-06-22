package pl.arturzgodka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pl.arturzgodka.datamodel.HeroSkillDataModel;
import pl.arturzgodka.jsonmappers.SkillMapper;

import java.util.*;

@Controller
public class SkillsController {

    private final List<String> heroClasses = Arrays.asList("Barbarian", "Crusader", "Demon Hunter", "Monk", "Necromancer", "Witch Doctor", "Wizard");
    private final List<String> barbarianSkills = Arrays.asList("bash", "hammer-of-the-ancients", "cleave", "ground-stomp", "rend", "leap", "overpower", "frenzy",
            "seismic-slam", "revenge", "threatening-shout", "sprint", "weapon-throw", "earthquake", "whirlwind", "furious-charge",
            "ignore-pain", "battle-rage", "call-of-the-ancients", "ancient-spear", "war-cry", "wrath-of-the-berserker", "avalanche");
    private final List<String> crusaderSkills = Arrays.asList("punish", "shield-bash", "slash", "shield-glare", "sweep-attack", "iron-skin",
            "provoke", "smite", "blessed-hammer", "steed-charge", "laws-of-valor", "justice", "consecration", "laws-of-justice", "falling-sword",
            "blessed-shield", "condemn", "judgment", "laws-of-hope", "akarats-champion", "fist-of-the-heavens", "phalanx", "heavens-fury", "bombardment");
    private final List<String> demonHunterSkills = Arrays.asList("hungering-arrow", "impale", "entangling-shot", "caltrops", "rapid-fire", "smoke-screen",
            "vault", "bolas", "chakram", "preparation", "fan-of-knives", "evasive-fire", "grenade", "shadow-power", "spike-trap", "companion", "strafe",
            "elemental-arrow", "marked-for-death", "multishot", "sentry", "cluster-arrow", "rain-of-vengeance", "vengeance");
    private final List<String> monkSkills = Arrays.asList("fists-of-thunder", "lashing-tail-kick", "deadly-reach", "blinding-flash", "tempest-rush",
            "breath-of-heaven", "dashing-strike", "crippling-wave", "wave-of-light", "exploding-palm", "cyclone-strike", "way-of-the-hundred-fists",
            "serenity", "sevensided-strike", "mantra-of-salvation", "sweeping-wind", "mantra-of-retribution", "inner-sanctuary", "mystic-ally",
            "mantra-of-healing", "mantra-of-conviction", "epiphany");
    private final List<String> necromancerSkills = Arrays.asList("bone-spikes", "bone-spear", "grim-scythe", "corpse-explosion", "skeletal-mage", "corpse-lance",
            "command-skeletons", "siphon-blood", "death-nova", "command-golem", "decrepify", "devour", "leech", "bone-armor", "army-of-the-dead", "frailty",
            "revive", "bone-spirit", "blood-rush", "land-of-the-dead", "simulacrum");
    private final List<String> witchDoctorSkills = Arrays.asList("poison-dart", "grasp-of-the-dead", "corpse-spiders", "summon-zombie-dogs", "firebats", "horrify",
            "soul-harvest", "plague-of-toads", "haunt", "sacrifice", "zombie-charger", "spirit-walk", "spirit-barrage", "gargantuan", "locust-swarm", "firebomb",
            "hex", "acid-cloud", "mass-confusion", "big-bad-voodoo", "wall-of-death", "fetish-army", "piranhas");
    private final List<String> wizardSkills = Arrays.asList("magic-missile", "ray-of-frost", "shock-pulse", "frost-nova", "arcane-orb", "diamond-skin",
            "wave-of-force", "spectral-blade", "arcane-torrent", "energy-twister", "ice-armor", "electrocute", "slow-time", "storm-armor", "explosive-blast",
            "magic-weapon", "hydra", "disintegrate", "familiar", "teleport", "mirror-image", "meteor", "blizzard", "energy-armor", "archon", "black-hole");

    private final Map<String, List<String>> heroClassSkillsMap = new HashMap<String, List<String>>() {{
        put("barbarian", barbarianSkills);
        put("crusader", crusaderSkills);
        put("demon-hunter", demonHunterSkills);
        put("monk", monkSkills);
        put("necromancer", necromancerSkills);
        put("witch-doctor", witchDoctorSkills);
        put("wizard", wizardSkills);
    }};

    private final SkillMapper skillMapper = new SkillMapper();

    @RequestMapping("/heroClasses.html")
    public String getHeroesList(Model model) { //model przakzuje aby miec pelne MVC
        model.addAttribute("heroClassesList", heroClasses); //model.addStribute podake nazwe zmiennje i skad ma pchodzic wartosc dla tej zmiennej.
        return "heroClasses";
    }

    @RequestMapping("/{heroClasses}")
    public String getSkills(Model model, @PathVariable(value="heroClasses") String heroClass) {

        String heroClassLoverCaseWithHyphonSeparator = heroClass.toLowerCase().replace(" ", "-");
        String heroClassLoverCaseWithUnderscoreSeparator = heroClass.toLowerCase().replace(" ", "_");
        List<String> heroClassSkills = heroClassSkillsMap.get(heroClassLoverCaseWithHyphonSeparator);
        List<HeroSkillDataModel> skillsMapped = skillMapper.fetchSkills(heroClassLoverCaseWithHyphonSeparator, heroClassSkills);

        model.addAttribute(heroClassLoverCaseWithUnderscoreSeparator + "Skills", skillsMapped);
        return heroClassLoverCaseWithHyphonSeparator + "Skills";
    }

}
