package GraphsAndTreesBasic.m;

/**
 * Created by hnastevska on 7/25/2017.
 */
public class ReverseDiagonal {
    static int[][] reverseDiagonal(int N, int M, int[][] A) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == j) {
                    int t = A[i][j];
                    A[i][j] = A[i][M - j - 1];
                    A[i][M - j - 1] = t;
                }
            }

        }

        return A;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},{10,11,12}};
        int[][] s = reverseDiagonal(3, 3, matrix);
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) {
                System.out.println(s[i][j]);
            }
        }
    }
}
