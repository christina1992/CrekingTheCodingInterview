package GraphsAndTreesBasic;

/**
 * Created by hnastevska on 6/13/2017.
 */
public class BinaryTreeTraverse {

    public static void main(String[] args) {
        BNode<Character> a, b, c,e;
        BTree<Character> tree = new BTree<>('F');
        a = tree.addChild(tree.root, BNode.LEFT, 'D');
        b = tree.addChild(a, BNode.LEFT, 'B');
        c = tree.addChild(b, BNode.LEFT, 'A');
        c = tree.addChild(b, BNode.RIGHT, 'C');
        c = tree.addChild(a, BNode.RIGHT, 'E');
        a = tree.addChild(tree.root, BNode.RIGHT, 'G');
        b = tree.addChild(a, BNode.RIGHT, 'I');
        c = tree.addChild(b, BNode.LEFT, 'H');
        c = tree.addChild(b, BNode.RIGHT, 'J');
        e = tree.addChild(c, BNode.RIGHT, 'P');

       // tree.inOrder();
        tree.iterativePreOrder(tree.root);
       // tree.preOrder();
       // tree.postOrder();
        tree.inOrder();
//        tree.mirror(tree.root);
//        tree.inOrder();
     //   System.out.println(tree.treeDepth());
//        tree.preOrder();
     //   tree.postOrder();


    }
}
