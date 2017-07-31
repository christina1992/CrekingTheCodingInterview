package Hackerrank_CTCI_;


/**
 * Created by hnastevska on 7/26/2017.
 */
public class CheckBST {
    public static void main(String[] args) {

    }

    boolean checkBST(Node root) {
            return checkBST(root, null, null);
    }
    private boolean checkBST(Node n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }

        if ((min != null &&  n.data <= min) || (max != null &&  n.data >= max)) {
            return false;
        }
        if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
            return false;
        }
        return true;
    }


    class Node {
        int data;
        Node left;
        Node right;
    }
}
