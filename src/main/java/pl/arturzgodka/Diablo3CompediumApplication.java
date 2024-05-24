package pl.arturzgodka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.arturzgodka.apihandlers.AccountHandlerApi;
import pl.arturzgodka.apihandlers.CharacterHandlerApi;
import pl.arturzgodka.databaseutils.CharacterDao;
import pl.arturzgodka.databaseutils.FollowerDao;
import pl.arturzgodka.databaseutils.ItemDao;
import pl.arturzgodka.databaseutils.UserDao;
import pl.arturzgodka.datamodel.*;
import pl.arturzgodka.jsonmappers.AccountMapper;
import pl.arturzgodka.jsonmappers.CharacterMapper;
import pl.arturzgodka.token.FetchToken;
import pl.arturzgodka.token.Token;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
//@EntityScan( basePackages = {"pl.arturzgodka.datamodel.ItemDataModel"} ) // entities package name
public class Diablo3CompediumApplication {

    public static void main(String[] args) {
        SpringApplication.run(Diablo3CompediumApplication.class, args);

        AccountHandlerApi accountHandlerApi = new AccountHandlerApi();
        CharacterHandlerApi characterHandlerApi = new CharacterHandlerApi();
        FetchToken fetchToken = new FetchToken();
        AccountMapper accountMapper = new AccountMapper();
        CharacterMapper characterMapper = new CharacterMapper();
        UserDao userDao = new UserDao();
        CharacterDao characterDao = new CharacterDao();

        List<CharacterDataModel> charactersList = accountMapper.fetchHeroesList(accountHandlerApi.generateRequest("Ghall#2523", fetchToken));
        List<Integer> charactersId = new ArrayList<>();
        for (CharacterDataModel characterDataModel : charactersList) {
            charactersId.add(characterDataModel.getId());
        }

        List<CharacterDataModel> fullCharactersList = new ArrayList<>();
        UserDataModel userDataModel1 = new UserDataModel("abc@abc.com", "abc", fullCharactersList, "Ghall#2523");

        for (Integer characterId : charactersId) {
            CharacterDataModel characterDataModel = characterMapper.mapHeroToDataModel(characterHandlerApi.generateRequest("Ghall#2523", String.valueOf(characterId), fetchToken));
            characterDataModel.setUser(userDataModel1);

            List<ItemDataModel> itemsOnCharacter = characterDataModel.getItems();
            for(ItemDataModel item : itemsOnCharacter) {
                item.setCharacterDataModel(characterDataModel);
            }

            List<SkillDataModel> skillsOnCharacter = characterDataModel.getSkills();
            for(SkillDataModel skill : skillsOnCharacter) {
                skill.setCharacterDataModel(characterDataModel);
            }

            fullCharactersList.add(characterDataModel);
        }

        userDataModel1.setCharacters(fullCharactersList);
        userDao.saveUser(userDataModel1);

        //CharacterDataModel characterDataModel = characterMapper.mapHeroToDataModel(characterHandlerApi.generateRequest("Ghall#2523", "170761702", fetchToken));
    }
}
