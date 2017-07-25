package Chapter2.LinkedLists;

/**
 * Created by Christina on 03-Jun-17.
 */
public class SLLNode<E> {
    public E element;
    public SLLNode<E> succ;
    public SLLNode<E> prev;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
