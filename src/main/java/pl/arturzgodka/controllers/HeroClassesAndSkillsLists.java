package pl.arturzgodka.controllers;

import java.util.*;
import java.util.stream.Collectors;

public class HeroClassesAndSkillsLists {

    public static final List<String> heroClasses = Arrays.asList("barbarian", "crusader", "demon hunter", "monk", "necromancer", "witch doctor", "wizard");
    private static final List<String> barbarianSkills = Arrays.asList("bash", "hammer-of-the-ancients", "cleave", "ground-stomp", "rend", "leap", "overpower", "frenzy",
            "seismic-slam", "revenge", "threatening-shout", "sprint", "weapon-throw", "earthquake", "whirlwind", "furious-charge",
            "ignore-pain", "battle-rage", "call-of-the-ancients", "ancient-spear", "war-cry", "wrath-of-the-berserker", "avalanche");
    private static final List<String> crusaderSkills = Arrays.asList("punish", "shield-bash", "slash", "shield-glare", "sweep-attack", "iron-skin",
            "provoke", "smite", "blessed-hammer", "steed-charge", "laws-of-valor", "justice", "consecration", "laws-of-justice", "falling-sword",
            "blessed-shield", "condemn", "judgment", "laws-of-hope", "akarats-champion", "fist-of-the-heavens", "phalanx", "heavens-fury", "bombardment");
    private static final List<String> demonHunterSkills = Arrays.asList("hungering-arrow", "impale", "entangling-shot", "caltrops", "rapid-fire", "smoke-screen",
            "vault", "bolas", "chakram", "preparation", "fan-of-knives", "evasive-fire", "grenade", "shadow-power", "spike-trap", "companion", "strafe",
            "elemental-arrow", "marked-for-death", "multishot", "sentry", "cluster-arrow", "rain-of-vengeance", "vengeance");
    private static final List<String> monkSkills = Arrays.asList("fists-of-thunder", "lashing-tail-kick", "deadly-reach", "blinding-flash", "tempest-rush",
            "breath-of-heaven", "dashing-strike", "crippling-wave", "wave-of-light", "exploding-palm", "cyclone-strike", "way-of-the-hundred-fists",
            "serenity", "sevensided-strike", "mantra-of-salvation", "sweeping-wind", "mantra-of-retribution", "inner-sanctuary", "mystic-ally",
            "mantra-of-healing", "mantra-of-conviction", "epiphany");
    private static final List<String> necromancerSkills = Arrays.asList("bone-spikes", "bone-spear", "grim-scythe", "corpse-explosion", "skeletal-mage", "corpse-lance",
            "command-skeletons", "siphon-blood", "death-nova", "command-golem", "decrepify", "devour", "leech", "bone-armor", "army-of-the-dead", "frailty",
            "revive", "bone-spirit", "blood-rush", "land-of-the-dead", "simulacrum");
    private static final List<String> witchDoctorSkills = Arrays.asList("poison-dart", "grasp-of-the-dead", "corpse-spiders", "summon-zombie-dogs", "firebats", "horrify",
            "soul-harvest", "plague-of-toads", "haunt", "sacrifice", "zombie-charger", "spirit-walk", "spirit-barrage", "gargantuan", "locust-swarm", "firebomb",
            "hex", "acid-cloud", "mass-confusion", "big-bad-voodoo", "wall-of-death", "fetish-army", "piranhas");
    private static final List<String> wizardSkills = Arrays.asList("magic-missile", "ray-of-frost", "shock-pulse", "frost-nova", "arcane-orb", "diamond-skin",
            "wave-of-force", "spectral-blade", "arcane-torrent", "energy-twister", "ice-armor", "electrocute", "slow-time", "storm-armor", "explosive-blast",
            "magic-weapon", "hydra", "disintegrate", "familiar", "teleport", "mirror-image", "meteor", "blizzard", "energy-armor", "archon", "black-hole");

    private static final Map<String, List<String>> heroClassSkillsMap = new HashMap<String, List<String>>(7) {{
        put("barbarian", HeroClassesAndSkillsLists.barbarianSkills);
        put("crusader", HeroClassesAndSkillsLists.crusaderSkills);
        put("demon-hunter", HeroClassesAndSkillsLists.demonHunterSkills);
        put("monk", HeroClassesAndSkillsLists.monkSkills);
        put("necromancer", HeroClassesAndSkillsLists.necromancerSkills);
        put("witch-doctor", HeroClassesAndSkillsLists.witchDoctorSkills);
        put("wizard", HeroClassesAndSkillsLists.wizardSkills);
    }};

    public static List<String> getHeroClassSkillsList(String heroClass){
        return heroClassSkillsMap.get(heroClass);
    }

    public static List<String> getSearchedSkillName(String heroClass, String skillName) {

        List<String> skillNamesMatched = new ArrayList<>();

        if (getHeroClassSkillsList(heroClass).stream().anyMatch(String -> String.contains(skillName))) {
             skillNamesMatched = (heroClassSkillsMap.get(heroClass).stream().filter(String -> String.contains(skillName)).toList());
        }

        return skillNamesMatched;
    }

}
