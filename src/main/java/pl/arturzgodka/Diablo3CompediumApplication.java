package pl.arturzgodka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.arturzgodka.apihandlers.AccountHandlerApi;
import pl.arturzgodka.databaseutils.CharacterDao;
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

        AccountHandlerApi accountHandlerApi = new AccountHandlerApi();
        FetchToken fetchToken = new FetchToken();
        AccountMapper accountMapper = new AccountMapper();
        UserDao userDao = new UserDao();
        CharacterDao charDao = new CharacterDao();

        List<CharacterDataModel> charactersList = accountMapper.fetchHeroesList(accountHandlerApi.generateRequest("Ghall#2523", fetchToken));
        UserDataModel userDataModel1 = new UserDataModel("abc@abc.com", "abc", charactersList, "Ghall#2523");
        for (CharacterDataModel characterDataModel : charactersList) {
            characterDataModel.setUser(userDataModel1);
        }

        userDao.saveUser(userDataModel1);

        CharacterDataModel charDataModel1 = new CharacterDataModel(14, "Barb", "Barbarian",  35);
        charDataModel1.setUser(userDao.findUserByEmail("abc@abc.com"));
        charDao.saveCharacter(charDataModel1);
    }

}
