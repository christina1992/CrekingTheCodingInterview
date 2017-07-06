package Chapter8.RecursionAndDynamicProgramming;

import java.util.ArrayList;

/**
 * Permutations without Dups: Write a method to compute all permutations of a string of unique
 * characters.
 */
public class PermutationsWithoutDups {
    ArrayList<String> getPerms(String str) {
        if (str == null) return null;
        ArrayList<String> permutations = new ArrayList<>();
        if (str.length() == 0) { // base case
            permutations.add("");
            return permutations;
        }
        char first = str.charAt(0); // get the first char
        String remainder = str.substring(1); // remove the first char
        ArrayList<String> words = getPerms(remainder);
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String s = insertCharAt(word, first, i);
                permutations.add(s);
            }
        }
        return permutations;
    }

    //Insert char c at index i in word.
    private String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    /*
         An other solution
     */
    ArrayList<String> getPerms1(String remainder) {
        int len = remainder.length();
        ArrayList<String> result = new ArrayList<>();

        //Base case
        if (len == 0) {
            result.add("");
            return result;
        }
        for (int i = 0; i < len; i++) {
            //Remove char i and find permutations of remaining chars.
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1, len);
            ArrayList<String> partials = getPerms1(before + after);

            /*Prepend char i to each permutation */
            for (String s : partials) {
                result.add(remainder.charAt(i) + s);
            }
        }
        return result;
    }

    /* Alternatively, instead of passing the permutations back up the stack, we can push the prefix down the stack.
        When we get to the bottom (base case), prefix holds a full permutation.*/
    ArrayList<String> getPerms2(String str) {
        ArrayList<String> result = new ArrayList<>();
        getPerms2("", str, result);
        return result;
    }

    private void getPerms2(String prefix, String remainder, ArrayList<String> result) {
        if (remainder.length() == 0) result.add(prefix);

        int len = remainder.length();
        for (int i = 0; i < len; i++) {
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1, len);
            char c = remainder.charAt(i);
            getPerms2(prefix + c, before + after, result);

        }
    }
}

