package pl.arturzgodka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.arturzgodka.apihandlers.AccountHandlerApi;
import pl.arturzgodka.databaseutils.UserDao;
import pl.arturzgodka.datamodel.CharacterDataModel;
import pl.arturzgodka.datamodel.UserDataModel;
import pl.arturzgodka.jsonmappers.AccountMapper;
import pl.arturzgodka.token.FetchToken;
import pl.arturzgodka.token.Token;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Diablo3CompediumApplication {

    public static void main(String[] args) {
        SpringApplication.run(Diablo3CompediumApplication.class, args);

        /*List<CharacterDataModel> charactersList = new ArrayList<>();
        UserDataModel userDataModel1 = new UserDataModel(142L, "abc@abc.com", "abc", charactersList, "abc#123");
        CharacterDataModel characterDataModel1 = new CharacterDataModel(2, "Jan", "Barbarian", 17);
        characterDataModel1.setUser(userDataModel1);
        charactersList.add(characterDataModel1);
        userDataModel1.setCharacters(charactersList);
        UserDao userDao = new UserDao();*/

        AccountHandlerApi accountHandlerApi = new AccountHandlerApi();
        FetchToken fetchToken = new FetchToken();
        AccountMapper accountMapper = new AccountMapper();
        UserDao userDao = new UserDao();

        List<CharacterDataModel> charactersList = accountMapper.fetchHeroesList(accountHandlerApi.generateRequest("Ghall#2523", fetchToken));
        UserDataModel userDataModel1 = new UserDataModel(142L, "abc@abc.com", "abc", charactersList, "Ghall#2523");

        /*System.out.println(accountHandlerApi.generateRequest("Ghall#2523", fetchToken));
        System.out.println(accountMapper.fetchHeroesList(accountHandlerApi.generateRequest("Ghall#2523", fetchToken)));*/

        userDao.saveUser(userDataModel1);
    }

}
