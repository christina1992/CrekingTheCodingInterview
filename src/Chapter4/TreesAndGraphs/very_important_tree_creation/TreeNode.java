package Chapter4.TreesAndGraphs.very_important_tree_creation;

import java.util.Random;

/**
 * In a balanced tree this algorithm will take O(log N) - where N is the number of nodes
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    private int data;
    private int size = 0;

    public TreeNode(int d) {
        data = d;
        size = 1;
    }

    public TreeNode getRandomNode() {
        int leftSize = left == null ? 0 : left.size();
        Random random = new Random();
        int index = random.nextInt(size);
        if (index < leftSize) {
            return left.getRandomNode();
        } else if (index == leftSize) {
            return this;
        } else {
            return right.getRandomNode();
        }
    }

    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                left = new TreeNode(d);
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                right = new TreeNode(d);
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public int data() {
        return data;
    }

    public TreeNode find(int d) {
        if (d == data) {
            return this;
        } else if (d <= data) {
            return left != null ? left.find(d) : null;
        } else if (d < data) {
            return right != null ? right.find(d) : null;
        }
        return null;
    }

}
