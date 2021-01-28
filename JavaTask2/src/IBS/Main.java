package IBS;

import IBS.CountWords.Counter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<String> wordList = new ArrayList<>();
        File file = new File("D:\\IBS_tasks\\JavaTask2\\TextFile");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String[] a = scanner.next().split("\\p{P}");
            for (String x : a) {
                wordList.add(x.toLowerCase());
            }
        }
        Collections.sort(wordList);
        for (String s : wordList) {
            System.out.println(s);
        }

        Map<String, Integer> map = Counter.countWords(wordList);
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
