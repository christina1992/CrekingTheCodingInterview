package Chapter1.ArraysAndStrings;

/**
 * -Implement an algorithm to determine if a string has all unique characters
 * What if you can not use additional data structures?
 * Complexity O(n)
 * https://www.quora.com/Could-someone-explain-how-this-code-dictates-if-the-string-has-all-unique-characters-or-not
 */
public class UniqueCharactersInString {

    public static boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); ++i) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val); //The code to set the slot for a letter to "1" when we come across the letter
        }
        return true;
    }

    /*
      We can also solve this problem by using boolean array, it will take a bit more space then the first method
       - Needs to be specified is the encoding ASCII or UNICODE because of the length of the array
     */

    public static boolean isUniqueChars2(String word) {
        if (word.length() > 128) return false;
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < word.length(); i++) {
            int val = word.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    /*
    If we are not allowed to use any additional data structures then the complexity of the solution would be O(n^2)
     */

    public static boolean isUniqueCharacter(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String hristina = "hRistina#";
        String smthing = "smtHing##";
        System.out.println(isUniqueChars(hristina));
        System.out.println(isUniqueChars(smthing));

    }
}
