package GraphsAndTreesBasic.finki_stuff.graphs.matrica_nasocen;

import java.util.Stack;

/**
 * Created by hnastevska on 6/21/2017.
 */
public class Graph<E> {

    int num_nodes; // broj na jazli
    E nodes[];    // informacija vo jazlite - moze i ne mora?
    int adjMat[][];  // matrica na sosednost

    @SuppressWarnings("unchecked")
    public Graph(int num_nodes) {
        this.num_nodes = num_nodes;
        nodes = (E[]) new Object[num_nodes];
        adjMat = new int[num_nodes][num_nodes];

        for(int i=0;i<this.num_nodes;i++)
            for(int j=0;j<this.num_nodes;j++)
                adjMat[i][j]=0;
    }



    public Graph(int num_nodes, E[] nodes) {
        this.num_nodes = num_nodes;
        this.nodes = nodes;
        adjMat = new int[num_nodes][num_nodes];

        for(int i=0;i<this.num_nodes;i++)
            for(int j=0;j<this.num_nodes;j++)
                adjMat[i][j]=0;
    }



    int adjacent(int x,int y)
    {  // proveruva dali ima vrska od jazelot so indeks x do jazelot so indeks y
        return (adjMat[x][y]!=0)?1:0;
    }

    void addEdge(int x,int y)
    {  // dodava vrska megu jazlite so indeksi x i y
        adjMat[x][y]=1;
    }

    void deleteEdge(int x,int y)
    {
        // ja brise vrskata megu jazlite so indeksi x i y
        adjMat[x][y]=0;
    }

    // Moze i ne mora?
    E get_node_value(int x)
    {  // ja vraka informacijata vo jazelot so indeks x
        return nodes[x];
    }

    // Moze i ne mora?
    void set_node_value(int x, E a)
    {  // ja postavuva informacijata vo jazelot so indeks na a
        nodes[x]=a;
    }

    public int getNum_nodes() {
        return num_nodes;
    }

    public void setNum_nodes(int num_nodes) {
        this.num_nodes = num_nodes;
    }

    void dfsSearch(int node) {
        boolean visited[] = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            visited[i] = false;
        dfsRecursive(node, visited);
    }

    void dfsRecursive(int node, boolean visited[]) {
        visited[node] = true;
        System.out.println(node + ": " + nodes[node]);

        for (int i = 0; i < this.num_nodes; i++) {
            if(adjacent(node, i)==1){
                if (!visited[i])
                    dfsRecursive(i, visited);
            }
        }
    }

    void dfsNonrecursive(int node) {
        boolean visited[] = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            visited[i] = false;
        visited[node] = true;
        System.out.println(node + ": " + nodes[node]);
        Stack<Integer> s = new Stack<Integer>();
        s.push(node);

        int pom;

        while (!s.isEmpty()) {
            pom = s.peek();
            int pom1 = pom;
            for (int i = 0; i < num_nodes; i++) {
                if(adjacent(pom,i)==1){
                    pom1 = i;
                    if(!visited[i])
                        break;
                }
            }
            if(!visited[pom1]){
                visited[pom1] = true;
                System.out.println(pom1 + ": " + nodes[pom1]);
                s.push(pom1);
            }
            else
                s.pop();
        }

    }

    void bfs(int node){
        boolean visited[] = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            visited[i] = false;
        visited[node] = true;
        System.out.println(node+": " + nodes[node]);
        Queue<Integer> q = new LinkedQueue<Integer>();
        q.enqueue(node);

        int pom;

        while(!q.isEmpty()){
            pom = q.dequeue();
            for (int i = 0; i < num_nodes; i++) {
                if(adjacent(pom, i)==1){
                    if (!visited[i]){
                        visited[i] = true;
                        System.out.println(i+": " + nodes[i]);
                        q.enqueue(i);
                    }

                }
            }


        }

    }

    @Override
    public String toString() {
        String ret="  ";
        for(int i=0;i<num_nodes;i++)
            ret+=nodes[i]+" ";
        ret+="\n";
        for(int i=0;i<num_nodes;i++){
            ret+=nodes[i]+" ";
            for(int j=0;j<num_nodes;j++)
                ret+=adjMat[i][j]+" ";
            ret+="\n";
        }
        return ret;
    }


    public E[] getNodes() {
        return nodes;
    }
}
