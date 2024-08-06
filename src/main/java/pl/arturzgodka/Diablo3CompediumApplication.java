package pl.arturzgodka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan( basePackages = {"pl.arturzgodka.datamodel.ItemDataModel"} ) // entities package name
public class Diablo3CompediumApplication {

    public static void main(String[] args) {
        SpringApplication.run(Diablo3CompediumApplication.class, args);

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
