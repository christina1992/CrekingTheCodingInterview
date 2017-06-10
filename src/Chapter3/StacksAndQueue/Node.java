package Chapter3.StacksAndQueue;

/**
 * Created by Christina on 08-Jun-17.
 */
public class Node {
    Node above;
    Node below;
    int value;

    public Node(int value) {
        this.value = value;
    }

    public Node(Node above, Node below, int value) {
        this.above = above;
        this.below = below;
        this.value = value;
    }
}
