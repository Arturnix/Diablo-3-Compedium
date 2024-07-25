package pl.arturzgodka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
public class CharacterDaoContainerTest {

    private final CharacterDao characterDaoTest = new CharacterDao();
    private CharacterDataModel characterDataModel;
    @BeforeEach
    public void initializeDataModelAndAddItToDatabase() {
        characterDataModel = new CharacterDataModel(14, "Barb", "Barbarian",  35);
        characterDaoTest.saveCharacter(characterDataModel);
    }


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
