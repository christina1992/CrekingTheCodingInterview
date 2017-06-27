package Chapter4.TreesAndGraphs.vezbi;


import java.util.Stack;

/**
 * Created by hnastevska on 6/13/2017.
 */
public class BTree<E> {
    public BNode<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E info) {
        root = new BNode<>(info);
    }

    public void inOrder() {
        System.out.println("INORDER: ");
        inorder(root);
        System.out.println();
    }

    public void inorder(BNode<E> n) {
        if (n != null) {
            inorder(n.left);
            System.out.println(n.info.toString() + " ");
            inorder(n.right);
        }
    }

    public void preOrder() {
        System.out.println("PREORDER: ");
        preorder(root);
        System.out.println(" ");

    }

    public void preorder(BNode<E> n) {
        if (n != null) {
            System.out.println(n.info.toString());
            preorder(n.left);
            preorder(n.right);
        }

    }

    public void postOrder() {
        System.out.println("POSTORDER: ");
        postorder(root);
        System.out.println(" ");
    }

    public void postorder(BNode<E> n) {
        if (n != null) {
            postorder(n.left);
            postorder(n.right);
            System.out.println(n.info.toString());
        }
    }

    public void iterativeInOrder(BNode<E> root) {
        Stack<BNode<E>> s = new Stack<>();
        BNode<E> p = root;
        System.out.println("INORDER (nonrecursive): ");

        while (true) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            if (s.isEmpty()) break;

            p = s.peek();
            System.out.println(p.info.toString() + " ");
            s.pop();
            p = p.right;
        }
        System.out.println();
    }

    public void iterativePreOrder(BNode<E> root) {
        Stack<BNode<E>> s = new Stack<>();
        BNode<E> p = root;
        System.out.println("PREORDER (nonrecursive): ");
        while (true) {
            p = s.peek();
            s.pop();
            System.out.println(p.info.toString() + " ");
            while (p != null) {
                s.push(p);
                p = p.right;
            }
            if (s.isEmpty()) break;


            p = p.left;
        }
        System.out.println();
    }


    public void iterativePostOrder(BNode<E> root) {

    }

    public void makeRoot(E elem) {
        root = new BNode<>(elem);
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {
        BNode<E> tmp = new BNode<>(elem);

        if (where == BNode.LEFT) {
            if (node.left != null) return null; // if already exists element in that position
            node.left = tmp;
        } else {
            if (node.right != null) return null;
            node.right = tmp;
        }
        return tmp;
    }
}
