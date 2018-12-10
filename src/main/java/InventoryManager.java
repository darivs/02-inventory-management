import java.util.Arrays;
import java.util.List;

class InventoryManager {
    private int[] letterCountsOfAll = new int[2];
    private List<Character> alphabet = Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

    int getChecksum(List<String> boxIds) {
        int[] letterOccurrences = countLetterOccurrences(boxIds);

        return letterOccurrences[0] * letterOccurrences[1];
    }

    private int[] countLetterOccurrences(List<String> boxIds) {
        for (String boxId : boxIds) {
            int[] letterCountsOfSingle = countLetterOccurrencesOfSingle(boxId);

            letterCountsOfAll[0] += letterCountsOfSingle[0];
            letterCountsOfAll[1] += letterCountsOfSingle[1];
        }
        return letterCountsOfAll;
    }

    int[] countLetterOccurrencesOfSingle(String boxId) {
        int[] letterCountsOfOneBoxId = new int[2];
        boolean twoOccurrences = false;
        boolean threeOccurrences = false;

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

    String[] getCorrectIDs(List<String> boxIDs) {
        String[] correctIDs = new String[2];

        outerloop:
        for (String boxID : boxIDs) {
            char[] firstBoxID = boxID.toCharArray();

            for (int j = 1; j < boxIDs.size(); j++) {
                char[] secondBoxID = boxIDs.get(j).toCharArray();
                int differs = 0;

                for (int k = 0; k < secondBoxID.length; k++) {
                    if (firstBoxID[k] != secondBoxID[k]) {
                        differs++;
                    }

                    if (differs > 1) {
                        break;
                    } else if (differs == 1 && k == secondBoxID.length - 1) {
                        correctIDs[0] = new String(firstBoxID);
                        correctIDs[1] = new String(secondBoxID);

                        break outerloop;
                    }
                }

            }

        }

        return correctIDs;
    }
}
