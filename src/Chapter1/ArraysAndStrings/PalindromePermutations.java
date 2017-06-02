package Chapter1.ArraysAndStrings;

import java.util.HashMap;

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. A permutation
 * is a rea rrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat". "atco cta". etc.)
 * Complexity O(n)
 */
public class PalindromePermutations {
    /*
     Pretty straight forward solution using HashMap
     Complexity O(n) n being the length of the word
     */

    public static boolean checkPalindromePermutation(String str) {
        str = str.replace(" ", "");
        HashMap<Character, Integer> counts = new HashMap<>();
        char[] chars = str.toCharArray();
        int odd = 0;
        for (char c : chars) {
            if (counts.get(c) != null) {
                int appearance = counts.get(c);
                counts.put(c, appearance + 1);
            } else {
                counts.put(c, 1);
            }
        }
        for (char key : counts.keySet()) {
            int num = counts.get(key);
            if (num % 2 != 0) {
                odd++;
            }
        }
        if (odd == 1 || odd == 0) return true;
        return false;
    }

    /*
      An other solution that checks odd count right away
     */
    public static boolean isPermutationOfPalindrome(String str) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : str.toCharArray()) {
            int x = Character.getNumericValue(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }


    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindrome("nooo mom"));
    }

}
