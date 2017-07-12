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
        Scanner in = new Scanner(System.in);
        int counter = 0;
        int sum = 0;
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();

            for (int i = 0; i < n; i++) {
                if (i % 3 == 0 || i % 5 == 0) {
                    sum += i;
                }
            }
            System.out.println(sum);
            sum=0;
        }


    }


}
