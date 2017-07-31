package GraphsAndTreesBasic.m;

/**
 * Created by hnastevska on 7/25/2017.
 */
public class Test {
    static int[] reverseDiagonal(int N, int M, int[][] A) {
        int[] fin = new int[N * M];
        int k = 0;
        int k1=0;
        //gorno trijagolna
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1 - i; j++) {
                    fin[k] = A[i][j];
                    k++;


            }
        }
        for(int i=1;i<N;i++){
            for(int j=0;j<N;j++){
                fin[k]=A[i][N-1-j];
                k++;
            }}

        return fin;
    }

    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {8, 9, 10, 11}
        };
        int[] kiki = reverseDiagonal(3, 4, m);
        for (int i = 0; i < kiki.length; i++) {
            System.out.println(kiki[i]);
        }
    }
}

