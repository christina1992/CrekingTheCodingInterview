package GraphsAndTreesBasic;

/**
 * Created by hnastevska on 6/12/2017.
 * Степен на дрво е максималниот број на деца на
 * јазлите
 */
public class StepenNaDrvo {

    static int getMaxChildrenCount(TreeNode node) {
        if (node == null) return 0;
        int count = 0;
        if (node.getChildren() != null) {
            int len = node.getChildren().size();
            if (count < len) {
                count = len;
            }
            for (int i = 0; i < node.getChildren().size(); i++) {
                getMaxChildrenCount((TreeNode) node.getChildren().get(i));
            }

        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.addChild(4);
        root.addChild(5);
        TreeNode<Integer> level1 = new TreeNode<>(2);
        level1.addChild(6);
        level1.addChild(7);
        level1.addChild(8);
        TreeNode<Integer> level2 = new TreeNode<>(3);
        level2.addChild(9);
        level2.addChild(10);

        root.addChild(level1);
        level1.addChild(level2);
        System.out.println(getMaxChildrenCount(root));
    }
}
