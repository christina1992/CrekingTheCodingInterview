package Chapter8.RecursionAndDynamicProgramming;

/**
 * Magic Index: A magic index in an array A [1. .. n -1] is defined to be an index such that A[ i]
 * i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
 * array A.
 * FOLLOW UP
 * What if the values are not distinct?
 */
public class MagicIndex {
    /*
        The brute force solution
     */
    int magicSlow(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i) {
                return i;
            }
        }
        return -1;
    }

    /*
      We continue to apply this recursive algorithm, developing code that looks very much like binary search.
     */
    int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    private int magicFast(int[] array, int end, int start) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return magicFast(array, start, mid - 1);
        } else {
            return magicFast(array, mid + 1, end);
        }}

        /*
            What if the elements were not distinct
         */

    int magicFast1(int[] array) {
        return magicFast1(array, 0, array.length - 1);
    }

    private int magicFast1(int[] array, int end, int start) {
        if (end < start) {
            return -1;
        }

        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];
        if (midIndex == midValue) {
            return midIndex;
        }

        /*Search left */
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicFast1(array, start, leftIndex);
        if (left >= 0) {
            return left;
        }

        //Search right
        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = magicFast1(array, rightIndex, end);
        return right;
    }
}


