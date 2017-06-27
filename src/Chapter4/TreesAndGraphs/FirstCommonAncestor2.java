package Chapter4.TreesAndGraphs;

import GraphsAndTreesBasic.finki_stuff.binarysearchtree.BNode;

/**
 * Created by hnastevska on 6/22/2017.
 */
public class FirstCommonAncestor2 {
    BNode commonAncestors(BNode root, BNode p, BNode q) {
        //error check - one node is not in the tree
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        }
        return ancestorHelper(root, p, q);
    }

    private BNode ancestorHelper(BNode root, BNode p, BNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        boolean plsOnLeft = covers(root.left, p);
        boolean qlsOnLeft = covers(root.left, q);
        if (plsOnLeft != qlsOnLeft) {
            return root;
        }
        BNode childSide = plsOnLeft ? root.left : root.right;
        return ancestorHelper(childSide, p, q);
    }

    private boolean covers(BNode root, BNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }
}
