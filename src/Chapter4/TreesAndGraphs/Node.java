package Chapter4.TreesAndGraphs;

/**
 * Created by hnastevska on 6/21/2017.
 */
public class Node {
    Node next;
    RouteBetweenNodes.State state;
    private Node[] adjacent;

    public Node(Node next, RouteBetweenNodes.State state) {
        this.next = next;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Node{" +
                "state='" + state + '\'' +
                ", next=" + next +
                '}';
    }

    public Node[] getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(Node[] adjacent) {
        this.adjacent = adjacent;
    }
}
