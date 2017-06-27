package Chapter5.BitManipulation;

/**
 * Created by hnastevska on 6/26/2017.
 */
public class FlipBit {
    static int flipBit(int a) {
        //if all is already the longest sequence
        if (~a == 0) return Integer.BYTES * 8;

        int currentLength = 0;
        int previousLength = 0;
        int maxLenth = 1; // we can always have a sequence of at least one 1
        while (a != 0) {
            if ((a & 1) == 1) { //current bit is 1
                currentLength++;
            } else if ((a & 1) == 0) { // current bit is 0
                //Update to 0 (if next bit is 0) or currentLength (if next bit is 1)
                previousLength = (a & 2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }
            maxLenth = Math.max(previousLength + currentLength + 1, maxLenth);
            a >>>= 1;
        }
        return maxLenth;
    }

    public static void main(String[] args) {

    }
}
