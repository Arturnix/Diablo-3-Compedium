package pl.arturzgodka.controllers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class HeroClassesAndSkillsListsTest {

    @Test
    public void shouldReturnGreaterThan0ListSizeOfClassSkillsForEveryClass() {
        //given
        List<String> classNames = HeroClassesAndSkillsLists.heroClasses;
        List<Boolean> classHasSkillsList = new ArrayList<>(7);

        //when
        for(String className : classNames) {
            if(!HeroClassesAndSkillsLists.getHeroClassSkillsList(className.replace(" ", "-")).isEmpty()) {
                classHasSkillsList.add(true);
            }
        }

        //then
        assertThat(classHasSkillsList, hasSize(7));
    }

    @Test
    public void shouldReturnNullValeIfThereIsWrongClassNameProvided() {
        //given
        String className = "wrongClassNameProvided";

        //when
        //then
        assertThat(HeroClassesAndSkillsLists.getHeroClassSkillsList(className), nullValue());
    }

    @Test
    public void shouldReturnMatchedSkill() {
        //given
        String heroClass = "barbarian";
        String skillName = "ba";

        //when
        List<String> skillsMatched = HeroClassesAndSkillsLists.getSearchedSkillName(heroClass, skillName);

        //then
        assertThat(skillsMatched, not(empty()));
        assertThat(skillsMatched.get(0), equalTo("bash"));
    }

    @Test
    public void shouldReturnListOfMatchedSkills() {
        //given
        String heroClass = "wizard";
        String skillName = "magic";

        //when
        List<String> skillsMatched = HeroClassesAndSkillsLists.getSearchedSkillName(heroClass, skillName);

        //then
        assertThat(skillsMatched.size(), is(2));
        assertThat(skillsMatched, contains("magic-missile", "magic-weapon"));
    }

    @Test
    public void shouldThrowNullPointerExceptionIfWrongHeroClassProvided() {
        //given
        String heroClass = "wrongHeroClassProvided";
        String skillName = "magic";

        //when
        //then
        assertThrows(NullPointerException.class, () -> HeroClassesAndSkillsLists.getSearchedSkillName(heroClass, skillName));
    }

    @Test
    public void shouldReturnEmptyListIfWrongSkillNameProvided() {
        //given
        String heroClass = "wizard";
        String skillName = "wrongSkillNameProvided";

        //when
        //then
        assertThat(HeroClassesAndSkillsLists.getSearchedSkillName(heroClass, skillName), empty());
    }

    @Test
    public void shouldThrowNullPointerExceptionIfNullValuesProvidedToSearch() {
        //given
        String heroClass = null;
        String skillName = null;

        //when
        //then
        assertThrows(NullPointerException.class, () -> HeroClassesAndSkillsLists.getSearchedSkillName(heroClass, skillName));
    }

    @Test
    public void shouldThrowNullPointerExceptionIfNullValueOfHeroClassProvided() {
        //given
        String heroClass = null;
        String skillName = "magic";

        //when
        //then
        assertThrows(NullPointerException.class, () -> HeroClassesAndSkillsLists.getSearchedSkillName(heroClass, skillName));
    }

    @Test
    public void shouldThrowNullPointerExceptionIfNullValueOfSkillNameProvided() {
        //given
        String heroClass = "wizard";
        String skillName = null;

        //when
        //then
        assertThrows(NullPointerException.class, () -> HeroClassesAndSkillsLists.getSearchedSkillName(heroClass, skillName));
    }
}
