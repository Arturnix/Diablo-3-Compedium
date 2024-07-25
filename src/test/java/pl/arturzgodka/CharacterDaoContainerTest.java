package pl.arturzgodka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.util.Assert;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import pl.arturzgodka.databaseutils.CharacterDao;
import pl.arturzgodka.datamodel.CharacterDataModel;

import static org.hamcrest.MatcherAssert.assertThat;

@Testcontainers
public class CharacterDaoContainerTest {

    CharacterDao characterDaoTest = new CharacterDao();

    @Container
    private static final PostgreSQLContainer<?> postgresSqlContainer = new PostgreSQLContainer<>( //tworzenie kontenera
            "postgres:16"/*"postgres:16-alpine"*/)
            .withDatabaseName("postgres")
            .withUsername("postgres")
            .withPassword("admin");


    //przekazanie wartosci do Springa aby wiedzial z czym ma sie laczyc. To jest tylko konfiguracja springowa
   /* @DynamicPropertySource
    public static void containerConfig(DynamicPropertyRegistry registry) { //aby nie meczyc sie juz z application properties
        registry.add("spring.datasource.url", postgresSqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresSqlContainer::getUsername);
        registry.add("spring.datasource.password", postgresSqlContainer::getPassword);
    }*/

    @Test
    void addCharacterToDatabase() {
        //given
        CharacterDataModel characterDataModel = new CharacterDataModel(14, "Barb", "Barbarian",  35);

        //when
        characterDaoTest.saveCharacter(characterDataModel);

        //then
        Assertions.assertEquals(14, characterDaoTest.findCharacterById(14).getId());
        Assertions.assertNotNull(characterDaoTest.findCharacterById(14));
    }

    @Test
    void deleteExistingCharacterFromDatabase() {
        //given
        CharacterDataModel characterDataModel = new CharacterDataModel(14, "Barb", "Barbarian",  35);

        //when
        characterDaoTest.saveCharacter(characterDataModel);
        characterDaoTest.deleteCharacter(characterDataModel);

        //then
        Assertions.assertNull(characterDaoTest.findCharacterById(14));
    }

    @Test
    void changeCharacterLevelInDatabase() {
        //given
        CharacterDataModel characterDataModel = new CharacterDataModel(14, "Barb", "Barbarian",  35);

        //when
        characterDaoTest.saveCharacter(characterDataModel);
        characterDaoTest.changeCharacterLevel(14, 15);

        //then
        Assertions.assertEquals(15, characterDaoTest.findCharacterById(14).getLevel());
    }

    //pozostale testy w klasie CharacterDaoTest.java
}
