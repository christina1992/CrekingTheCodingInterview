package Chapter10.SearchingAndSorting;

/**
 * Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown
 * number of times, write code to find an element in the array. You may assume that the array was
 * originally sorted in increasing order.
 * EXAMPLE
 * InputfindSin {15, 16, 19, 20, 25, 1, 3,4,5,7,10, 14}
 * Output 8 (the index of 5 in the array)
 */
public class SearchInRotatedArray {

    int search(int a[], int left, int right, int x) {
        int mid = (left + right) / 2;
        if (x == a[mid]) {// Found element
            return mid;
        }
        if (right < left) {
            return -1;
        }
        /*Either the left or right half must be normally ordered. Find out which side
        * is normally ordered, and then use the normally ordered half to figure out
        * which side to search to find x.*/
        if (a[left] < a[mid]) { // Left is normally ordered.
            if (x >= a[left] && x < a[mid]) {
                return search(a, left, mid - 1, x);// Search right
            } else {
                return search(a, left, mid - 1, x);// Search left
            }
        } else if (a[left] == a[mid]) { // Left or right half is all repeats
            if (a[mid] != a[right]) // if right is different, search it
            {
                return search(a, mid + 1, right, x);
            } else { // Else, we have to search both halves
                int result = search(a, left, mid - 1, x); // Search left
                if (result == -1) {
                    return search(a, mid + 1, right, x); // Search right
                } else {
                    return result;
                }
            }
        }
        return -1;
    }

}
