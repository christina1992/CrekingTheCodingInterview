package Chapter10.SearchingAndSorting;

/**
 * Sorted Matrix Search: Given an M x N matrix in which each row and each column is sorted in
 * ascending order, write a method to find an element.
 */
public class SortedMatrixSearch {
    boolean findElement(int[][] matrix, int elem) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == elem) {
                return true;
            } else if (matrix[row][col] > elem) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
