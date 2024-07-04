package pl.arturzgodka.controllers;

import java.util.*;

public class ItemClassesAndNamesLists {

    public static final List<String> itemTypes = Arrays.asList("Armor", "Weapon");

    /* helmets */
    private static final List<String> helmets = Arrays.asList("veil-of-steel-p43_RetroHelm_003", "leorics-crown-Unique_Helm_002_p1", "harlequin-crest-p43_RetroHelm_001", "the-undead-crown-p43_RetroHelm_002",
            "mystery-helm-PH_Helm", "helm-of-the-cranial-crustacean-TransmogHelm_002", "star-helm-TransmogHelm_001", "leather-hood-Helm_002", "prides-fall-Unique_Helm_103_x1", "broken-crown-P2_Unique_Helm_001",
            "blind-faith-Unique_Helm_007_x1", "deathseers-cowl-Unique_Helm_102_x1", "warhelm-of-kassar-P4_Unique_Helm_102", "visage-of-gunes-P4_Unique_Helm_103", "basinet-Helm_102", "mask-of-scarlet-death-P6_Necro_Unique_Helm_21",
            "skull-of-resonance-Unique_Helm_004_x1", "stechhelm-Helm_202", "zischagge-Helm_203", "natalyas-sight-Unique_Helm_009_x1", "mempo-of-twilight-P74_Unique_Helm_006", "tal-rashas-guise-of-wisdom-Unique_Helm_010_x1",
            "immortal-kings-triumph-Unique_Helm_008_x1", "andariels-visage-Unique_Helm_003_p2", "hellscape-mask-Helm_204", "hellscape-mask-Helm_204", "archon-crown-Helm_206", "fates-vow-P61_Necro_Unique_Helm_22",
            "jade-harvesters-wisdom-Unique_Helm_Set_09_x1", "sunwukos-crown-Unique_Helm_Set_11_x1", "vyrs-sightless-skull-Unique_Helm_Set_13_x1", "crown-of-the-invoker-Unique_Helm_Set_12_x1", "the-shadows-mask-Unique_Helm_Set_14_x",
            "eyes-of-the-earth-Unique_Helm_Set_15_x1", "raekors-will-Unique_Helm_Set_05_x1", "helm-of-the-wastes-Unique_Helm_Set_01_p2", "skull-of-savages-P68_Unique_Helm_Set_05", "crown-of-the-light-Unique_Helm_Set_03_p3",
            "crown-of-valor-P67_Unique_Helm_Set_01", "rolands-visage-Unique_Helm_Set_01_p1", "helm-of-akkhan-Unique_Helm_Set_10_x1", "accursed-visage-Unique_Helm_Set_03_p2", "dystopian-goggles-P69_Unique_Helm_Set_06",
            "marauders-visage-Unique_Helm_Set_07_x1", "mask-of-the-searing-sky-Unique_Helm_Set_08_x1", "ulianas-spirit-Unique_Helm_Set_01_p3", "decree-of-justice-P67_Unique_Helm_Set_02", "firebirds-plume-Unique_Helm_Set_06_x1",
            "shrouded-mask-Unique_Helm_Set_02_p2", "typhons-frons-P68_Unique_Helm_Set_03", "arachyrs-visage-Unique_Helm_Set_02_p3", "helltooth-mask-Unique_Helm_Set_16_x1", "luxurious-bauta-P69_Necro_Set_5_Helm",
            "tragouls-guise-P6_Necro_Set_2_Helm", "inariuss-understanding-P6_Necro_Set_3_Helm", "pestilence-mask-P6_Necro_Set_4_Helm", "rathmas-skull-helm-P6_Necro_Set_1_Helm");

    private static final List<String> spiritStones = Arrays.asList("glass-star-SpiritStone_001", "thought-mirror-SpiritStone_002", "see-no-evil-Unique_SpiritStone_005_x1", "third-eye-SpiritStone_003", "gyana-na-kashu-Unique_SpiritStone_004_x1",
            "onyx-cluster-SpiritStone_004", "the-minds-eye-Unique_SpiritStone_002_x1", "meditation-crystal-SpiritStone_004a", "erlang-shen-Unique_SpiritStone_003_x1", "eye-of-peshkov-Unique_SpiritStone_103_x1", "kekegis-unbreakable-spirit-Unique_SpiritStone_102_x1",
            "sunstone-SpiritStone_101", "the-laws-of-seph-Unique_SpiritStone_101_x1", "prism-SpiritStone_102", "seer-shard-SpiritStone_103", "bezoar-stone-Unique_SpiritStone_001_x1", "the-eye-of-the-storm-Unique_SpiritStone_006_x1", "igneous-studs-SpiritStone_104",
            "solarius-SpiritStone_201", "meditator-SpiritStone_202", "ghost-sight-SpiritStone_203", "innas-radiance-Unique_SpiritStone_009_x1", "madstone-P1_Unique_SpiritStone_008", "star-crown-SpiritStone_204", "tzo-krins-gaze-Unique_SpiritStone_007_x1",
            "insight-stone-SpiritStone_205");

    private static final List<String> voodooMasks = Arrays.asList("tribal-mask-VoodooMask_001", "split-tusk-Unique_VoodooMask_006_x1", "shaman-mask-VoodooMask_002", "chieftain-mask-VoodooMask_003", "quetzalcoatl-Unique_VoodooMask_005_x1", "totemic-mask-VoodooMask_004a",
            "carnevil-P65_Unique_VoodooMask_101_x1", "mask-of-jeram-P61_Unique_VoodooMask_102_x1", "woodwraith-bark-VoodooMask_101", "burial-mask-VoodooMask_102", "naga-mask-VoodooMask_103", "umbra-mask-VoodooMask_104", "the-grin-reaper-Unique_VoodooMask_002_x1",
            "screaming-mask-VoodooMask_201", "underworld-mask-VoodooMask_202", "visage-of-giyua-Unique_VoodooMask_008_x1", "zunimassas-vision-Unique_VoodooMask_007_x1", "tiklandian-visage-Unique_VoodooMask_001_x1", "manitou-mask-VoodooMask_203", "deva-VoodooMask_204",
            "tribal-mask-VoodooMask_205", "mundunugus-headdress-P68_Unique_Helm_Set_04");

    private static final List<String> wizardHats = Arrays.asList("wanderer-hat-WizardHat_001", "journey-mask-WizardHat_002", "scholarly-fez-WizardHat_003", "crown-of-the-primus-P74_Unique_WizardHat_104", "charlatan-cap-WizardHat_004", "the-swami-P3_Unique_WizardHat_003",
            "dark-mages-shade-Unique_WizardHat_001_x1", "mage-crown-WizardHat_004a", "archmages-vicalyke-Unique_WizardHat_101_x1", "velvet-camaral-Unique_WizardHat_102_x1", "conjurer-shade-WizardHat_101", "the-magistrate-P68_Unique_WizardHat_103", "mystic-shade-WizardHat_102",
            "mentor-cap-WizardHat_103", "traveler-hat-WizardHat_104", "sage-hat-WizardHat_201", "sinister-mask-WizardHat_202", "storm-crow-Unique_WizardHat_004_x1", "archmage-headpiece-WizardHat_203", "elder-hat-WizardHat_204", "vizier-hat-WizardHat_205");

    /* pauldrons - naramienniki */
    private static final List<String> pauldrons = Arrays.asList("mystery-shoulders-PH_Shoulders", "star-pauldrons-TransmogShoulders_001", "leather-mantle-Shoulders_002", "homing-pads-Unique_Shoulder_001_x1", "pauldrons-of-the-skeleton-king-Unique_Shoulder_103_x1",
            "shoulder-guards-Shoulders_003", "razeths-volition-P69_Necro_Unique_Shoulders_22", "death-watch-mantle-Unique_Shoulder_002_p2", "corpsewhisper-pauldrons-P6_Necro_Unique_Shoulders_21", "lefebvres-soliloquy-P4_Unique_Shoulder_101", "mantle-of-channeling-P4_Unique_Shoulder_103",
            "spaulders-of-zakara-Unique_Shoulder_102_x1", "fury-of-the-ancients-P67_Unique_Shoulder_102", "ailettes-Shoulders_102", "espaliers-Shoulders_202", "warlord-spaulders-Shoulders_203", "archon-spaulders-Shoulders_206", "doom-pauldrons-Shoulders_204", "vile-ward-Unique_Shoulder_003_p1",
            "burden-of-the-invoker-Unique_Shoulder_Set_12_x1", "spires-of-the-earth-Unique_Shoulder_Set_15_x1", "sunwukos-balance-Unique_Shoulder_Set_11_x1", "jade-harvesters-joy-Unique_Shoulder_Set_09_x1", "vyrs-proud-pauldrons-Unique_Shoulder_Set_13_x1", "the-shadows-burden-Unique_Shoulder_Set_14_x1",
            "spines-of-savages-P68_Unique_Shoulder_Set_05", "raekors-burden-Unique_Shoulder_Set_05_x1", "pauldrons-of-the-wastes-Unique_Shoulder_Set_01_p2", "spaulders-of-valor-P67_Unique_Shoulder_Set_01", "rolands-mantle-Unique_Shoulder_Set_01_p1", "mountain-of-the-light-Unique_Shoulder_Set_03_p3",
            "pauldrons-of-akkhan-Unique_Shoulder_Set_10_x1", "unsanctified-shoulders-Unique_Shoulder_Set_03_p2", "marauders-spines-Unique_Shoulder_Set_07_x1", "mechanical-pauldrons-P69_Unique_Shoulder_Set_06", "mantle-of-the-upsidedown-sinners-Unique_Shoulder_Set_08_x1", "ulianas-strength-Unique_Shoulder_Set_01_p3",
            "mirrors-of-justice-P67_Unique_Shoulder_Set_02", "firebirds-pinions-Unique_Shoulder_Set_06_x1", "typhons-tibia-P68_Unique_Shoulder_Set_03", "dashing-pauldrons-of-despair-Unique_Shoulder_Set_02_p2", "mundunugus-descendant-P68_Unique_Shoulder_Set_04", "helltooth-mantle-Unique_Shoulder_Set_16_x1",
            "arachyrs-mantle-Unique_Shoulder_Set_02_p3", "pestilence-defense-P6_Necro_Set_4_Shoulders", "glamorous-gigot-P69_Necro_Set_5_Shoulders", "rathmas-spikes-P6_Necro_Set_1_Shoulders", "tragouls-heart-P6_Necro_Set_2_Shoulders", "inariuss-martyrdom-P6_Necro_Set_3_Shoulders");

    /* armors */
    private static final List<String> chestArmor = Arrays.asList("godly-plate-of-the-whale-p43_RetroArmor_001", "arkaines-valor-p43_RetroArmor_002", "mystery-chest-armor-PH_ChestArmor", "cloth-tunic-ChestArmor_001", "leather-doublet-ChestArmor_002", "heart-of-iron-P4_Unique_Chest_018", "aquila-cuirass-P4_Unique_Chest_012",
            "chaingmail-Unique_Chest_010_x1", "shi-mizus-haori-Unique_Chest_101_x1", "cindercoat-Unique_Chest_006_x1", "jazeraint-mail-ChestArmor_103", "goldskin-Unique_Chest_001_x1", "astral-mail-ChestArmor_202", "warlord-plate-ChestArmor_203", "zunimassas-marrow-Unique_Chest_016_x1", "immortal-kings-eternal-reign-Unique_Chest_013_x1",
            "blackthornes-surcoat-Unique_ChestArmor_028_x1", "tal-rashas-relentless-pursuit-Unique_Chest_014_x1", "tyraels-might-Unique_Chest_002_x1", "innas-vast-expanse-Unique_Chest_015_x1", "archon-armor-ChestArmor_206", "doom-armor-ChestArmor_204", "bloodsong-mail-P6_Necro_Unique_Chest_21", "jade-harvesters-peace-Unique_Chest_Set_09_x1",
            "armor-of-the-kind-regent-Unique_Chest_102_x1", "spirit-of-the-earth-Unique_Chest_Set_15_x1", "the-shadows-bane-Unique_Chest_Set_14_x1", "sunwukos-soul-Unique_Chest_Set_11_x1", "vyrs-astonishing-aura-Unique_Chest_Set_13_x1", "cuirass-of-the-wastes-Unique_Chest_Set_01_p2", "markings-of-savages-P68_Unique_Chest_Set_05",
            "raekors-heart-Unique_Chest_Set_05_x1", "rolands-bearing-Unique_Chest_Set_01_p1", "breastplate-of-akkhan-Unique_Chest_Set_10_x1", "heart-of-the-light-Unique_Chest_Set_03_p3", "brigandine-of-valor-P67_Unique_Chest_Set_01", "marauders-carapace-Unique_Chest_Set_07_x1", "ulianas-heart-Unique_Chest_Set_01_p3",
            "heart-of-the-crashing-wave-Unique_Chest_Set_08_x1", "lamellars-of-justice-P67_Unique_Chest_Set_02", "firebirds-breast-Unique_Chest_Set_06_x1", "typhons-thorax-P68_Unique_Chest_Set_03", "harness-of-truth-Unique_Chest_Set_02_p2", "mundunugus-robe-P68_Unique_Chest_Set_04", "helltooth-tunic-Unique_Chest_Set_16_x1",
            "arachyrs-carapace-Unique_Chest_Set_02_p3", "sophisticated-vest-P69_Necro_Set_5_Chest", "tragouls-scales-P6_Necro_Set_2_Chest", "rathmas-ribcage-plate-P6_Necro_Set_1_Chest", "pestilence-robe-P6_Necro_Set_4_Chest", "inariuss-conviction-P6_Necro_Set_3_Chest", "requiem-cereplate-P6_Necro_Unique_Chest_22");

    private static final List<String> cloaks = Arrays.asList("hunter-cloak-Cloak_001", "shroud-Cloak_002", "cloak-of-deception-Unique_Cloak_102_x1", "cape-Cloak_003", "tabard-Cloak_004", "mantle-Cloak_004a", "beckon-sail-Unique_Cloak_005_x1", "blackfeather-Unique_Cloak_101_x1", "wrap-Cloak_101", "lurker-shroud-Cloak_102", "talma-Cloak_103",
            "cardinal-Cloak_104", "veteran-cloak-Cloak_201", "death-shroud-Cloak_202", "natalyas-embrace-Unique_Cloak_006_x1", "dread-cloak-Cloak_204", "stalker-cape-Cloak_203", "the-cloak-of-the-garwulf-Unique_Cloak_002_p1", "rakkisgard-cloak-Cloak_205", "cape-of-the-dark-night-Unique_Cloak_001_x1", "galvanized-vest-P69_Unique_Chest_Set_06",
            "cage-of-the-hellborn-Unique_Chest_Set_03_p2");

    /* bracers - karwasze */
    private final static List<String> bracers = Arrays.asList("mystery-bracers-PH_Bracers", "bracers-Bracers_001", "leather-cuffs-Bracers_002", "ashnagarrs-blood-bracer-P4_Unique_Bracer_004", "gungdo-gear-P610_Unique_Bracer_006", "cesars-memento-P61_Unique_Bracer_107", "bindings-Bracers_003", "sanguinary-vambraces-Unique_Bracer_105_x1",
            "pintos-pride-P4_Unique_Bracer_105", "bindings-of-the-lesser-gods-P71_Unique_Bracer_108", "akkhans-manacles-P4_Unique_Bracer_103", "morticks-brace-P2_Unique_Bracer_003", "vambraces-of-sescheron-P4_Unique_Bracer_106", "bracer-of-fury-P61_Unique_Bracer_104", "warzechian-armguards-Unique_Bracer_101_x1",
            "nemesis-bracers-Unique_Bracer_106_x1", "custerian-wristguards-Unique_Bracer_107_x1", "ancient-parthan-defenders-Unique_Bracer_102_x1", "wristbands-Bracers_102", "promise-of-glory-Unique_Bracer_002_x1", "armbands-Bracers_202", "warbands-Bracers_203", "strongarm-bracers-Unique_Bracer_007_x1", "armguards-Bracers_204",
            "lacuni-prowlers-Unique_Bracer_005_x1", "razorspikes-Bracers_206", "coils-of-the-first-spider-P3_Unique_Bracer_107", "wraps-of-clarity-P61_Unique_Bracer_103", "jerams-bracers-P3_Unique_Bracer_106", "bracers-of-the-first-men-P61_Unique_Bracer_105", "ranslors-folly-P61_Unique_Bracer_108_x1", "lakumbas-ornament-P72_Unique_Bracer_102",
            "bracers-of-destruction-P67_Unique_Bracer_100", "skulars-salvation-P73_Unique_Bracer_101", "gabriels-vambraces-P3_Unique_Bracer_101", "drakons-lesson-P4_Unique_Bracer_110", "shackles-of-the-invoker-Unique_Bracer_Set_12_x1", "krelms-buff-bracers-Unique_Bracer_Set_02_x1", "tragoul-coils-P75_Unique_Bracer_SpikeTrap",
            "gelmindors-marrow-guards-P610_Unique_Bracer_22", "bonds-of-clena-P7_Unique_Bracer_23", "spirit-guards-P61_Unique_Bracer_109");

    /* gloves */
    private final static List<String> gloves = Arrays.asList("mystery-gloves-PH_Gloves", "gloves-Gloves_001", "leather-gloves-Gloves_002", "gloves-of-worship-Unique_Gloves_103_x1", "grasps-of-essence-P69_Necro_Unique_Gloves_22", "stone-gauntlets-P66_Unique_Gloves_007", "st-archews-gage-Unique_Gloves_101_p2", "magefist-P41_Unique_Gloves_014",
            "etched-gloves-Gloves_102", "moribund-gauntlets-P6_Necro_Unique_Gloves_21", "gladiator-gauntlets-Unique_Gloves_011_x1", "manifers-Gloves_202", "warlord-gauntlets-Gloves_203", "zunimassas-finger-wraps-P2_Unique_Gloves_03", "archon-gauntlets-Gloves_206", "frostburn-P41_Unique_Gloves_002", "tasker-and-theo-Unique_Gloves_003_x1",
            "natalyas-touch-P2_Unique_Gloves_01", "immortal-kings-irons-Unique_Gloves_008_x1", "stranglers-Gloves_204", "innas-hold-P2_Unique_Gloves_04", "tal-rashas-grasp-P2_Unique_Gloves_02", "the-shadows-grasp-Unique_Gloves_Set_14_x1", "sunwukos-paws-Unique_Gloves_Set_11_x1", "pride-of-the-invoker-Unique_Gloves_Set_12_x1",
            "jade-harvesters-mercy-Unique_Gloves_Set_09_x1", "pull-of-the-earth-Unique_Gloves_Set_15_x1", "vyrs-grasping-gauntlets-Unique_Gloves_Set_13_x1", "raekors-wraps-Unique_Gloves_Set_05_x1", "gauntlet-of-the-wastes-Unique_Gloves_Set_01_p2", "claws-of-savages-P68_Unique_Gloves_Set_05", "gauntlets-of-valor-P67_Unique_Gloves_Set_01",
            "rolands-grasp-Unique_Gloves_Set_01_p1", "gauntlets-of-akkhan-Unique_Gloves_Set_10_x1", "will-of-the-light-Unique_Gloves_Set_03_p3", "fiendish-grips-Unique_Gloves_Set_03_p2", "gas-powered-automail-forearm-P69_Unique_Gloves_Set_06", "marauders-gloves-Unique_Gloves_Set_07_x1", "ulianas-fury-Unique_Gloves_Set_01_p3",
            "fists-of-thunder-Unique_Gloves_Set_08_x1", "bazubands-of-justice-P67_Unique_Gloves_Set_02", "fierce-gauntlets-Unique_Gloves_Set_02_p2", "typhons-claws-P68_Unique_Gloves_Set_03", "firebirds-talons-Unique_Gloves_Set_06_x1", "arachyrs-claws-Unique_Gloves_Set_02_p3", "mundunugus-rhythm-P68_Unique_Gloves_Set_04",
            "helltooth-gauntlets-Unique_Gloves_Set_16_x1", "tragouls-claws-P6_Necro_Set_2_Gloves", "lavishing-gloves-P69_Necro_Set_5_Gloves", "pestilence-gloves-P6_Necro_Set_4_Gloves", "rathmas-macabre-vambraces-P6_Necro_Set_1_Gloves", "inariuss-will-P6_Necro_Set_3_Gloves");

    /* belts */
    private final static List<String> belts = Arrays.asList("mystery-belt-PH_Belt", "sash-Belt_001", "saffron-wrap-P43_Unique_Belt_001_x1", "vigilante-belt-Unique_Belt_002_x1", "goldwrap-Unique_Belt_010_x1", "vigilante-belt-P76_Unique_Belt_002", "cord-Belt_004", "hellcat-waistguard-P43_Unique_Belt_005_x1", "insatiable-belt-Unique_Belt_103_x1",
            "binding-of-the-lost-P61_Unique_Belt_03", "the-shame-of-delsere-P4_Unique_Belt_02", "dayntees-binding-P61_Unique_Belt_01", "kyoshiros-soul-P4_Unique_Belt_05", "sacred-harness-P3_Unique_Belt_01", "string-of-ears-P4_Unique_Belt_03", "bakuli-jungle-wraps-P61_Unique_Belt_007", "saffron-wrap-Unique_Belt_001_x1",
            "string-of-ears-Unique_Belt_008_x1", "fazulas-improbable-chain-P4_Unique_Belt_07", "hergbrashs-binding-P4_Unique_Belt_06", "sebors-nightmare-Unique_Belt_108_p2", "sash-of-knives-Unique_Belt_102_p2", "omnislash-P2_Unique_Belt_04", "haunting-girdle-P2_Unique_Belt_03", "sebors-nightmare-Unique_Belt_108_x1",
            "hwoj-wrap-Unique_Belt_107_x1", "omryns-chain-P2_Unique_Belt_06", "cord-of-the-sherma-Unique_Belt_104_p2", "harrington-waistguard-Unique_Belt_105_x1", "crashing-rain-P2_Unique_Belt_01", "chain-of-shadows-P4_Unique_Belt_01", "cord-of-the-sherma-Unique_Belt_104_x1", "blessed-of-haull-P2_Unique_Belt_05",
            "belt-of-transcendence-P2_Unique_Belt_02", "brood-of-araneae-P72_Unique_Belt_007", "razor-strop-Unique_Belt_101_x1", "angel-hair-braid-Unique_Belt_003_x1", "thundergods-vigor-Unique_BarbBelt_003_x1", "angel-hair-braid-Unique_Belt_003_p1", "sheath-Belt_202", "cincture-Belt_203", "girdle-Belt_204", "innas-favor-Unique_Belt_007_x1",
            "belt-of-the-trove-P610_Unique_Belt_008", "the-witching-hour-Unique_Belt_009_x1", "hellcat-waistguard-Unique_Belt_005_x1", "high-scabbard-Belt_206", "tal-rashas-brace-Unique_Belt_006_x1", "blackthornes-notched-belt-Unique_Belt_015_x1", "jangs-envelopment-Unique_Belt_106_x1", "khassetts-cord-of-righteousness-P42_Crusader_FoH_Belt",
            "zoeys-secret-P4_Unique_Belt_04", "hunters-wrath-P69_Unique_Belt_005", "krelms-buff-belt-Unique_Belt_Set_02_x1");

    private final static List<String> mightyBelts = Arrays.asList("warrior-belt-BarbBelt_001", "the-undisputed-champion-P68_Unique_BarbBelt_006", "harness-BarbBelt_002", "girdle-of-giants-P61_Unique_BarbBelt_EQ", "braid-BarbBelt_003", "grand-belt-BarbBelt_004", "black-iron-belt-BarbBelt_004a", "pride-of-cassius-Unique_BarbBelt_002_x1",
            "baldric-BarbBelt_101", "chilaniks-chain-Unique_BarbBelt_101_x1", "blade-harness-BarbBelt_102", "iron-braid-BarbBelt_103", "steel-chain-BarbBelt_104", "lock-BarbBelt_201", "bronze-links-BarbBelt_202", "lamentation-P67_Unique_BarbBelt_005", "dread-iron-P2_Unique_BarbBelt_001", "heavy-baldric-BarbBelt_203",
            "grand-chain-BarbBelt_204", "immortal-kings-tribal-binding-Unique_BarbBelt_009_x1", "platinum-lock-BarbBelt_205");

    /* pants */

    public static Set<String> getItemTypesNames(String itemType){
        return itemsTypesMap.get(itemType).keySet();
    }

    private static final Map<String, Map<String, List<List<String>>>> itemsTypesMap = new HashMap<String, Map<String, List<List<String>>>>() {{
        put("Armor", new HashMap<String, List<List<String>>>() {{
            put("Helmets", List.of(helmets, spiritStones, voodooMasks, wizardHats));
            put("Pauldrons", List.of(pauldrons));
            put("Armors", List.of(chestArmor, cloaks));
            put("Bracers", List.of(bracers));
            put("Gloves", List.of(gloves));
            put("Belts", List.of(belts, mightyBelts));
        }});
        //put("Weapon", );
    }};

}
