package lab7;

import java.util.*;

public class Main1 {
    public static void countWords(String text) {
        String[] words = text.split("[,.\\s]+");
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            if (!wordCounts.containsKey(word)) {
                wordCounts.put(word, 1);
            } else {
                int count = wordCounts.get(word);
                wordCounts.put(word, count + 1);
            }
        }

        for (String word : wordCounts.keySet()) {
            int count = wordCounts.get(word);
            System.out.println(word + " - " + count);
        }
    }

    public static void main(String[] args) {
        String str = "Hi, a, a, b, gone, passed, array, array.";

        countWords(str);
    }
}
