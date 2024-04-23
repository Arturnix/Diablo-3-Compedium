package pl.arturzgodka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.arturzgodka.databaseutils.UserDao;
import pl.arturzgodka.datamodel.User;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class UserDaoTest {

    @Mock
    private UserDao userDaoTestMock;
    private UserDao userDaoTest;
    @Mock
    private ArrayList<Character> charactersList;
    private User user = new User(142L, "abc@abc.com", "abc",  charactersList, "abc");

    @Test
    public void saveUserWithNullEmailValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, ()-> {
            userDaoTest.saveUser(new User(142L, null, "abc",  charactersList, "abc"));
        });
    }

    @Test
    public void saveUserWithNullPasswordValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, ()-> {
            userDaoTest.saveUser(new User(142L, "abc@abc.com", null,  charactersList, "abc"));
        });
    }

    @Test
    public void saveUserWithNullCharListValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, ()-> {
            userDaoTest.saveUser(new User(142L, "abc@abc.com", "abc",  null, "abc"));
        });
    }

    @Test
    public void saveUserWithNullBattleTagValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, ()-> {
            userDaoTest.saveUser(new User(142L, "abc@abc.com", "abc",  charactersList, null));
        });
    }

    @Test
    public void deleteUserWithNullEmailValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            userDaoTest.deleteUser(new User(142L, null, "abc", charactersList, "abc"));
        });
    }

    @Test
    public void deleteUserWithNullPasswordValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            userDaoTest.deleteUser(new User(142L, "abc@abc.com", null, charactersList, "abc"));
        });
    }

    @Test
    public void deleteUserWithNullCharListValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            userDaoTest.deleteUser(new User(142L, "abc@abc.com", "abc", null, "abc"));
        });
    }

    @Test
    public void deleteUserWithNullBattleTagValueThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            userDaoTest.deleteUser(new User(142L, "abc@abc.com", "abc", charactersList, null));
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
        User localUser = new User(142L, "abc@abc.com", "abc",  charactersList, "abc");
        Mockito.when(userDaoTestMock.findUserByEmail("abc@abc.com")).thenReturn(user);

        Assertions.assertEquals(userDaoTestMock.findUserByEmail("abc@abc.com").getEmail(), localUser.getEmail());
    }

    @Test
    public void changeBattleTagToNullValueThrowsException() {
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
