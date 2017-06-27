package Chapter4.TreesAndGraphs.very_important_tree_creation;

/**
 * O(log N) time in a balanced tree
 */
public class TreeNode2 {
    public TreeNode2 left;
    public TreeNode2 right;
    private int data;
    private int size = 0;

    public TreeNode2(int d) {
        data = d;
        size = 1;
    }

    public int size() {
        return size;
    }

    public int data() {
        return 0;
    }

    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                left = new TreeNode2(d);
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                right = new TreeNode2(d);
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public TreeNode2 getIthNode(int i) {
        int leftSize = left == null ? 0 : left.size();
        if (i < leftSize) {
            return left.getIthNode(i);
        } else if (i == leftSize) {
            return this;
        } else {
            // Skiping over leftSize + 1 nodes, so subtract them
            return right.getIthNode(i - (leftSize + 1));
        }
    }


    public TreeNode2 find(int d) {
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
