package Chapter4.TreesAndGraphs;

import GraphsAndTreesBasic.finki_stuff.binarysearchtree.BNode;

/**
 * Validate 8ST: Implement a function to check if a binary tree is a binary search tree.
 */
public class ValidateBST {
    Integer last_printed = null;

    boolean checkBST(BNode n) {
        if (n == null) return true;
        //Check / recurse left
        if (!checkBST(n.left)) return false;

        //Check current
        if (last_printed != null && (Integer) n.info <= last_printed) {
            return false;
        }
        last_printed = (Integer) n.info;

        //Check / recurse right
        if (!checkBST(n.right)) return false;

        return true; //All good!
    }

    /*
        A better way
     */
    boolean checkBST1(BNode n) {
        return checkBST(n, null, null);
    }

    private boolean checkBST(BNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if ((min != null && (Integer) n.info <= min) || (max != null && (Integer) n.info > max)) {
            return false;
        }
        if (!checkBST(n.left, min, (Integer) n.info) || !checkBST(n.right, (Integer) n.info, max)) {
            return false;
        }
        return true;
    }
}
