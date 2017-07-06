package Chapter8.RecursionAndDynamicProgramming;

/**
 * Created by hnastevska on 6/29/2017.
 */
public class Fibonacci {

    //Without optimization it takes O(2^n) runtime
    static int fibonacci(int i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    /*With dynamic programming using memoization it takes O(n)
    * We simply cache the results of fibonacci(i) between calls.
    * TOP-DOWN DYNAMIC PROGRAMMING*/

    static int fibonacci1(int n) {
        return fibonacci1(n, new int[n + 1]);
    }

    static int fibonacci1(int i, int[] memo) {
        if (i == 0 || i == 1) return i;

        if (memo[i] == 0) {
            memo[i] = fibonacci1(i - 1, memo) + fibonacci1(i - 2, memo);
        }
        return memo[i];
    }

    /*FIBONACCI WITH BOTTOM-UP DYNAMIC PROGRAMMING */
    static int fibonacci2(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;

        int[] memo = new int[n];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n - 1] + memo[n - 2];
    }

    static int fibonacci3(int n) {
        if (n == 0) return 0;
        int a = 0;
        int b = 1;
        for (int i = 2; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a + b;
    }

    public static void main(String[] args) {
        //System.out.println(fibonacci(45));
        System.out.println(fibonacci1(45));
    }
}
