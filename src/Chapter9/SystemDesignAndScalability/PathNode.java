package Chapter9.SystemDesignAndScalability;

import java.util.LinkedList;

/**
 * Created by hnastevska on 7/10/2017.
 */
public class PathNode {
    private Person person = null;
    private PathNode previousNode = null;

    public PathNode(Person person, PathNode previousNode) {
        this.person = person;
        this.previousNode = previousNode;
    }

    public Person getPerson() {
        return person;
    }

    public LinkedList<Person> collapse(boolean startsWithRoot) {
        LinkedList<Person> path = new LinkedList<>();
        PathNode node = this;
        while (node != null) {
            if (startsWithRoot) {
                path.addLast(node.person);
            } else {
                path.addFirst(node.person);
            }
            node = node.previousNode;
        }
        return path;
    }
}
