package GraphsAndTreesBasic.finki_stuff;

/**
 * Created by hnastevska on 6/12/2017.
 */
// SLLNode is the implementation of the Node interface
class SLLNode<P> implements Tree.Node<P> {

    // Holds the links to the needed nodes
    SLLNode<P> parent, sibling, firstChild;

    // Hold the data
    P element;

    public SLLNode(P o) {
        element = o;
        parent = sibling = firstChild = null;
    }

    public P getElement() {
        return element;
    }

    public void setElement(P o) {
        element = o;
    }

}