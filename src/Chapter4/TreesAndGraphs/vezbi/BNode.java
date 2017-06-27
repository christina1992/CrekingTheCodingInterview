package Chapter4.TreesAndGraphs.vezbi;

/**
 * Created by hnastevska on 6/13/2017.
 */
public class BNode<E> {
    static int LEFT = 1;
    static int RIGHT = 2;
    public E info;
    public BNode<E> left;
    public BNode<E> right;

    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
    }

    public BNode(E info, BNode<E> left, BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

}
