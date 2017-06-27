package Chapter4.TreesAndGraphs.vezbi;

import GraphsAndTreesBasic.*;

/**
 * Created by hnastevska on 6/25/2017.
 */
public class MinimalBST {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    }
    static BNode createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    static BNode<Integer> createMinimalBST(int[] array, int start, int end) {
        if (end < start) return null;
        int mid = (start + end) / 2;
        BNode<Integer> n = new BNode<>(array[mid]);
        n.left = createMinimalBST(array, start, mid - 1);
        n.right = createMinimalBST(array, mid + 1, end);
        return n;
    }

}
