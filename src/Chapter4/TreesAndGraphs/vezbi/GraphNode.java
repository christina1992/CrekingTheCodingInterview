package Chapter4.TreesAndGraphs.vezbi;

import java.util.LinkedList;

/**
 * Created by hnastevska on 6/23/2017.
 */
public class GraphNode<E> {
    private int index; // index reden broj na temeto vo grafot
    private E info;
    public Graph.State state;

    private LinkedList<GraphNode<E>> neighbors;

    public GraphNode(int index, E info) {
        this.index = index;
        this.info = info;
        this.neighbors = new LinkedList<>();
    }

    boolean containsNeighbor(GraphNode<E> o) {
        return neighbors.add(o);
    }

    void addNeighbor(GraphNode<E> o) {
        neighbors.add(o);
    }

    void removeNeighbor(GraphNode<E> o) {
        if (neighbors.contains(o)) {
            neighbors.remove(o);
        }
    }

    public String toString() {
        String ret = "INFO:" + info + " SOSEDI:";
        for (int i = 0; i < neighbors.size(); i++) {
            ret += neighbors.get(i).info + " ";
        }
        return ret;
    }

    public boolean equals(Object obj) {
        GraphNode<E> pom = (GraphNode<E>) obj;
        return (pom.info.equals(this.info));
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public LinkedList<GraphNode<E>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(LinkedList<GraphNode<E>> neighbors) {
        this.neighbors = neighbors;
    }
}
