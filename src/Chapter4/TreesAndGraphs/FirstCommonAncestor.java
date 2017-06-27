package Chapter4.TreesAndGraphs;

import GraphsAndTreesBasic.finki_stuff.binarysearchtree.BNode;

/**
 * First Common Ancestor: Design an algorithm and write code to find the first common ancestor
 * of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
 * necessarily a binary search tree.
 */
public class FirstCommonAncestor {
    BNode commonAncestor(BNode p, BNode q) {
        int delta = depth(p) - depth(q);
        BNode first = delta > 0 ? q : p;
        BNode second = delta > 0 ? p : q;
        second = goUpBy(second, Math.abs(delta));

        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }
        return first == null || second == null ? null : first;
    }

    private BNode goUpBy(BNode node, int delta) {
        while (delta > 0 && node != null) {
            node = node.parent;
            delta--;
        }
        return node;
    }

    private int depth(BNode p) {
        int depth = 0;
        while (p != null) {
            p = p.parent;
            depth++;
        }
        return depth;
    }
}
