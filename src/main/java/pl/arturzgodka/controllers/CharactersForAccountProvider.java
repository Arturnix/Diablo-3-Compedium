package pl.arturzgodka.controllers;

import pl.arturzgodka.apihandlers.AccountHandlerApi;
import pl.arturzgodka.apihandlers.CharacterHandlerApi;
import pl.arturzgodka.datamodel.*;
import pl.arturzgodka.jsonmappers.AccountMapper;
import pl.arturzgodka.jsonmappers.CharacterMapper;
import pl.arturzgodka.token.FetchToken;


import java.util.ArrayList;
import java.util.List;

public class CharactersForAccountProvider {

    private final FetchToken fetchToken = new FetchToken();
    private final AccountMapper accountMapper = new AccountMapper();
    private final CharacterMapper characterMapper = new CharacterMapper();

    private List<CharacterDataModel> fetchCharactersListForSpecifiedAccount(String battleTag) {
        return accountMapper.fetchHeroesList(AccountHandlerApi.generateRequest(battleTag, fetchToken));
    }

    private CharacterDataModel getCharacterForProvidedBattleTagAndCharacterId(UserDataModel user, int characterId) {
        return characterMapper.mapHeroToDataModel(CharacterHandlerApi.generateRequest(user.getBattleTag(), String.valueOf(characterId), fetchToken));
    }

    private List<Integer> getCharactersIdFromSpecifiedAccount(String battleTag) {
        List<CharacterDataModel> charactersList = fetchCharactersListForSpecifiedAccount(battleTag);
        List<Integer> charactersId = new ArrayList<>();

        for (CharacterDataModel characterDataModel : charactersList) {
            charactersId.add(characterDataModel.getId());
        }

        return charactersId;
    }

    private void assignCharactersToTheirItems(CharacterDataModel characterDataModel) {
        List<ItemDataModel> itemsOnCharacter = characterDataModel.getItems();

        for(ItemDataModel item : itemsOnCharacter) {
            item.setCharacterDataModel(characterDataModel);
        }
    }

    private void assignCharactersToTheirSkills(CharacterDataModel characterDataModel) {
        List<SkillDataModel> skillsOnCharacter = characterDataModel.getSkills();

        for(SkillDataModel skill : skillsOnCharacter) {
            skill.setCharacterDataModel(characterDataModel);
        }
    }

    private List<FollowerDataModel> assignCharactersToTheirFollowers(CharacterDataModel characterDataModel) {
        return characterDataModel.getFollowers();
    }

    private void assignFollowersItemsToTheirOwners(CharacterDataModel characterDataModel, List<FollowerDataModel> followersOnCharacter) {

        for(FollowerDataModel follower : followersOnCharacter) {
            follower.setCharacterDataModel(characterDataModel);

            for(int i = 0; i < follower.getItems().size(); i++) {
                follower.getItems().get(i).setFollowerDataModel(follower);
                follower.getItems().get(i).setCharacterDataModel(characterDataModel);
            }
        }
    }

    private CharacterDataModel setCharacterDataToMakeFullCharacterDataModelForProvidedAccount(UserDataModel user, int characterId) {

        CharacterDataModel characterDataModel = getCharacterForProvidedBattleTagAndCharacterId(user, characterId);
        characterDataModel.setUser(user);
        assignCharactersToTheirItems(characterDataModel);
        assignCharactersToTheirSkills(characterDataModel);
        assignFollowersItemsToTheirOwners(characterDataModel, assignCharactersToTheirFollowers(characterDataModel));

        return characterDataModel;
    }

    public List<CharacterDataModel> assignUserToCharactersOnProvidedAccount(UserDataModel user) {
        List<Integer> charactersIdOnProvidedAccount = getCharactersIdFromSpecifiedAccount(user.getBattleTag());
        List<CharacterDataModel> fullCharactersList = new ArrayList<>();

        for (int characterId : charactersIdOnProvidedAccount) {
            fullCharactersList.add(setCharacterDataToMakeFullCharacterDataModelForProvidedAccount(user, characterId));
        }

        return fullCharactersList;
    }


}

