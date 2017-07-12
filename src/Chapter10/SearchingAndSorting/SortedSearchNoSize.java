package Chapter10.SearchingAndSorting;

/**
 * Sorted Search, No Size: You are given an array-like data structure Listy which lacks a size
 * method. It does, however, have an e lementAt (i) method that returns the element at index i in
 * 0(1) time. If i is beyond the bounds of the data structure, it returns - 1. (For this reason, the data
 * structure only supports positive integers.) Given a Listy which contains sorted, positive integers,
 * find the index at which an element x occurs. If x occurs multiple times, you may return any index.
 */
public class SortedSearchNoSize {
    int serach(Listy list, int value) {
        int index = 1;
        while (list.elementAt(index) != -1 && list.elementAt(index) < value) {
            index *= 2;
        }
        return binarySerach(list, value, index / 2, index);
    }

    private int binarySerach(Listy list, int value, int low, int high) {
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            int middle = list.elementAt(mid);
            if (middle > value || middle == -1) {
                high = mid - 1;
            } else if (middle < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private class Listy {
        public int elementAt(int index) {
            return 1;
        }
    }
}
