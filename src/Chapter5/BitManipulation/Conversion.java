package Chapter5.BitManipulation;

/**
 * Created by hnastevska on 6/26/2017.
 */
public class Conversion {
    static int bitSwapRequired(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c >> 1) {
            count += c & 1;
        }
        return count;
    }

    int bitSwapRequired1(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c & (c - 1)) {
            count += c & 1;
        }
        return count;
    }
}
