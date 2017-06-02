package Chapter1.ArraysAndStrings;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * Complexity O(n)
 */
public class StringEditing {

    private static boolean checkEdit(String word1, String word2) {
        if (word1.length() == word2.length()) {
            return oneEditReplace(word1, word2);
        } else if (word1.length() + 1 == word2.length()) {
            return oneEditInsert(word1, word2);
        } else if (word1.length() - 1 == word2.length()) {
            return oneEditInsert(word2, word1);
        }
        return false;
    }

    private static boolean oneEditInsert(String word1, String word2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 > word2.length() && index1 > word1.length()) {
            if (word1.charAt(index1) != word2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    private static boolean oneEditReplace(String word1, String word2) {
        boolean foundDifferece = false;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (foundDifferece) return false;
                foundDifferece = true;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(checkEdit("pale", "ple"));

    }
}
