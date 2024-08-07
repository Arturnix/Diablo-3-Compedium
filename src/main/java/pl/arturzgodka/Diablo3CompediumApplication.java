package pl.arturzgodka;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.arturzgodka.apihandlers.AccountHandlerApi;
import pl.arturzgodka.apihandlers.CharacterHandlerApi;
import pl.arturzgodka.apihandlers.ItemHandlerApi;
import pl.arturzgodka.apihandlers.SkillHandlerApi;
import pl.arturzgodka.controllers.ItemClassesAndNamesLists;
import pl.arturzgodka.databaseutils.CharacterDao;
import pl.arturzgodka.databaseutils.UserDao;
import pl.arturzgodka.datamodel.*;
import pl.arturzgodka.jsonmappers.AccountMapper;
import pl.arturzgodka.jsonmappers.CharacterMapper;
import pl.arturzgodka.jsonmappers.ItemMapper;
import pl.arturzgodka.token.FetchToken;
import pl.arturzgodka.token.Token;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@EntityScan( basePackages = {"pl.arturzgodka.datamodel.ItemDataModel"} ) // entities package name
public class Diablo3CompediumApplication {

    public static void main(String[] args) {
        SpringApplication.run(Diablo3CompediumApplication.class, args);

        //FetchToken fetchToken = new FetchToken();
        //ItemMapper itemMapper = new ItemMapper();
        //System.out.println(itemMapper.mapItemToArmorTypeDataModel(ItemHandlerApi.generateRequest("vyrs-sightless-skull-Unique_Helm_Set_13_x1", fetchToken)));
        //System.out.println(itemMapper.mapItemToArmorTypeDataModel(ItemHandlerApi.generateRequest("tragouls-scales-P6_Necro_Set_2_Chest", fetchToken)));
        //System.out.println(ItemClassesAndNamesLists.getSelectedItemList("Weapon", "Axes"));
        //System.out.println(ItemClassesAndNamesLists.getArmorSelectedItemFullLists("Armor", "Armors"));

        /*ItemWeaponDataModel weapon1 = (ItemWeaponDataModel) itemMapper.mapItemToWeaponTypeDataModel(ItemHandlerApi.generateRequest("corrupted-ashbringer-Unique_Sword_2H_104_x1", fetchToken));
        System.out.println(weapon1.getSingleAttribute("primary", 0, "text"));
        for(int i = 0; i < weapon1.getAttributesSize("secondary"); i++) {
            System.out.println(weapon1.getSingleAttribute("secondary", i, "text"));
        }*/
        //simple-dagger-Dagger_001

        /*AccountHandlerApi accountHandlerApi = new AccountHandlerApi();
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

            List<FollowerDataModel> followersOnCharacter = characterDataModel.getFollowers();
            for(FollowerDataModel follower : followersOnCharacter) {
                follower.setCharacterDataModel(characterDataModel);
                for(int i = 0; i < follower.getItems().size(); i++) {
                    follower.getItems().get(i).setFollowerDataModel(follower);
                    follower.getItems().get(i).setCharacterDataModel(characterDataModel);
                }
            }
            fullCharactersList.add(characterDataModel);
        }

        userDataModel1.setCharacters(fullCharactersList);
        userDao.saveUser(userDataModel1);*/

        //CharacterDataModel characterDataModel = characterMapper.mapHeroToDataModel(characterHandlerApi.generateRequest("Ghall#2523", "170761702", fetchToken));

        /*FetchToken fetchToken = new FetchToken();
        System.out.println(SkillHandlerApi.generateRequest("barbarian", null, fetchToken));*/
    }
}
