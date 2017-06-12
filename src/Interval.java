
/**
 *
 * @author Kire
 */
public class Interval {
    static boolean overlapTest(int a, int b, int c, int d) {
        if (((((c < b) && (b < d)) ||
                ((a < c) && (c < b))) ||
                ((c < a) && (a < b) && (b < d))) ||
                ((a < c) && (c < d) && (d < b))){
            System.out.println("true");
            return true;

        } else{
            System.out.println("false");
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        overlapTest(100, 200, 120, 250); // -> true
        overlapTest(135, 200, 140, 160); // -> true
        overlapTest(1000, 2000, 3000, 4000); // -> false
        overlapTest(500, 600, 100, 500); // -> true
        overlapTest(100, 200, 200, 201);// -> true
        overlapTest(400, 300, 200, 100);// -> false
        overlapTest(100, 300, 200, 400);// -> false

    }


}
