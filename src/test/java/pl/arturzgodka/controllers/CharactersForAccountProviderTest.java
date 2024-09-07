package pl.arturzgodka.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.arturzgodka.datamodel.CharacterDataModel;
import pl.arturzgodka.datamodel.SkillDataModel;
import pl.arturzgodka.datamodel.UserDataModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(MockitoExtension.class)
public class CharactersForAccountProviderTest {

    @Mock
    private CharactersForAccountProvider charactersForAccountProviderMock;

    private final List<CharacterDataModel> charactersList = new ArrayList<CharacterDataModel>(Arrays.asList(
            new CharacterDataModel(1, "Abc", "barbarian", 15),
            new CharacterDataModel(2, "Def", "wizard", 53),
            new CharacterDataModel(3, "Ghi", "crusader", 42)
    ));

   private final CharactersForAccountProvider charactersForAccountProvider = new CharactersForAccountProvider();

    @Test
    public void shouldReturnListOfCharactersForProvidedAccount() {
        //given
        UserDataModel userTest = new UserDataModel("abc@abc.com", "admin123", charactersList, "abc#123");

        //when
        Mockito.when(charactersForAccountProviderMock.assignUserToCharactersOnProvidedAccount(userTest)).thenReturn(charactersList);

        //then
        assertThat(charactersForAccountProviderMock.assignUserToCharactersOnProvidedAccount(userTest), not(empty()));
        assertThat(charactersForAccountProviderMock.assignUserToCharactersOnProvidedAccount(userTest), hasSize(3));
        assertThat(charactersForAccountProviderMock.assignUserToCharactersOnProvidedAccount(userTest).get(0), instanceOf(CharacterDataModel.class));
    }

    @Test
    public void shouldThrowExceptionWhenEmptyUserProvided() {
        //given
        UserDataModel userTest = new UserDataModel();

        //when
        //then
        Assertions.assertThrows(NullPointerException.class, ()-> {
            charactersForAccountProvider.assignUserToCharactersOnProvidedAccount(userTest);
        });
    }

    @Test
    public void shouldThrowExceptionWhenUserWithNoBattleTagProvided() {
        //given
        UserDataModel userTest = new UserDataModel("abc@abc.com", "admin123", charactersList, null);

        //when
        //then
        Assertions.assertThrows(NullPointerException.class, ()-> {
            charactersForAccountProvider.assignUserToCharactersOnProvidedAccount(userTest);
        });
    }

    @Test
    public void shouldThrowExceptionWhenUserIsNull() {
        //given
        UserDataModel userTest = null;

        //when
        //then
        Assertions.assertThrows(NullPointerException.class, ()-> {
            charactersForAccountProvider.assignUserToCharactersOnProvidedAccount(userTest);
        });
    }

}
