package Chapter4.TreesAndGraphs;

import GraphsAndTreesBasic.finki_stuff.binarysearchtree.BNode;

/**
 * First Common Ancestor: Design an algorithm and write code to find the first common ancestor
 * of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
 * necessarily a binary search tree.
 */
public class FirstCommonAncestor1 {
    BNode commonAncestor(BNode root, BNode p, BNode q) {
        //Check if either node is not in the tree or if one covers the other
        if (!covers(root, p) || covers(root, q)) {
            return null;
        } else if (covers(p, q)) {
            return p;
        } else if (covers(q, p)) {
            return q;
        }

        BNode sibling = getSibling(p);
        BNode parent = p.parent;
        while (!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    private BNode getSibling(BNode node) {
        if (node == null || node.parent == null) {
            return null;
        }
        BNode parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
    }

    private boolean covers(BNode root, BNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }
}
