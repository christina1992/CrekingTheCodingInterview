package Chapter1.ArraysAndStrings;

import java.util.Arrays;

/**
 * Given two strings write a method to decide if one is permutation of the other
 * Complexity O(n)
 */
public class PermutationOfString {
    /*
        If one string is a permutation of the other then they contain the same
        characters but in different order, therefor the sum of their ascii codes would
        be the same.
        Complexity of this method is O(n) n-being the length of the string
     */

    public static boolean isPrmutation(String str1, String str2) {
        str1 = str1.toLowerCase();// if the strings are not case sensitive, if they are then
        str2 = str2.toLowerCase();// these 2 lines are not needed
        if (str1.length() != str2.length()) return false;
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < str1.length(); i++) {
            sum1 += str1.charAt(i) - 'a';
            sum2 += str2.charAt(i) - 'a';
        }
        return sum1 == sum2;
    }

    /*
         Solution 2 for better cleanness of the code is to sort
         the strings and compare them.
         O(n log n) complexity
     */

    public static String sort(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static boolean isPermutation1(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        return sort(str1).equals(sort(str2));
    }


    /*
        Counting the appearances of the characters
        Permutation - two words with the same character count
        Complexity O(n)
     */

    public static boolean isPermutation2(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int[] letters = new int[128]; // if ASCII
        char[] str1Array = str1.toCharArray();
        for (char c : str1Array) {
            letters[c]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            int c = (int) str2.charAt(i);
            letters[c]--;
            if (letters[c] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String abc = "ABC";
        String bac = "BCA";
        System.out.println(isPermutation2(abc, bac));
    }
}
