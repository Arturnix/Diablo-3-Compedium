package pl.arturzgodka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import pl.arturzgodka.databaseutils.UserDao;
import pl.arturzgodka.datamodel.CharacterDataModel;
import pl.arturzgodka.datamodel.UserDataModel;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UserDaoContainerTest extends TestContainerData {

    private final UserDao userDaoTest = new UserDao();
    private UserDataModel userDataModel;
    private List<CharacterDataModel> charactersList = new ArrayList<CharacterDataModel>();

    @BeforeEach
    public void initializeDataModelAndSaveItInDatabase() {
        userDataModel = new UserDataModel("abc@abc.com", "abc",  charactersList, "abc");
        userDaoTest.saveUser(userDataModel);
    }

    @Test
    public void saveUserInDatabase() {
        //given @BeforeEach
        //when
        //then
        assertNotNull(userDaoTest.findUserByEmail("abc@abc.com"));
    }

    @Test
    public void findUserInDatabaseByEmail() {
        //given @BeforeEach
        //when
        //then
        assertEquals(userDaoTest.findUserByEmail("abc@abc.com").getEmail(), userDataModel.getEmail());
    }

    @Test
    public void changeUserBattleTag() {
        //given @BeforeEach
        //when
        userDaoTest.changeUserBattleTag("abc@abc.com", "123abc");

        //then
        assertEquals("123abc", userDaoTest.findUserByEmail("abc@abc.com").getBattleTag());
    }
}
