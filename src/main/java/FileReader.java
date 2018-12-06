import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

class FileReader {
    private final static String FILE_NAME = "/box_ids.txt";
    private final static Charset ENCODING = StandardCharsets.UTF_8;

    List<String> getListOfBoxIDs() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream(FILE_NAME);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, ENCODING));

        List<String> listOfBoxIDs = new ArrayList<>();
        String zeile;

        while ((zeile = reader.readLine()) != null) {
            listOfBoxIDs.add(zeile);
        }

        return listOfBoxIDs;
    }
}
