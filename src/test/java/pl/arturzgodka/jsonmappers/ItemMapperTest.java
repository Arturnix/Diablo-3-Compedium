package pl.arturzgodka.jsonmappers;

import org.junit.jupiter.api.Test;
import pl.arturzgodka.ShareableDataForTests;
import pl.arturzgodka.apihandlers.ItemHandlerApi;
import pl.arturzgodka.datamodel.ItemDataModel;
import pl.arturzgodka.jsonmappers.ItemMapper;
import pl.arturzgodka.token.FetchToken;

import static org.junit.jupiter.api.Assertions.*;

public class ItemMapperTest {

    private ItemMapper itemMapper = new ItemMapper();
    private FetchToken fetchToken = new FetchToken();

    @Test
    public void correctArmorItemTypeFetchedToDataModel() { //test for container - no mock used

        //given
        //when
        ItemDataModel armor = itemMapper.mapItemToArmorTypeDataModel(ItemHandlerApi.generateRequest("veil-of-steel-p43_RetroHelm_003", fetchToken));

        //then
        assertEquals("Stalowy Całun", armor.getName());
    }

    @Test
    public void correctWeaponItemTypeFetchedToDataModel() { //test for container - no mock used

        //given
        //when
        ItemDataModel weapon = itemMapper.mapItemToWeaponTypeDataModel(ItemHandlerApi.generateRequest("corrupted-ashbringer-Unique_Sword_2H_104_x1", fetchToken));

        //then
        assertEquals("Spaczony Spopielacz", weapon.getName());
    }

    @Test
    public void providedItemSlugAndIdDoesntExistThrowsException() {
        assertThrows(RuntimeException.class, ()-> {
            itemMapper.mapItemToDataModel(ShareableDataForTests.itemSlugAndIdAsDoesntExist);
        });
    }

    @Test
    public void providedItemDataNullThrowsException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            itemMapper.mapItemToDataModel(null);
        });
    }
}
