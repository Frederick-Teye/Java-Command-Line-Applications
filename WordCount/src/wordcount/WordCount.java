package wordcount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WordCount {

    public static void main(String[] args) {
        Path path = Path.of("test.txt");
        List<String> lines = null;
        
        try {
            lines = Files.readAllLines(path);
            String[] linesArray = lines.toArray(new String[] {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
