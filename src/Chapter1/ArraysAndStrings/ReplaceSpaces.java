package Chapter1.ArraysAndStrings;

import java.util.Arrays;

/**
 * URLify: Write a method to replace all spaces in a string with '%20: You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 */
public class ReplaceSpaces {

    /*
        This method uses an other array to return the desired output
        - takes more space
        - complexity O(n)
     */

    public static char[] replaceSpaces(String str, int len) {
        char[] strArray = str.toCharArray();
        char[] arr = new char[str.length()];
        int j = 0;
        for (int i = 0; i < len; i++, j++) {
            if (strArray[i] == ' ') {
                arr[j] = '%';
                arr[j + 1] = '2';
                arr[j + 2] = '0';
                j += 2;
            } else {
                arr[j] = strArray[i];
            }
        }
        return arr;
    }

    /*
      The method from the book
      Complexity O(n)
     */

    public static void replaceSpaces1(String s, int trueLength) {
        char[] str = s.toCharArray();
        int spaceCount = 0;
        int index = 0;
        int i = 0;
        for (int j = 0; j < trueLength; j++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length) str[trueLength] = '\0'; // End Array
        for (int j = trueLength - 1; j >= 0; j--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static void main(String[] args) {
        String str1 = "Mr John Smith    ";
        System.out.println(Arrays.toString(replaceSpaces(str1, 13)));
    }
}
