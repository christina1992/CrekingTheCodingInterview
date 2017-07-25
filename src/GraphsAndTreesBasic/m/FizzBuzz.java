package GraphsAndTreesBasic.m;

import java.util.Arrays;

/**
 * Created by hnastevska on 7/21/2017.
 */
public class FizzBuzz {
/*    static String[] printNumbers() {
        String[] s = new String[101];
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                s[i] = "FizzBuzz" ;
                continue;
            }
            if (i % 3 == 0) {
                s[i] = "Fizz" ;
            } else if (i % 5 == 0) {
                s[i] = "Buzz" ;
            } else {
                s[i] = String.valueOf(i);
            }

        }
        String[] s1 = Arrays.copyOfRange(s, 1, s.length);
        return s1;
    }*/

    static String[] fizzbuzz() {
        String[] res = new String[101];
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res[i] = "FizzBuzz" ;
            } else if (i % 3 == 0) {
                res[i] = "Fizz" ;
            } else if (i % 5 == 0) {
                res[i] = "Buzz" ;
            } else {
                res[i] = String.valueOf(i);
            }
        }
        String[] s1 = Arrays.copyOfRange(res, 1, res.length);

        return s1;
    }

    public static void main(String[] args) {
        String[] result = fizzbuzz();
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
