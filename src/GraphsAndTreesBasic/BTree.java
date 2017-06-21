package GraphsAndTreesBasic;

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
        ArrayStack<BNode<E>> s = new ArrayStack<>(100);
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
        ArrayStack<BNode<E>> s = new ArrayStack<>(100);
        BNode<E> p = root;
        System.out.println("PREORDER (nonrecursive): ");

        while (true) {
            while (p != null) {
                s.push(p);
                System.out.println(p.info.toString() + " ");
                p = p.left;
            }
            if (s.isEmpty()) break;

            p = s.peek();

            s.pop();
            p = p.right;
        }
        System.out.println();
    }

    public void iterativePostOrder(BNode<E> root) {
        ArrayStack<BNode<E>> s = new ArrayStack<>(100);
        BNode<E> p = root;

        while (true) {
            if (p != null) {
                if (p.right != null)
                    s.push(p.right);
                s.push(p);
                p = p.left;
                continue;
            }

            if (s.isEmpty())
                return;
            p = s.pop();

            if (p.right != null && !s.isEmpty() && p.right == s.peek()) {
                s.pop();
                s.push(p);
                p = p.right;
            } else {
                System.out.print(p.info.toString() + " ");
                p = null;
            }
        }
    }

    public int nodesInside(BNode<E> node) {
        BNode<E> p = node;
        int c = 0;
        if (node == null) return 0;
        if (node.left != null || node.right != null) {
            c++;
            c += nodesInside(node.left);
            c += nodesInside(node.right);
        }
        return c;
    }

    public int counterInsideNodes(BNode<E> node) {
        int c;
        c = nodesInside(node);
        return c - 1;
    }

    public int countChildren() {
        return children(root);
    }

    public int children(BNode<E> node) {
        int c = 0;
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            c++;
        }
        c += children(node.left);
        c += children(node.right);
        return c;

    }

    public int treeDepth() {
        return depth(root) - 1;
    }

    private int depth(BNode<E> root) {
        int l = 0;
        int r = 0;
        if (root == null) return 0;
        l++;
        r++;
        l += depth(root.left);
        r += depth(root.right);
        if (l > r) return l;
        return r;


    }

    public void mirror(BNode<E> node) {
        if (node == null) return;

        mirror(node.left);
        mirror(node.right);
        BNode<E> tmp = node.left;
        node.left = node.right;
        node.right = tmp;

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
