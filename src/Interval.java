import java.util.Scanner;

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

    }


}
