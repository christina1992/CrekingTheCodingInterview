package Chapter9.SystemDesignAndScalability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by hnastevska on 7/10/2017.
 */
public class BFSData {
    //acts as Queue
    public LinkedList<PathNode> toVisist = new LinkedList<>();
    //Acts as Graph
    public HashMap<Integer, PathNode> visited = new HashMap<>();

    public BFSData(Person root) {
        PathNode sourcePath = new PathNode(root, null);
        toVisist.add(sourcePath);
        visited.put(root.getId(), sourcePath);
    }

    public boolean isFinished() {
        return toVisist.isEmpty();
    }

    LinkedList<Person> findPathBiBFS(HashMap<Integer, Person> people, int source, int destination) {
        BFSData sourceData = new BFSData(people.get(source));
        BFSData destData = new BFSData(people.get(destination));

        while (!sourceData.isFinished() && !destData.isFinished()) {
            /*Search out from source */
            Person collision = searchLevel(people, sourceData, destData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getId());
            }
        }
        return null;
    }

    LinkedList<Person> mergePaths(BFSData bfs1, BFSData bfs2, int connection) {
        PathNode end1 = bfs1.visited.get(connection); // end1 -> source
        PathNode end2 = bfs2.visited.get(connection); // end2 -> dest
        LinkedList<Person> pathOne = end1.collapse(false);
        LinkedList<Person> pathTwo = end2.collapse(true); // reverse
        pathTwo.removeFirst(); // remove connection
        pathOne.addAll(pathTwo); // add second path
        return pathOne;
    }

    /*Search one level and return collision, if any. */
    private Person searchLevel(HashMap<Integer, Person> people, BFSData primary, BFSData secundary) {
        /* We only want to search one level at a time. Count how many nodes are
         * currently in the primary's level and only do that many nodes. We'll continue
          * to add nodes to the end.*/
        int count = primary.toVisist.size();
        for (int i = 0; i < count; i++) {
            /*Pull out first node*/
            PathNode pathNode = primary.toVisist.poll();
            int personId = pathNode.getPerson().getId();

            /*Check if it's already been visited*/
            if (secundary.visited.containsKey(personId)) {
                return pathNode.getPerson();
            }

            /*Add friends to queue. */
            Person person = pathNode.getPerson();
            ArrayList<Integer> friends = person.getFriends();
            for (int friendId : friends) {
                if (!primary.visited.containsKey(friendId)) {
                    Person friend = people.get(friendId);
                    PathNode next = new PathNode(friend, pathNode);
                    primary.visited.put(friendId, next);
                    primary.toVisist.add(next);
                }
            }
        }
        return null;
    }
}
