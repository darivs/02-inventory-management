import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InventoryManager inventoryManager = new InventoryManager();
        FileReader fileReader = new FileReader();

        List<String> listOfBoxIDs = fileReader.getListOfBoxIDs();

        int checksum = inventoryManager.getChecksum(listOfBoxIDs);

        System.out.println(checksum);
    }
}
