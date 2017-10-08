package Excercise;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hnastevska on 10/7/2017.
 */
public class StringManipulation {

    public static boolean isUnique(String str) {
        Set<Character> unique = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            unique.add(str.charAt(i));
        }
        if (unique.size() == str.length()) {
            return true;
        }
        return false;
    }

    public static boolean checkPermutation(String str1, String str2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < str1.length(); i++) {
            sum1 += str1.charAt(i) - 'a';
        }
        for (int i = 0; i < str2.length(); i++) {
            sum2 += str2.charAt(i) - 'a';
        }
        if (sum1 == sum2) return true;
        return false;
    }

    public static void main(String[] args) {
        String hristina = "hRistina#";
        String smthing = "smtHing#";
        System.out.println(isUnique(hristina));
        System.out.println(isUnique(smthing));

        System.out.println(checkPermutation("kikiriki","rikikiki"));

    }
}
