package Chapter1.ArraysAndStrings;

/**
 * String Rotation: Assume you have a method i5Substring which checks ifone word is a substring
 * of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
 * call to isSubstring (e.g., Uwaterbottleuis a rotation ofuerbottlewatU ).
 */
public class StringRotation {

    public static boolean isSubstring(String word1, String word2) {
        int sumWord1 = 0;
        int sumWord2 = 0;
        for (int i = 0; i < word1.length(); i++) {
            sumWord1 += word1.charAt(i) - 'a';
        }
        for (int i = 0; i < word2.length(); i++) {
            sumWord2 += word2.charAt(i) - 'a';
        }
        if (sumWord1 - sumWord2 > 0 || sumWord1 - sumWord2 == 0) return true;
        return false;
    }

    public static boolean isRotation(String str1, String str2) {
        if (str1.length() == str2.length() && str1.length() > 0) {
            String str1str1 = str1 + str2;
            return isSubstring(str1str1, str2);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }
}
