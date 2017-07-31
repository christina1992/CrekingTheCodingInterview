package Hackerrank_CTCI_;

import java.util.Scanner;

/**
 * Created by hnastevska on 7/28/2017.
 */
public class AnagramProblemSolutionGaylemcd {
    public static int CHAR_LETTERS = 26;

    public static int numberNeeded(String first, String second) {
        int[] charCounts1 = getCharCounts(first);
        int[] charCounts2 = getCharCounts(second);
        return getDelta(charCounts1, charCounts2);
    }

    private static int[] getCharCounts(String str) {
        int[] charCounts = new int[CHAR_LETTERS];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int code = c -'a';
            charCounts[code]++;
        }
        return charCounts;
    }

    private static int getDelta(int[] charCounts1, int[] charCounts2) {
        if (charCounts1.length != charCounts2.length)
            return -1; // poso mu davame size gore 26 kolku so e dolga angliskata azbuka
        int delta = 0;
        for (int i = 0; i < charCounts1.length; i++) {
            int difference = Math.abs(charCounts1[i] - charCounts2[i]);
            delta += difference;
        }
        return delta;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
