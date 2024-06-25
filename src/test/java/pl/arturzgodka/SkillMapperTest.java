package pl.arturzgodka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.arturzgodka.datamodel.HeroSkillDataModel;
import pl.arturzgodka.datamodel.SkillDataModel;
import pl.arturzgodka.jsonmappers.SkillMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class SkillMapperTest {

    @Mock
    private SkillMapper testSkillMapperMock;
    private final SkillMapper testSkillMapper = new SkillMapper();
    private final String heroClass = "barbarian";
    private final List<String> barbarianSkills = Arrays.asList("bash", "hammer-of-the-ancients", "cleave");
    private final List<String> barbarianSkillsWrong = Arrays.asList("abcbash", "abchammer-of-the-ancients", "abccleave");
    private final List<SkillDataModel> skillRunes = new ArrayList<>();
    private final List<HeroSkillDataModel> fetchedSkillsList = new ArrayList<>(Arrays.asList(
            new HeroSkillDataModel("bash", 1, "abc", "icon", skillRunes),
            new HeroSkillDataModel("hammer-of-the-ancients", 1, "abc", "icon", skillRunes),
            new HeroSkillDataModel("cleave", 1, "abc", "icon", skillRunes)
    ));

    @Test
    public void correctSkillsFetchedToDataModel() {
        Mockito.when(testSkillMapperMock.mapSkillsToDataModel(heroClass, barbarianSkills)).thenReturn(fetchedSkillsList);
        Assertions.assertEquals("bash", testSkillMapperMock.mapSkillsToDataModel(heroClass, barbarianSkills).get(0).getName());
        Assertions.assertEquals("hammer-of-the-ancients", testSkillMapperMock.mapSkillsToDataModel(heroClass, barbarianSkills).get(1).getName());
        Assertions.assertEquals("cleave", testSkillMapperMock.mapSkillsToDataModel(heroClass, barbarianSkills).get(2).getName());
    }

    @Test
    public void correctNumberOfSkillsFetched() {
        Mockito.when(testSkillMapperMock.mapSkillsToDataModel(heroClass, barbarianSkills)).thenReturn(fetchedSkillsList);
        Assertions.assertEquals(3, testSkillMapperMock.mapSkillsToDataModel(heroClass, barbarianSkills).size());
    }

    @Test
    public void providedHeroClassDoesntExistThrowsException() {
        Assertions.assertThrows(RuntimeException.class, ()-> {
            testSkillMapper.mapSkillsToDataModel("aaa", barbarianSkills);
        });
    }

    @Test
    public void providedHeroClassIsNullThrowsException() {
        Assertions.assertThrows(RuntimeException.class, ()-> {
            testSkillMapper.mapSkillsToDataModel(null, barbarianSkills);
        });
    }

    @Test
    public void providedSkillsListContainsWrongElementsThrowsException() {
        Assertions.assertThrows(RuntimeException.class, ()-> {
            testSkillMapper.mapSkillsToDataModel("barbarian", barbarianSkillsWrong);
        });
    }

    @Test
    public void providedSkillsListIsNullThrowsException() {
        Assertions.assertThrows(NullPointerException.class, ()-> {
            testSkillMapper.mapSkillsToDataModel("barbarian", null);
        });
    }
}
