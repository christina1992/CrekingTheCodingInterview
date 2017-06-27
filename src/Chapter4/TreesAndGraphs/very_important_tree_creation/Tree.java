package Chapter4.TreesAndGraphs.very_important_tree_creation;

import java.util.Random;

/**
 * Created by hnastevska on 6/22/2017.
 */
public class Tree {
    TreeNode2 root = null;

    public int size() {
        return root == null ? 0 : root.size();
    }

    public TreeNode2 getRandomNode() {
        if (root == null) return null;

        Random random = new Random();
        int i = random.nextInt(size());
        return root.getIthNode(i);
    }

    public void insertInOrder(int value) {
        if (root == null) {
            root = new TreeNode2(value);
        } else {
            root.insertInOrder(value);
        }
    }
}
