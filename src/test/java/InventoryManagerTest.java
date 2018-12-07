import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InventoryManagerTest {
    private InventoryManager inventoryManager;
    List<String> boxIDs;

    @Before
    public void initialize() {
        inventoryManager = new InventoryManager();
        boxIDs = Arrays.asList("aaabbbcee", "aabbcddee", "odddyrenn", "xxxxxxxxx", "sdfkjsakl", "odddytenn", "faagrufnr");
    }

    @Test
    public void that_letters_getting_counted_correctly() {
        String boxId = "aaabbbcdddee";

        int[] letterCounts = inventoryManager.countLetterOccurrencesOfSingle(boxId);

        assertEquals(1, letterCounts[0]);
        assertEquals(1, letterCounts[1]);
    }

    @Test
    public void that_checksum_is_getting_calculated_correctly() {
        int checksum = inventoryManager.getChecksum(boxIDs);

        assertEquals(18, checksum);
    }

    @Test
    public void that_box_ids_which_differ_by_one_character_getting_found() {
        String[] correctBoxIDs = inventoryManager.getCorrectIDs(boxIDs);

        assertEquals("odddyrenn", correctBoxIDs[0]);
        assertEquals("odddytenn", correctBoxIDs[1]);
    }
}
