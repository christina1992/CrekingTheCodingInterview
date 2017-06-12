package GraphsAndTreesBasic.finki_stuff;

import java.util.Iterator;

public interface Tree<E> {
    // //////////Accessors ////////////
    Node<E> root();

    Node<E> parent(Node<E> node);

    int childCount(Node<E> node);

    // //////////Transformers ////////////
    void makeRoot(E elem);

    Node<E> addChild(Node<E> node, E elem);

    void remove(Node<E> node);

    // //////////Iterator ////////////
    Iterator<E> children(Node<E> node);

    // //////Inner interface for tree nodes ////////
    interface Node<E> {

        E getElement();
        void setElement(E elem);

    }
}
