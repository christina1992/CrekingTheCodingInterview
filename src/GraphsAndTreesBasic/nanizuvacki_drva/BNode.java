package GraphsAndTreesBasic.nanizuvacki_drva;


public class BNode<E> {

    public E info;
    public BNode<E> left;
    public BNode<E> right;
    public char ltag;
    public char rtag;

    public static int LEFT = 1;
    public static int RIGHT = 2;

    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
        ltag = '-';
        rtag = '-';
    }

}
