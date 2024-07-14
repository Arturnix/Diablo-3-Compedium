package pl.arturzgodka;

import pl.arturzgodka.apihandlers.AccountHandlerApi;
import pl.arturzgodka.datamodel.AccountDataModel;
import pl.arturzgodka.datamodel.CharacterDataModel;
import pl.arturzgodka.jsonmappers.AccountMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.arturzgodka.token.FetchToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountMapperTest {

    @Mock
    private AccountMapper testAccountMapperMock;
    private final AccountMapper testAccountMapper = new AccountMapper();
    private FetchToken fetchToken = new FetchToken();
    private AccountDataModel account = testAccountMapper.mapAccountToDataModel(AccountHandlerApi.generateRequest("Ghall#2523", fetchToken));
    private String accountData;
    private final String expectedBattleTag = "Ghall#2523";
    private final int expectedParagonLevel = 1111;
    private final String expectedGuildName = "Phantas Magoria";
    private final ArrayList<CharacterDataModel> heroes = new ArrayList<>(Arrays.asList(
            new CharacterDataModel(1, "A", "barbarian", 15),
            new CharacterDataModel(2, "B", "crusader", 9)
    ));
    private final Map<String, Integer> mapKills = new HashMap<String, Integer>() {{
            put("elites",1974);
    }};
    private final AccountDataModel accountDataModel = new AccountDataModel("Ghall#2523", 1111, "Phantas Magoria",
            heroes, 70, mapKills);

   @Test
    public void correctAccountFetchedToDataModelMock() {
       when(testAccountMapperMock.mapAccountToDataModel(accountData)).thenReturn(accountDataModel);
       assertEquals(expectedBattleTag, testAccountMapperMock.mapAccountToDataModel(accountData).getBattleTag());
    }

    @Test
    public void correctAccountFetchedToDataModel() { //test for container - no mock used

        //given
        //when
        //then
        assertEquals("Ghall#2523", account.getBattleTag());

    }

    @Test
    public void correctParagonLevelFetchedToDataModelMock() {
        when(testAccountMapperMock.mapAccountToDataModel(accountData)).thenReturn(accountDataModel);
        assertEquals(expectedParagonLevel, testAccountMapperMock.mapAccountToDataModel(accountData).getParagonLevel());
    }

    @Test
    public void correctParagonLevelFetchedToDataModel() { //test for container - no mock used

        //given
        //when
        //then
        assertEquals(224, account.getParagonLevel());
    }

    @Test
    public void correctGuildNameFetchedToDataModelMock() {
        when(testAccountMapperMock.mapAccountToDataModel(accountData)).thenReturn(accountDataModel);
        assertEquals(expectedGuildName, testAccountMapperMock.mapAccountToDataModel(accountData).getGuildName());
    }

    @Test
    public void correctHeroesListSizeFetchedToDataModelMock() {
        lenient().when(testAccountMapperMock.mapAccountToDataModel(accountData)).thenReturn(accountDataModel);
        assertEquals(2, heroes.size());
    }

    @Test
    public void correctHeroesListSizeFetchedToDataModel() { //test for container - no mock used

        assertEquals(5, account.getHeroes().size());
    }

    @Test
    public void correctHighestHardcoreLevelFetchedToDataModel() {
        when(testAccountMapperMock.mapAccountToDataModel(accountData)).thenReturn(accountDataModel);
        assertEquals(70, testAccountMapperMock.mapAccountToDataModel(accountData).getHighestHardcoreLevel());
    }

    @Test
    public void correctKillsFetchedToDataModel() {
        when(testAccountMapperMock.mapAccountToDataModel(accountData)).thenReturn(accountDataModel);
        assertTrue(testAccountMapperMock.mapAccountToDataModel(accountData).getKills().containsKey("elites"));
        assertTrue(testAccountMapperMock.mapAccountToDataModel(accountData).getKills().containsValue(1974));
    }

    @Test
    public void providedBattleTagDoesntExistThrowsException() {
       assertThrows(RuntimeException.class, ()-> {
            testAccountMapper.mapAccountToDataModel(ShareableDataForTests.battleTagAsDosentExist);
        });
    }

    @Test
    public void providedAccountDataIsNullThrowsException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            testAccountMapper.mapAccountToDataModel(null);
        });
    }
}
