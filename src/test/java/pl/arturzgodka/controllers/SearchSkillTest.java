package pl.arturzgodka.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import pl.arturzgodka.datamodel.HeroSkillDataModel;
import pl.arturzgodka.datamodel.SkillDataModel;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.arturzgodka.controllers.SearchSkill.getSkillsToDisplay;

public class SearchSkillTest {

    @Test
    public void shouldReturnListOfSearchedSkills() {
        //given
        String heroClassName = "wizard";
        String skillSearchName = "magic";

        //when
        HeroSkillDataModel heroSkillDataModel1 = new HeroSkillDataModel("Magic Missile", 1, "This is a Signature spell. Signature spells are free to cast.\n" +
                "\n" + "Launch a missile of magic energy, dealing 230% weapon damage as Arcane.", "http://media.blizzard.com/d3/icons/skills/64/wizard_magicmissile.png", new ArrayList<SkillDataModel>());
        HeroSkillDataModel heroSkillDataModel2 = new HeroSkillDataModel("Magic Weapon", 20, "Cost: 25 Arcane Power\n" +
                "\n" + "Imbue your weapon with magical energy, granting it 10% increased damage. Lasts 10 minutes.\n" +
                "\n" + "Requires Weapon", "http://media.blizzard.com/d3/icons/skills/64/wizard_magicweapon.png", new ArrayList<SkillDataModel>());
        List<HeroSkillDataModel> skillsToDisplay = new ArrayList<>();
        skillsToDisplay.add(heroSkillDataModel1);
        skillsToDisplay.add(heroSkillDataModel2);

        //then
        try (MockedStatic<SearchSkill> searchSkillMockedStatic = Mockito.mockStatic(SearchSkill.class)) {
            searchSkillMockedStatic.when(() -> getSkillsToDisplay(heroClassName, skillSearchName))
                    .thenReturn(skillsToDisplay);

            assertThat(skillsToDisplay, hasSize(2));
            assertThat(skillsToDisplay, everyItem(instanceOf(HeroSkillDataModel.class)));
            assertThat(skillsToDisplay.get(0).getName(), containsString("Magic"));
            assertThat(skillsToDisplay.get(1).getName(), containsString("Magic"));
        }
    }

    @Test
    public void shouldReturnEmptyListWhenNoMatchFoundForProvidedSkillName() {
        //given
        String heroClassName = "wizard";
        String skillSearchName = "noMatch";

        //when
        List<HeroSkillDataModel> skillsToDisplay = new ArrayList<>();

        //then
        try (MockedStatic<SearchSkill> searchSkillMockedStatic = Mockito.mockStatic(SearchSkill.class)) {
            searchSkillMockedStatic.when(() -> getSkillsToDisplay(heroClassName, skillSearchName))
                    .thenReturn(skillsToDisplay);

            assertThat(getSkillsToDisplay(heroClassName, skillSearchName), notNullValue());
            assertThat(getSkillsToDisplay(heroClassName, skillSearchName), hasSize(0));
            assertThat(getSkillsToDisplay(heroClassName, skillSearchName), empty());
        }
    }

    @Test
    public void shouldReturnListOfAllSkillsForProvidedHeroClassNameAndEmptyStringAsSkillName() {
        //given
        String heroClassName = "wizard";
        String skillSearchName = "";

        //when
        List<HeroSkillDataModel> allSkillsOfProvidedHeroClass = new ArrayList<>(); //fake list of all skills for this class, just to keep this case simple.
        allSkillsOfProvidedHeroClass.add(new HeroSkillDataModel("Magic Missile", 1, "This is a Signature spell. Signature spells are free to cast.\n" +
                "\n" + "Launch a missile of magic energy, dealing 230% weapon damage as Arcane.", "http://media.blizzard.com/d3/icons/skills/64/wizard_magicmissile.png", new ArrayList<SkillDataModel>()));
        allSkillsOfProvidedHeroClass.add(new HeroSkillDataModel("Magic Weapon", 20, "Cost: 25 Arcane Power\n" +
                "\n" + "Imbue your weapon with magical energy, granting it 10% increased damage. Lasts 10 minutes.\n" +
                "\n" + "Requires Weapon", "http://media.blizzard.com/d3/icons/skills/64/wizard_magicweapon.png", new ArrayList<SkillDataModel>()));

        //then
        try (MockedStatic<SearchSkill> searchSkillMockedStatic = Mockito.mockStatic(SearchSkill.class)) {
            searchSkillMockedStatic.when(() -> getSkillsToDisplay(heroClassName, skillSearchName))
                    .thenReturn(allSkillsOfProvidedHeroClass);

            assertThat(getSkillsToDisplay(heroClassName, skillSearchName), not(empty()));
            assertThat(getSkillsToDisplay(heroClassName, skillSearchName).size(), is(2));
            assertThat(getSkillsToDisplay(heroClassName, skillSearchName), everyItem(instanceOf(HeroSkillDataModel.class)));
        }
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenNoNameForHeroClassNameProvided() {
        //given
        String heroClassName = "noClassName";
        String skillSearchName = "magic";

        //when
        //then
        try (MockedStatic<SearchSkill> searchSkillMockedStatic = Mockito.mockStatic(SearchSkill.class)) {
            searchSkillMockedStatic.when(() -> getSkillsToDisplay(heroClassName, skillSearchName))
                    .thenThrow(NullPointerException.class);

            assertThrows(NullPointerException.class, () -> getSkillsToDisplay(heroClassName, skillSearchName));
        }
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenHeroClassNameAsNullProvidedToGetSkills() {
        //given
        String heroClassName = null;
        String skillSearchName = "magic";

        //when
        //then
        try (MockedStatic<SearchSkill> searchSkillMockedStatic = Mockito.mockStatic(SearchSkill.class)) {
            searchSkillMockedStatic.when(() -> getSkillsToDisplay(heroClassName, skillSearchName))
                    .thenThrow(NullPointerException.class);

            assertThrows(NullPointerException.class, () -> getSkillsToDisplay(heroClassName, skillSearchName));
        }
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenSkillSearchNameAsNullProvidedToGetSkills() {
        //given
        String heroClassName = "wizard";
        String skillSearchName = null;

        //when
        //then
        try (MockedStatic<SearchSkill> searchSkillMockedStatic = Mockito.mockStatic(SearchSkill.class)) {
            searchSkillMockedStatic.when(() -> getSkillsToDisplay(heroClassName, skillSearchName))
                    .thenThrow(NullPointerException.class);

            assertThrows(NullPointerException.class, () -> getSkillsToDisplay(heroClassName, skillSearchName));
        }
    }
}
