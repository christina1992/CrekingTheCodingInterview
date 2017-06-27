package Chapter5.BitManipulation;

/**
 * Created by hnastevska on 6/26/2017.
 */
public class Insertion {
    static int insertBits(int n, int m, int i, int j) {
        // Create a mask to clear bits i trough j in n.
        int allOnes = ~0; //will equal sequence of all 1s
        //1s before position j, then 0s. left = 11100000
        int left = allOnes << (j + 1);
        //1s after position i. right = 00000011
        int right = ((1 << i) - 1);
        //All 1s, except for 0s between i and j. mask = 11100011
        int mask = left | right;
        //Clear bits j trough i then put m in there
        int n_cleared = n & mask; // clear bits j trough i
        int m_shifted = m << i;

        return n_cleared|m_shifted;
    }

    public static void main(String[] args) {
        System.out.println(insertBits(10000000, 10011, 2, 4));
    }
}
