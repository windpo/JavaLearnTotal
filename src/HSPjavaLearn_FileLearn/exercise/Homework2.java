package HSPjavaLearn_FileLearn.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 风之诗
 * @version 1.0
 */
public class Homework2 {
    public static void main(String[] args) throws IOException {
        final String filePath = "e:\\hello.txt";
        final BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.println(line+"。");
        }

    }
}
