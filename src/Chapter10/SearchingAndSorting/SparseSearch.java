package Chapter10.SearchingAndSorting;

/**
 * Sparse Search: Given a sorted array of strings that is interspersed with empty strings, write a
 * method to find the location of a given string.
 * EXAMPLE
 * Input: ball, {"at","", "", "", "ball", tt" , u" , "car", (tJJ , (OJ , "dad", ""}
 * Output: 4
 */
public class SparseSearch {

    int serach(String[] strings, String str, int first, int last) {
        if (first > last) return -1;
        //move mid to the middle
        int mid = (last + first) / 2;

        //If mid is empty, find closest non-empty string.
        if (strings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < first && right > last) {
                    return -1;
                } else if (right <= last && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= first && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }
        //Check for string,and recurse if necessary
        if (str.equals(strings[mid])) { //Found it!
            return mid;
        } else if (strings[mid].compareTo(str) < 0) { // Search right
            return serach(strings, str, mid + 1, last);
        } else { // Search left
            return serach(strings, str, first, mid - 1);
        }
    }

    int search(String[] strings, String str) {
        if (strings == null || str == null || str == "") {
            return -1;
        }
        return serach(strings, str, 0, strings.length - 1);
    }
}
