package Chapter4.TreesAndGraphs;


import GraphsAndTreesBasic.BNode;

/**
 * Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an
 * algorithm to create a binary search tree with minimal height.
 */
public class MinimalTree {
    BNode createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    private BNode createMinimalBST(int[] arr, int start, int end) {
        if (end < start) return null;
        int mid = (start + end) / 2;
        BNode n = new BNode(arr[mid]);
        n.left = createMinimalBST(arr, start, mid - 1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }
}
