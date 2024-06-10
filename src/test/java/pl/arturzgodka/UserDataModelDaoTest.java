package pl.arturzgodka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.arturzgodka.databaseutils.UserDao;
import pl.arturzgodka.datamodel.UserDataModel;
import pl.arturzgodka.datamodel.CharacterDataModel;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserDataModelDaoTest {

    @Mock
    private UserDao userDaoTestMock;
    private UserDao userDaoTest;
    @Mock
    private List<CharacterDataModel> charactersList;
    private final UserDataModel userDataModel = new UserDataModel("abc@abc.com", "abc",  charactersList, "abc");

    @Test
    public void saveUserWithNullEmailValueThrowsException() {
        userDaoTest = new UserDao();
        Assertions.assertThrows(NullPointerException.class, ()-> {
            userDaoTest.saveUser(new UserDataModel(null, "abc",  charactersList, "abc"));
        });
    }

    @Test
    public void saveUserWithNullPasswordValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, ()-> {
            userDaoTest.saveUser(new UserDataModel("abc@abc.com", null,  charactersList, "abc"));
        });
    }

    @Test
    public void saveUserWithNullCharListValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, ()-> {
            userDaoTest.saveUser(new UserDataModel("abc@abc.com", "abc",  null, "abc"));
        });
    }

    @Test
    public void saveUserWithNullBattleTagValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, ()-> {
            userDaoTest.saveUser(new UserDataModel("abc@abc.com", "abc",  charactersList, null));
        });
    }

    @Test
    public void deleteUserWithNullEmailValueThrowsException() {
        userDaoTest = new UserDao();
        Assertions.assertThrows(NullPointerException.class, () -> {
            userDaoTest.deleteUser(new UserDataModel(null, "abc", charactersList, "abc"));
        });
    }

    @Test
    public void deleteUserWithNullPasswordValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            userDaoTest.deleteUser(new UserDataModel("abc@abc.com", null, charactersList, "abc"));
        });
    }

    @Test
    public void deleteUserWithNullCharListValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            userDaoTest.deleteUser(new UserDataModel("abc@abc.com", "abc", null, "abc"));
        });
    }

    @Test
    public void deleteUserWithNullBattleTagValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            userDaoTest.deleteUser(new UserDataModel("abc@abc.com", "abc", charactersList, null));
        });
    }

    @Test
    public void deleteUserAsNullValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            userDaoTest.deleteUser(null);
        });
    }

    @Test
    public void findUserByEmail() {
        UserDataModel localUserDataModel = new UserDataModel("abc@abc.com", "abc",  charactersList, "abc");
        Mockito.when(userDaoTestMock.findUserByEmail("abc@abc.com")).thenReturn(userDataModel);

        Assertions.assertEquals(userDaoTestMock.findUserByEmail("abc@abc.com").getEmail(), localUserDataModel.getEmail());
    }

    @Test
    public void changeBattleTagToNullValueThrowsException() {
        userDaoTest = new UserDao();
        Assertions.assertThrows(NullPointerException.class, () -> {
            userDaoTest.changeUserBattleTag( "abc@abc.com",null);
        });
    }

    @Test
    public void changeBattleTagWithNullEmailValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            userDaoTest.changeUserBattleTag( null,"abc");
        });
    }

}
