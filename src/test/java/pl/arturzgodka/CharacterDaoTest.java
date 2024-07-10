package pl.arturzgodka;

import jakarta.validation.UnexpectedTypeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.arturzgodka.databaseutils.CharacterDao;
import pl.arturzgodka.datamodel.CharacterDataModel;
import pl.arturzgodka.datamodel.FollowerDataModel;
import pl.arturzgodka.datamodel.ItemDataModel;
import pl.arturzgodka.datamodel.SkillDataModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class CharacterDaoTest {
    @Mock
    private CharacterDao characterDaoTestMock; //zrobic tak jak bym korzystal z bazy danych i rzeczywiste a nie mock
    private CharacterDao characterDaoTest;

    private final CharacterDataModel characterDataModel = new CharacterDataModel(14, "Barb", "Barbarian",  35);
    private HashMap<String, Integer> kills = new HashMap<>();
    private HashMap<String, Integer> stats = new HashMap<>();
    private List<SkillDataModel> skills = new ArrayList<>();
    private List<ItemDataModel> items = new ArrayList<>();
    private List<FollowerDataModel> followers = new ArrayList<>();

    @Test
    public void saveCharacterOK() {
        characterDaoTest = new CharacterDao();
        characterDaoTest.saveCharacter(characterDataModel);

        Assertions.assertEquals(characterDataModel.getId(), characterDaoTest.findCharacterById(characterDataModel.getId()).getId());
    }

    @Test
    public void saveCharacterOKMock() {
        characterDaoTestMock.saveCharacter(characterDataModel);
        Mockito.when(characterDaoTestMock.findCharacterById(14)).thenReturn(characterDataModel);

        Assertions.assertEquals(characterDataModel, characterDaoTestMock.findCharacterById(characterDataModel.getId()));
    }

    @Test
    public void saveCharacterWithNullIdValueThrowsException() {
        characterDaoTest = new CharacterDao();
        Assertions.assertThrows(NullPointerException.class, ()-> {
            characterDaoTest.saveCharacter(new CharacterDataModel((Integer)null, "abc", "abc", 17));
        });
    }

    @Test
    public void saveCharacterWithNullNameValueThrowsException() {
        characterDaoTest = new CharacterDao();
        Assertions.assertThrows(UnexpectedTypeException.class, ()-> {
            characterDaoTest.saveCharacter(new CharacterDataModel(1, null, "abc", 17));
        });
    }

    @Test
    public void saveCharacterWithNullClassHeroValueThrowsException() {
        characterDaoTest = new CharacterDao();
        Assertions.assertThrows(UnexpectedTypeException.class, ()-> {
            characterDaoTest.saveCharacter(new CharacterDataModel(1, "abc", null, 17));
        });
    }

    @Test
    public void saveCharacterWithNullLevelValueThrowsException() {
        characterDaoTest = new CharacterDao();
        Assertions.assertThrows(NullPointerException.class, ()-> {
            characterDaoTest.saveCharacter(new CharacterDataModel(1, "abc", "abc", (Integer)null));
        });
    }

    @Test
    public void saveCharacterWithNullObjectThrowsException() {
        characterDaoTest = new CharacterDao();
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            characterDaoTest.saveCharacter(null);
        });
    }

    @Test
    public void deleteUserAsNullValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.deleteCharacter(null);
        });
    }

    @Test
    public void findCharacterById() {
        CharacterDataModel localCharacterDataModel = new CharacterDataModel(14, "Barb", "Barbarian",  35);
        Mockito.when(characterDaoTestMock.findCharacterById(14)).thenReturn(characterDataModel);

        Assertions.assertEquals(characterDaoTestMock.findCharacterById(14).getId(), localCharacterDataModel.getId());
    }

    @Test
    public void changeCharacterLevelAsNullIdValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.changeCharacterLevel((Integer)null, 22);
        });
    }

    @Test
    public void changeCharacterLevelAsNullLevelValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.changeCharacterLevel(2, (Integer)null);
        });
    }

    @Test
    public void changeCharacterParagonLevelAsNullIdlValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.changeCharacterParagonLevel((Integer)null, 22);
        });
    }

    @Test
    public void changeCharacterParagonLevelAsNullLevelValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.changeCharacterParagonLevel(2, (Integer)null);
        });
    }

    @Test
    public void changeCharacterSeasonalAsNullIdValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.changeCharacterSeasonal((Integer)null, false);
        });
    }

    @Test
    public void changeCharacterSeasonalAsNullSeasonalValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.changeCharacterSeasonal(2, (Boolean)null);
        });
    }

    @Test
    public void changeCharacterDeadAsNullIdValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.changeCharacterDead((Integer)null, true);
        });
    }

    @Test
    public void changeCharacterDeadAsNullDeadValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.changeCharacterDead(2, (Boolean)null);
        });
    }

    @Test
    public void changeCharacterKillsAsNullIdValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.changeCharacterKills((Integer)null, kills);
        });
    }

    @Test
    public void changeCharacterKillsAsNullKillsValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.changeCharacterKills(2, null);
        });
    }

    @Test
    public void changeCharacterSkillsAsNullIdValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.changeCharacterSkills((Integer)null, skills);
        });
    }

    @Test
    public void changeCharacterSkillsAsNullSkillsValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.changeCharacterSkills(2, null);
        });
    }

    @Test
    public void changeCharacterItemsAsNullIdValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.changeCharacterItems((Integer)null, items);
        });
    }

    @Test
    public void changeCharacterItemsAsNullItemsValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.changeCharacterItems(2, null);
        });
    }

    @Test
    public void changeCharacterFollowersAsNullIdValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.changeCharacterFollowers((Integer)null, followers);
        });
    }

    @Test
    public void changeCharacterFollowersAsNullFollowersValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.changeCharacterFollowers(2, null);
        });
    }

    @Test
    public void changeCharacterStatsAsNullIdValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.changeCharacterStats((Integer)null, stats);
        });
    }

    @Test
    public void changeCharacterStatsAsNullStatsValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            characterDaoTest.changeCharacterStats(2, null);
        });
    }
}
