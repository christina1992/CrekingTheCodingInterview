package Chapter16_Moderate;

import java.util.Arrays;

/**
 * Created by hnastevska on 7/18/2017.
 */
public class SmallestDifference {
    //Brute Force
    int findSmallestDiffference(int[] array1, int[] array2) {
        if (array1.length == 0 || array2.length == 0) return -1;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (Math.abs(array1[i] - array2[j]) < min) {
                    min = Math.abs(array1[i] - array2[j]);
                }
            }
        }
        return min;
    }

    // Better solution O(A log A + B log B).

    int findSmallestDifference(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int a = 0;
        int b = 0;
        int difference = Integer.MAX_VALUE;
        while (a < array1.length && b < array2.length) {
            if (Math.abs(array1[a] - array2[b]) < difference) {
                difference = Math.abs(array1[a] - array2[b]);
            }
            //Move smaller value
            if (array1[a] < array2[b]) {
                a++;
            } else {
                b++;
            }
        }
        return difference;
    }
}
