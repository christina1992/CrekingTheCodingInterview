package Chapter5.BitManipulation;

/**
 * Created by hnastevska on 6/26/2017.
 */
public class PairwiseSwap {
    int swapOddEvenBits(int x) {
        return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
    }
}
