package Chapter16_Moderate;

import java.util.HashMap;

/**
 * Word Frequencies: Design a method to find the frequency of occurrences of any given word in a
 * book. What if we were running this algorithm mUltiple times?
 */
public class WordFrequency {
    int getFrequency(String[] book, String word) {
        word = word.trim().toLowerCase();
        int count = 0;
        for (String w : book) {
            if (w.trim().toLowerCase().equals(word)) {
                count++;
            }
        }
        return count;
    }

    //Repetitive Queries
    /*if we are doing this operation repeatedly, then we can probably afford to take some time and extra memory
    * to do pre-processing on the book. We can create a hash table which maps from a word to its frequency.
    * The frequency of any word can be easily looked up in O(1) time.*/

    HashMap<String, Integer> setupDirectory(String[] book) {
        HashMap<String, Integer> table = new HashMap<>();
        for (String word : book) {
            word = word.toLowerCase();
            if (word.trim() != "") {
                if (!table.containsKey(word)) {
                    table.put(word, 0);
                }
                table.put(word, table.get(word) + 1);
            }
        }
        return table;
    }

    int getFrequency(HashMap<String, Integer> table, String word) {
        if (table == null || word == null) return -1;
        word = word.toLowerCase();
        if (table.containsKey(word)) {
            return table.get(word);
        }
        return 0;
    }

}
