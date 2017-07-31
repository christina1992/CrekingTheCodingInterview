package Hackerrank_CTCI_;

import java.util.Scanner;

/**
 * Created by hnastevska on 7/28/2017.
 */
public class ArraysLeftRotation {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int[] rotatedA = leftRotation(a, k);
        for (int i = 0; i < rotatedA.length; i++) {
            System.out.print(rotatedA[i]+" ");
        }
    }

    public static int[] leftRotation(int[] a, int k) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[(i + k) % a.length];
        }
        return b;
    }
}
