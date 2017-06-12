package GraphsAndTreesBasic;

/**
 * Created by hnastevska on 6/12/2017.
 */
public class PrintTree {
    static void printTreeRecursive(TreeNode<Integer> node, int level) {
        if (node.getChildren() == null) {
            return;
        }
        for (int i = 0; i < level; i++) System.out.print(" ");

        System.out.println(node.getData());
        for (TreeNode<Integer> n : node.getChildren()) {
            printTreeRecursive(n, level + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.addChild(4);
        root.addChild(5);
        TreeNode<Integer> level1 = new TreeNode<>(2);
        level1.addChild(6);
        level1.addChild(7);
        TreeNode<Integer> level2 = new TreeNode<>(3);
        level2.addChild(8);
        level2.addChild(9);

        root.addChild(level1);
        level1.addChild(level2);
        printTreeRecursive(root, 2);
    }
}
