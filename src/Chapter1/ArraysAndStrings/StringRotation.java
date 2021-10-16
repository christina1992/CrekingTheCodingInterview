package Chapter1.ArraysAndStrings;

import java.util.Scanner;

/**
 * String Rotation: Assume you have a method i5Substring which checks if one word is a substring
 * of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
 * call to isSubstring (e.g., Uwaterbottleuis a rotation ofuerbottlewatU ).
 */
public class StringRotation {

    private static boolean isSubstring(String word1, String word2) {
        int sumWord1 = 0;
        int sumWord2 = 0;
        for (int i = 0; i < word1.length(); i++) {
            sumWord1 += word1.charAt(i) - 'a';
        }
        for (int i = 0; i < word2.length(); i++) {
            sumWord2 += word2.charAt(i) - 'a';
        }
        return sumWord1 - sumWord2 > 0 || sumWord1 - sumWord2 == 0;
    }

    public static boolean isRotation(String str1, String str2) {
        if (str1.length() == str2.length() && str1.length() > 0) {
            String str1str1 = str1 + str2;
            return isSubstring(str1str1, str2);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long sum;
        long p;
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            p = (n - 1) / 3;
            sum = ((3 * p * (p + 1)) / 2);
            p = (n - 1) / 5;
            sum = sum + ((5 * p * (p + 1)) / 2);

            p = (n - 1) / 15;
            sum = sum - ((15 * p * (p + 1)) / 2);

            System.out.println(sum);

        }
    }
}
