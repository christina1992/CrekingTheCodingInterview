package Chapter8.RecursionAndDynamicProgramming;

import java.util.HashMap;

/**
 * Boolean Evaluation: Given a boolean expression consisting of the symbols 0 (false), 1 (true), &
 * (AND), I (OR), and A (XOR), and a desi red boolean result value result, implement a function to
 * count the number of ways of parenthesizing the expression such that it evaluates to result. The
 * expression should be fully parenthesized (e.g., (e) A (1» but not extraneously (e.g., ( ( (e» A (1) ».
 * EXAMPLE
 * countEval("1AalaI1", false) -> 2
 * countEval("a&a&a&1A1Ia", true) -> 1a
 */
public class BooleanEvaluation {
    int countEval(String s, boolean result) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return stringToBool(s) == result ? 1 : 0;
        int ways = 0;
        for (int i = 0; i < s.length(); i += 2) {
            char c = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i + 1, s.length());

            //Evaluate each side for each result
            int leftTrue = countEval(left, true);
            int leftFalse = countEval(left, false);
            int rightTrue = countEval(right, true);
            int rightFalse = countEval(right, false);
            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

            int totalTrue = 0;
            if (c == '^') {
                //required: one true and one false
                totalTrue = leftTrue * leftFalse + leftFalse * leftTrue;
            } else if (c == '&') { // required: both true
                totalTrue = leftTrue * rightFalse;
            } else if (c == '|') {
                //required: anything but both false
                totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
            }

            int subWays = result ? totalTrue : total - totalTrue;
            ways += subWays;
        }
        return ways;
    }

    private boolean stringToBool(String c) {
        return c.equals('1') ? true : false;
    }

    /*
        Solution more optimized
     */
    int countEval1(String s, boolean result, HashMap<String, Integer> memo) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return stringToBool(s) == result ? 1 : 0;
        if (memo.containsKey(result + s)) return memo.get(result + s);

        int ways = 0;

        for (int i = 0; i < s.length(); i += 2) {
            char c = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i + 1, s.length());
            int leftTrue = countEval1(left, true, memo);
            int leftFalse = countEval1(left, false, memo);
            int rightTrue = countEval1(right, true, memo);
            int rightFalse = countEval1(right, false, memo);
            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

            int totalTrue = 0;
            if (c == '^') {
                totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
            } else if (c == '&') {
                totalTrue = leftTrue * rightTrue;
            } else if (c == '|') {
                totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
            }

            int subWays = result ? totalTrue : total - totalTrue;
            ways += subWays;
        }
        memo.put(result + s, ways);
        return ways;
    }
}
