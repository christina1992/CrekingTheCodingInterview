package Chapter4.TreesAndGraphs;

import GraphsAndTreesBasic.finki_stuff.binarysearchtree.BNode;

/**
 * Created by hnastevska on 6/22/2017.
 */
public class CheckSubtreeOptimized {

    boolean containsTree(BNode t1, BNode t2) {
        if (t2 == null) return true; // The empty tree is always a subtree
        return subTree(t1, t2);
    }

    private boolean subTree(BNode t1, BNode t2) {
        if (t1 == null) {
            return false; // big tree empty and subtree still not found
        } else if (t1.info == t2.info && matchTree(t1, t2)) {
            return true;
        }
        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }

    private boolean matchTree(BNode t1, BNode t2) {
        if (t1 == null && t2 == null) {
            return true; // nothing left in the subtree
        } else if (t1 == null || t2 == null) {
            return false;//exactly tree is empty, therefore trees don't match
        } else if (t1.info != t2.info) {
            return false; // data doesn't match
        } else {
            return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
        }
    }

}
