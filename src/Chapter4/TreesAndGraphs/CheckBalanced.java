package Chapter4.TreesAndGraphs;

import GraphsAndTreesBasic.finki_stuff.binarysearchtree.BNode;

/**
 * Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
 * this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
 * node never differ by more than one.
 */
public class CheckBalanced {
    int getHight(BNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHight(root.left), getHight(root.right)) + 1;
    }

    boolean isBalanced(BNode root) {
        if (root == null) return true;

        int heightDiff = getHight(root.left) - getHight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    /*
        Better implementation O(N) time O(H) space h=height of the tree
     */
    int checkHeight(BNode root) {
        if (root == null) return -1;
        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    boolean isBalanced1(BNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

}
