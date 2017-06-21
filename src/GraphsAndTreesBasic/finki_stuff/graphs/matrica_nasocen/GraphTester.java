package GraphsAndTreesBasic.finki_stuff.graphs.matrica_nasocen;

import java.util.Random;

/**
 * Created by hnastevska on 6/21/2017.
 */
public class GraphTester {
    public static void main(String[] args) {

        Character niza[] = new Character[10];
        //Postavuvanje na bukvite od A do J vo niza
        for (int i = 0; i < 10; i++)
            niza[i] = (char) ((int) 'A' + i);

        //Kreiranje na graf koj kako teminja gi sodrzi bukvite od nizata
        Graph<Character> g = new Graph<Character>(10, niza);

        //Kreiranje na 15 slucajni rebra megju teminjata
        int x, y;
        Random r = new Random();
        for (int i = 0; i < 15; i++) {
            x = r.nextInt(10);
            y = r.nextInt(10);
            if (x != y) {
                if (g.adjacent(x, y) != 1) {
                    g.addEdge(x, y);
                    System.out.println(i + ": Dodavam nasoceno rebro od " + niza[x] + " do " + niza[y]);
                } else
                    i--;
            } else
                i--;
        }
        System.out.println(g);
        System.out.println("Depth First Search Recursive:");
        g.dfsSearch(0);
        System.out.println("Depth First Search Nonrecursive:");
        g.dfsNonrecursive(0);
        System.out.println("Breath First Search:");
        g.bfs(0);
    }

}
