package IBS.CountWords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Counter {

    public static void sortAndPrint (ArrayList<String> list) {
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }
    public static Map<String, Integer> countWords(ArrayList<String> list) {
        int max = 0;
        HashMap<String, Integer> result = new HashMap<>();
        for (String word : list) {
            int count = result.getOrDefault(word, 0);
            result.put(word, count + 1);

        }
        for (Integer value : result.values() ) {
            if ( max < value) {
                max = value;
            }
        }

        for(String s : result.keySet()) {
            if(result.get(s) == max) {
                System.out.println("Максимальное количество повторений: " + s + " " + max);
            }
        }

        return result;

    }

}
