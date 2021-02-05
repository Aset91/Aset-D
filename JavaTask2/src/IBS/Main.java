package IBS;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static IBS.CountWords.Counter.countWords;
import static IBS.CountWords.Counter.sortAndPrint;


public class Main {
    private static ArrayList<String> wordList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        File file = new File("TextFile");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String[] a = scanner.next().split("\\p{P}");
            for (String x : a) {
                wordList.add(x.toLowerCase());
            }
        }
        sortAndPrint(wordList);
        countWords(wordList);
    }

}
