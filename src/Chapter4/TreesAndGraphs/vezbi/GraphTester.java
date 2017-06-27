package Chapter4.TreesAndGraphs.vezbi;


/**
 * Created by hnastevska on 6/21/2017.
 */
public class GraphTester {
    public static void main(String[] args) {
        Character niza[] = new Character[10];
        //Postavuvanje na bukvite od A do J vo niza
        //0:A 1:B 2:C 3:D 4:E 5:F 6:G 7:H 8:I 9:J
        for (int i = 0; i < 10; i++)
            niza[i] = (char) ((int) 'A' + i);
        Graph<Character> g = new Graph<Character>(10, niza);
        g.addEdge(0, 1); //dodavam rebro od A do B
        g.addEdge(1, 2); //dodavam rebro od B do C
        g.addEdge(2, 3); //dodavam rebro od C do D
        g.addEdge(3, 6); //dodavam rebro od D do G
        g.addEdge(6, 9); //dodavam rebro od G do J
        g.addEdge(2, 5); //dodavam rebro od B do F
        g.addEdge(5, 8); //dodavam rebro od F do I
        g.addEdge(0, 4); //dodavam rebro od A do E
        g.addEdge(0, 6); //dodavam rebro od A do G
        System.out.print(g);
        System.out.println(g.isThereARoute(2,5));
        System.out.println(g.isThereARouteBFS(2,5));
        System.out.println(g.isThereARouteDFS(2,5));
//       System.out.println(g.hasVertex(-2));
//        System.out.println(g.countEdges());
//        System.out.println(g.countVertex())
//       System.out.println(g.getDegree(5));
//        System.out.println("Depth First Search Recursive:");
//       g.dfsSearch(0);
//        System.out.println("Depth First Search Nonrecursive:");
//        g.dfsNonrecursive(0);
//        System.out.println("Breath First Search:");
        //g.bfs(0);

    }
}
