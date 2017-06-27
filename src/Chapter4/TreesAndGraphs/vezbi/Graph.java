package Chapter4.TreesAndGraphs.vezbi;


import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by hnastevska on 6/23/2017.
 */
public class Graph<E> {
    int num_nodes;
    GraphNode<E> adjList[]; // niza na sosedstvo

    public Graph(int num_nodes, E[] list) {
        this.num_nodes = num_nodes;
        adjList = (GraphNode<E>[]) new GraphNode[num_nodes];
        for (int i = 0; i < num_nodes; i++) {
            adjList[i] = new GraphNode<>(i, list[i]);
        }
    }

    public Graph(int num_nodes) {
        this.num_nodes = num_nodes;
        adjList = (GraphNode<E>[]) new GraphNode[num_nodes];
    }

    int adjacent(int x, int y) {
        //Proveruva dali ima vrska od jazelot so
        //indeks x do jazelot so indeks y
        return (adjList[x].containsNeighbor(adjList[y])) ? 1 : 0;
    }

    void addEdge(int x, int y) {
        //Dodava vrska od jazelot so indeks x do jazelot so indeks y
        if (!adjList[x].containsNeighbor(adjList[y])) {
            adjList[x].addNeighbor(adjList[y]);
        }
    }

    void deleteEdge(int x, int y) {
        adjList[x].removeNeighbor(adjList[y]);
    }

    public String toString() {
        String ret = new String();
        for (int i = 0; i < this.num_nodes; i++) {
            ret += i + ": " + adjList[i] + "\n";
        }
        return ret;
    }

    public int getNum_nodes() {
        return num_nodes;
    }

    public void setNum_nodes(int num_nodes) {
        this.num_nodes = num_nodes;
    }

    public GraphNode<E>[] getAdjList() {
        return adjList;
    }

    public void setAdjList(GraphNode<E>[] adjList) {
        this.adjList = adjList;
    }

    public int countVertex() {
        return num_nodes;
    }

    public int countEdges() {
        int count = 0;
        for (int i = 0; i < num_nodes; i++) {
            count += adjList[i].getNeighbors().size();
        }
        return count;
    }

    public boolean hasVertex(int vertex) {
        if (num_nodes <= vertex || vertex < 0) return false;
        if (adjList[vertex] != null)
            return true;
        return false;
    }

    public boolean hasEdge(int x, int y) {
        if (adjList[x].containsNeighbor(adjList[y])) {
            return true;
        }
        return false;
    }

    public int getDegree(int vertex) {
        if (adjList[vertex] == null) return 0;
        return adjList[vertex].getNeighbors().size();
    }

    void dfsSearch(int node) {
        boolean[] visited = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++) {
            visited[i] = false;
        }
        dfsRecursive(node, visited);
    }

    //DFS RECURSIVE

    public boolean isThereARoute(int start, int end) {
        boolean[] visited = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++) {
            visited[i] = false;
        }
        return checkRoute(start, end, visited);
    }

    private boolean checkRoute(int start, int end, boolean[] visited) {
        if (start == end) return true;
        visited[start] = true;
        for (int i = 0; i < adjList[start].getNeighbors().size(); i++) {
            GraphNode<E> pom = adjList[start].getNeighbors().get(i);
            if (!visited[pom.getIndex()]) {
                if (pom.equals(adjList[end])) return true;
                checkRoute(pom.getIndex(), end, visited);
            }
        }
        return false;
    }

    public boolean isThereARouteBFS(int start, int end) {
        boolean[] visited = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++) {
            visited[i] = false;
        }
        visited[start] = true;
        LinkedList<Integer> q = new LinkedList<>();
        q.add(start);
        GraphNode<E> pom;

        while (!q.isEmpty()) {
            pom = adjList[q.removeFirst()];
            GraphNode<E> tmp = null;
            for (int i = 0; i < pom.getNeighbors().size(); i++) {
                tmp = pom.getNeighbors().get(i);
                if (!visited[tmp.getIndex()]) {
                    visited[tmp.getIndex()] = true;
                    if (tmp.getIndex() == end) return true;
                    q.add(tmp.getIndex());
                }
            }


        }
        return false;
    }

    public boolean isThereARouteDFS(int start, int end) {
        boolean[] visited = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++) {
            visited[i] = false;
        }
        visited[start] = true;
        Stack<Integer> s = new Stack<>();
        s.push(start);

        while (!s.isEmpty()) {
            GraphNode<E> pom = adjList[s.peek()];
            GraphNode<E> tmp = null;
            for (int i = 0; i < pom.getNeighbors().size(); i++) {
                tmp = pom.getNeighbors().get(i);
                if (!visited[tmp.getIndex()])
                    break;
            }
            if (tmp != null && !visited[tmp.getIndex()]) {
                visited[tmp.getIndex()] = true;
                if (tmp.getIndex() == end) return true;
                s.push(tmp.getIndex());
            } else {
                s.pop();
            }

        }
        return false;
    }

    void dfsRecursive(int node, boolean visited[]) {
        visited[node] = true;
        System.out.println(node + ": " + adjList[node].getInfo());

        for (int i = 0; i < adjList[node].getNeighbors().size(); i++) {
            GraphNode<E> pom = adjList[node].getNeighbors().get(i);
            if (!visited[pom.getIndex()]) {
                dfsRecursive(pom.getIndex(), visited);
            }
        }

    }

    void dfsNonrecursive(int node) {
        boolean[] visited = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++) {
            visited[i] = false;
        }
        visited[node] = true;
        System.out.println(node + ": " + adjList[node].getInfo());
        Stack<Integer> s = new Stack<>();
        s.push(node);

        GraphNode<E> pom;

        while (!s.isEmpty()) {
            pom = adjList[s.peek()];
            GraphNode<E> tmp = null;
            for (int i = 0; i < pom.getNeighbors().size(); i++) {
                tmp = pom.getNeighbors().get(i);
                if (!visited[tmp.getIndex()])
                    break;
            }
            if (tmp != null && !visited[tmp.getIndex()]) {
                visited[tmp.getIndex()] = true;
                System.out.println(tmp.getIndex() + ": " + tmp.getInfo());
                s.push(tmp.getIndex());
            } else {
                s.pop();
            }
        }
    }

    //DFS NONRECURSIVE

    //BFS NONRECURSIVE
    void bfs(int node) {
        boolean visited[] = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            visited[i] = false;
        visited[node] = true;
        System.out.println(node + ": " + adjList[node].getInfo());
        Queue<Integer> q = new LinkedQueue<>();
        q.enqueue(node);

        GraphNode<E> pom;

        while (!q.isEmpty()) {
            pom = adjList[q.dequeue()];
            GraphNode<E> tmp = null;
            for (int i = 0; i < pom.getNeighbors().size(); i++) {
                tmp = pom.getNeighbors().get(i);
                if (!visited[tmp.getIndex()]) {
                    visited[tmp.getIndex()] = true;
                    System.out.println(tmp.getIndex() + ": " + tmp.getInfo());
                    q.enqueue(tmp.getIndex());
                }
            }


        }

    }

    enum State {Unviited, Viited, Viiting}

}
