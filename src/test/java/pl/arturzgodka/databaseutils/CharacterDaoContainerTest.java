package pl.arturzgodka.databaseutils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.arturzgodka.TestContainerData;
import pl.arturzgodka.databaseutils.CharacterDao;
import pl.arturzgodka.datamodel.CharacterDataModel;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterDaoContainerTest extends TestContainerData {

    private final CharacterDao characterDaoTest = new CharacterDao();
    private CharacterDataModel characterDataModel;
    @BeforeEach
    public void initializeDataModelAndAddItToDatabase() {
        characterDataModel = new CharacterDataModel(14, "Barb", "Barbarian",  35);
        characterDaoTest.saveCharacter(characterDataModel);
    }

    @Test
    void addCharacterToDatabase() {
        //given @BeforeEach
        //when
        //then
        assertNotNull(characterDaoTest.findCharacterById(14));
    }

    @Test
    public void findCharacterInDatabaseById() {
        //given @BeforeEach
        //when
        //then
        assertEquals(14, characterDaoTest.findCharacterById(14).getId());

    }

    @Test
    void deleteExistingCharacterFromDatabase() {
        //given @BeforeEach
        //when
        characterDaoTest.deleteCharacter(characterDataModel);

        //then
        assertNull(characterDaoTest.findCharacterById(14));
    }

    @Test
    void changeCharacterLevelInDatabase() {
        //given @BeforeEach
        //when
        characterDaoTest.changeCharacterLevel(14, 15);

        //then
        assertEquals(15, characterDaoTest.findCharacterById(14).getLevel());
    }

    //pozostale testy w klasie CharacterDaoTest.java
}
