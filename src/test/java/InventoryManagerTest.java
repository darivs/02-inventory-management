import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InventoryManagerTest {
    private InventoryManager inventoryManager;
    private int[] letterCounts;

    @Before
    public void initialize() {
        inventoryManager = new InventoryManager();
        letterCounts = new int[2];
    }

    @Test
    public void that_letters_getting_counted_correctly() {
        String boxId = "aaabbbcdddee";

        letterCounts = inventoryManager.countLetterOccurrencesOfSingle(boxId);

        assertEquals(1, letterCounts[0]);
        assertEquals(1, letterCounts[1]);
    }

    @Test
    public void that_checksum_is_getting_calculated_correctly() {
        List<String> boxIds = Arrays.asList("aaabbbcdddee", "aabbcddee", "odddyrenn", "xxxxxxxx");

        int checksum = inventoryManager.getChecksum(boxIds);

        assertEquals(6, checksum);
    }
}
