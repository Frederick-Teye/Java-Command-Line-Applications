package wordcount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordCount {

    public static void main(String[] args) {
        Path path = Path.of("test.txt");
        List<String> lines = null;
        int numberOfwords = 0;
        int numberOfNonWords = 0;

        try {
            lines = Files.readAllLines(path);
            String[] linesArray = lines.toArray(new String[]{});
            
            System.out.println(Arrays.toString(linesArray));
            System.out.println(linesArray.length);
            List<List<String>> linesArray2D = new ArrayList<>();
            
            for (int i = 0; i < linesArray.length; i++) {
                linesArray2D.add(Arrays.asList(linesArray[i].split("[ \t]+")));
            }
            
            System.out.println(linesArray2D);
            
            for (int i = 0; i < linesArray2D.size(); i++) {
                List<String> get = linesArray2D.get(i);
                for (int j = 0; j < get.size(); j++) {
                    String word = get.get(j);
                    if (!word.isEmpty()) {
                        numberOfwords++;
                    } else {
                        numberOfNonWords++;
                    }
                }
            }
            
            System.out.println("Number of words is: " + numberOfwords);
            System.out.println("Number of non words is: " + numberOfNonWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
