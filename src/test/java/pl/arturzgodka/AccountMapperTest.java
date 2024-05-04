package pl.arturzgodka;

import pl.arturzgodka.datamodel.AccountDataModel;
import pl.arturzgodka.datamodel.CharacterDataModel;
import pl.arturzgodka.jsonmappers.AccountMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class AccountMapperTest {

    @Mock
    private AccountMapper testAccountMapperMock;
    private String accountData;
    private final AccountMapper testAccountMapper = new AccountMapper();
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
    public void correctAccountFetchedToDataModel() {
       Mockito.when(testAccountMapperMock.mapAccountToDataModel(accountData)).thenReturn(accountDataModel);
       Assertions.assertEquals(expectedBattleTag, testAccountMapperMock.mapAccountToDataModel(accountData).getBattleTag());
    }

    @Test
    public void correctParagonLevelFetchedToDataModel() {
        Mockito.when(testAccountMapperMock.mapAccountToDataModel(accountData)).thenReturn(accountDataModel);
        Assertions.assertEquals(expectedParagonLevel, testAccountMapperMock.mapAccountToDataModel(accountData).getParagonLevel());
    }

    @Test
    public void correctGuildNameFetchedToDataModel() {
        Mockito.when(testAccountMapperMock.mapAccountToDataModel(accountData)).thenReturn(accountDataModel);
        Assertions.assertEquals(expectedGuildName, testAccountMapperMock.mapAccountToDataModel(accountData).getGuildName());
    }

    @Test
    public void correctHeroesListSizeFetchedToDataModel() {
        lenient().when(testAccountMapperMock.mapAccountToDataModel(accountData)).thenReturn(accountDataModel);
        Assertions.assertEquals(2, heroes.size());
    }

    @Test
    public void correctHighestHardcoreLevelFetchedToDataModel() {
        Mockito.when(testAccountMapperMock.mapAccountToDataModel(accountData)).thenReturn(accountDataModel);
        Assertions.assertEquals(70, testAccountMapperMock.mapAccountToDataModel(accountData).getHighestHardcoreLevel());
    }

    @Test
    public void correctKillsFetchedToDataModel() {
        Mockito.when(testAccountMapperMock.mapAccountToDataModel(accountData)).thenReturn(accountDataModel);
        Assertions.assertTrue(testAccountMapperMock.mapAccountToDataModel(accountData).getKills().containsKey("elites"));
        Assertions.assertTrue(testAccountMapperMock.mapAccountToDataModel(accountData).getKills().containsValue(1974));
    }

    @Test
    public void providedBattleTagDoesntExistThrowsException() {
        Assertions.assertThrows(RuntimeException.class, ()-> {
            testAccountMapper.mapAccountToDataModel(ShareableDataForTests.battleTagAsDosentExist);
        });
    }

    @Test
    public void providedAccountDataIsNullThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            testAccountMapper.mapAccountToDataModel(null);
        });
    }
}
