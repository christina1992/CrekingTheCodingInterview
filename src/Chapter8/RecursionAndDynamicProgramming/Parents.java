package Chapter8.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Parens: Implement an algorithm to print all valid (Le., properly opened and closed) combinations
 * of n pairs of parentheses.
 * EXAMPLE
 * Input: 3
 * Output: (( () ) ) , ((() ()),((() () , () ( () ) , () () ()
 */
public class Parents {

    Set<String> generateParents(int remaining) {
        Set<String> set = new HashSet<>();
        if (remaining == 0) {
            set.add("");
        } else {
            Set<String> prev = generateParents(remaining - 1);
            for (String str : prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = isertInside(str, i);
                            /*Add s to set if it's not already in there. Node: HashSet
                             * automatically checks for duplicates before adding, so an explicit
                              * check is not necessary. */
                        set.add(s);
                    }
                }
            }
        }
        return set;
    }

    private String isertInside(String str, int leftIndex) {
        String left = str.substring(0, leftIndex + 1);
        String right = str.substring(leftIndex + 1, str.length());
        return left + "()" + right;
    }

    /*
        More efficient solution
     */
    void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
        if (leftRem < 0 || rightRem < leftRem) return; // invalid state

        if (leftRem == 0 && rightRem == 0) { // Out of left and right parentheses
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '('; //Add left and recurse
            addParen(list, leftRem - 1, rightRem, str, index + 1);
            str[index] = ')'; // Add right and recurse
            addParen(list, leftRem, rightRem - 1, str, index + 1);
        }
    }

    ArrayList<String> generateParens(int count) {
        char[] str = new char[count * 2];
        ArrayList<String> list = new ArrayList<>();
        addParen(list, count, count, str, 0);
        return list;
    }
}
