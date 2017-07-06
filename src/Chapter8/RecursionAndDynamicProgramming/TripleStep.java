package Chapter8.RecursionAndDynamicProgramming;

import java.util.Arrays;

/**
 * Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
 * steps at a time. Implement a method to count how many possible ways the child can run up the
 * stairs.
 */
public class TripleStep {
    /*
        A simple implementation of this code would be
        Runtime (roughly(O(3^n))
     */
    static int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }
    
    /*
        Memoization Solution
        If we've seen this value of n before, return the cached value. 
        Each time we compute a fresh value, add it to the cache
        Typically we use HashMap<Integer,Integer> for a cache. in this
        case, the keys will be exactly 1 through n. It's more compact to
        use an integer array.
     */

    static int countWays1(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo,-1);
        return countWays(n,memo);
    }

    private static int countWays(int n, int[] memo) {
        if (n < 0){
            return 0;
        }else if (n == 0){
            return 1;
        }else if (memo[n] > -1){
            return memo[n];
        }else {
            memo[n] = countWays(n-1,memo) + countWays(n-2,memo)+countWays(n-3, memo);
        }
        return memo[n];
    }
}
