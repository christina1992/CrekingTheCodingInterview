package Chapter4.TreesAndGraphs;




import GraphsAndTreesBasic.finki_stuff.graphs.lista_tezinski_nasocen.Graph;

import java.util.LinkedList;

public class RouteBetweenNodes {
    boolean search(Graph g, Node start, Node end) {
        if (start == end) return true;

        //Operates as Quequ
        LinkedList<Node> q = new LinkedList<>();

        for (Node u : g.getNodes()) {
            u.state = State.Unviited;
        }
        start.state = State.Viiting;
        q.add(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst(); // dequeue
            if (u != null) {
                for (Node v : u.getAdjacent()) {
                    if (v.state == State.Unviited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Viiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Viited;
            }

        }
        return false;
    }


    enum State {Unviited, Viited, Viiting}
}
