import java.util.Arrays;
import java.util.List;

class InventoryManager {
    private int[] letterCountsOfAll = new int[2];
    private boolean twoOccurrences = false;
    private boolean threeOccurrences = false;
    private List<Character> alphabet = Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

    int getChecksum(List<String> boxIds) {
        int[] letterOccurrences = countLetterOccurrences(boxIds);

        return letterOccurrences[0] * letterOccurrences[1];
    }

    int[] countLetterOccurrences(List<String> boxIds) {
        for(String boxId : boxIds) {
            int[] letterCountsOfSingle = countLetterOccurrencesOfSingle(boxId);

            letterCountsOfAll[0] += letterCountsOfSingle[0];
            letterCountsOfAll[1] += letterCountsOfSingle[1];
        }
        return letterCountsOfAll;
    }

    int[] countLetterOccurrencesOfSingle(String boxId) {
        int[] letterCountsOfOneBoxId = new int[2];

        for (Character letter : alphabet) {
            int count = 0;

            for (int i = 0; i < boxId.length(); i++) {
                if (boxId.charAt(i) == letter) {
                    count++;
                }
            }

            if (count == 2 && !twoOccurrences) {
                letterCountsOfOneBoxId[0]++;
                twoOccurrences = true;
            } else if (count == 3 && !threeOccurrences) {
                letterCountsOfOneBoxId[1]++;
                threeOccurrences = true;
            }
        }

        return letterCountsOfOneBoxId;
    }
}
