package Chapter10.SearchingAndSorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Group Anagrams: Write a method to sort an array of strings so that all the anagrams are next to
 * each other.
 */
public class GroupAnagrams {
    void sort(String[] array) {
        HashMap<String, String> mapList = new HashMap<>();

        //Group words by anagram
        for (String s : array) {
            String key = sortChars(s);
            mapList.put(key, s);
        }
        //Convert hash table to array
        int index = 0;
        for (String key : mapList.keySet()) {
//            String list = mapList.get(key);
//            for (String t : list) {
//                array[index] = t;
//                index++;
//            }
        }
    }

    private String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    class AnaramComparator implements Comparator<String> {
        public String sortChars(String s) {
            char[] content = s.toCharArray();
            Arrays.sort(content);
            return new String(content);
        }

        public int compare(String s1, String s2) {
            return sortChars(s1).compareTo(s2);
        }
    }

}
