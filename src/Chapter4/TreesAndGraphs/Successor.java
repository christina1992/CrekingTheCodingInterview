package Chapter4.TreesAndGraphs;

import GraphsAndTreesBasic.finki_stuff.binarysearchtree.BNode;

/**
 * Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
 * binary search tree. You may assume that each node has a link to its parent.
 */
public class Successor {
    BNode inorderSucc(BNode n) {
        if (n == null) return null;

        /*Found right children -> return leftmost node of right subtree */
        BNode x;
        if (n.right != null) {
            return leftMostChild(n.right);
        } else {
            BNode q = n;
            x = q.parent;
            //Go up until we're on left instead of right
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
        }
        return x;
    }

    private BNode leftMostChild(BNode n) {
        if (n == null) {
            return null;
        }
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }
}
