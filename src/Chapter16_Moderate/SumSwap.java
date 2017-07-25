package Chapter16_Moderate;

import java.util.HashSet;

/**
 * Created by hnastevska on 7/25/2017.
 */
public class SumSwap {
    int[] findSwapValues(int[] array1, int[] array2) {
        Integer target = getTarget(array1, array2);
        if (target == null) return null;
        return findDifference(array1, array2, target);
    }

    //Find a pair of values with a specific difference.
    private int[] findDifference(int[] array1, int[] array2, Integer target) {
        HashSet<Integer> contents2 = getContents(array2);
        for (int one : array1) {
            int two = one - target;
            if (contents2.contains(two)) {
                int[] values = {one, two};
                return values;
            }
        }
        return null;
    }

    //Put contents of array into hash set.
    private HashSet<Integer> getContents(int[] array2) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : array2) {
            set.add(a);
        }
        return set;
    }

    private Integer getTarget(int[] array1, int[] array2) {
        int sum1 = sum(array1);
        int sum2 = sum(array2);

        if ((sum1 - sum2) % 2 != 0) return null;
        return (sum1 - sum2) / 2;
    }

    private int sum(int[] array1) {
        int sum = 0;
        for (int i = 0; i < array1.length; i++) {
            sum += array1[i];
        }
        return sum;
    }
}
