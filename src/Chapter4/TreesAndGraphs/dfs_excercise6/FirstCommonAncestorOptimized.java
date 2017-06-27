package Chapter4.TreesAndGraphs.dfs_excercise6;

import GraphsAndTreesBasic.finki_stuff.binarysearchtree.BNode;

/**
 * Created by hnastevska on 6/22/2017.
 */
public class FirstCommonAncestorOptimized {
    BNode commonAncestor(BNode root, BNode p, BNode q) {
        Result r = commonAncestorHelper(root, p, q);
        if (r.isAncestor) {
            return r.node;
        }
        return null;
    }

    Result commonAncestorHelper(BNode root, BNode p, BNode q) {
        if (root == null) return new Result(null, false);

        if (root == p && root == q) {
            return new Result(root, true);
        }
        Result rx = commonAncestorHelper(root.left, p, q);
        if (rx.isAncestor) {
            return rx;
        }
        Result ry = commonAncestorHelper(root.right, p, q);
        if (ry.isAncestor) {
            return ry;
        }
        if (rx.node != null && ry.node != null) {
            return new Result(root, true);
        } else if (root == p || root == q) {
            boolean isAncestor = rx.node != null || ry.node != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(rx.node != null ? rx.node : ry.node, false);
        }

    }

    class Result {
        public BNode node;
        public boolean isAncestor;

        public Result(BNode node, boolean isAncestor) {
            this.node = node;
            this.isAncestor = isAncestor;
        }
    }
}
