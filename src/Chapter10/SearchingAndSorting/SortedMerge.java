package Chapter10.SearchingAndSorting;

/**
 * Sorted Merge: You are given two sorted arrays, A and B, where A has a large enough buffer at the
 * end to hold B. Write a method to merge B into A in sorted order.
 */
public class SortedMerge {
    void merge(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1; /*Index of last element in array a */
        int indexB = lastB - 1; /*Index of last element in array b */
        int indexMerged = lastA + lastB - 1; /* end of merged array*/

        /*Merge a nad b, starting from the last element in each*/
        while (indexB >= 0) {
            //end of a is > than end of b
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA]; //copy element
                indexA--;
            } else {
                a[indexMerged] = b[indexB]; // copy element
                indexB--;
            }
            indexMerged--; // move indices
        }
    }

}
