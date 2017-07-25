package GraphsAndTreesBasic.m;

/**
 * Created by hnastevska on 7/25/2017.
 */
public class Test {
    public static void main(String[] args) {
        int[][] forward = {
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };
        int rows = forward.length;
        int cols = forward[0].length;
        int[][] reverse = new int[rows][cols];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                reverse[rows - 1 - i][cols - 1 - j] = forward[i][j];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(reverse[i][j]);
                if (j < cols - 1)
                    System.out.print(", ");
            }
            System.out.println();
        }
    }
}

