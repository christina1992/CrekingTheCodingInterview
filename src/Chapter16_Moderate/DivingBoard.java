package Chapter16_Moderate;

import java.util.HashSet;

/**
 * Created by hnastevska on 7/24/2017.
 */
public class DivingBoard {

    //This solution takes up to O(2^k)
    HashSet<Integer> allLengths(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>();
        getAllLengths(k, 0, shorter, longer, lengths);
        return lengths;
    }

    void getAllLengths(int k, int total, int shorter, int longer, HashSet<Integer> lengths) {
        if (k == 0) {
            lengths.add(total);
            return;
        }
        getAllLengths(k - 1, total + shorter, shorter, longer, lengths);
        getAllLengths(k - 1, total + longer, shorter, longer, lengths);
    }

    //Memoization
    HashSet<Integer> allLengths1(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        getAllLengths1(k, 0, shorter, longer, lengths, visited);
        return lengths;
    }

    void getAllLengths1(int k, int total, int shorter, int longer, HashSet<Integer> lengths, HashSet<String> visited) {
        if (k == 0) {
            lengths.add(total);
            return;
        }
        String key = k + " " + total;
        if (visited.contains(key)) {
            return;
        }
        getAllLengths1(k - 1, total + shorter, shorter, longer, lengths, visited);
        getAllLengths1(k - 1, total + longer, shorter, longer, lengths, visited);
        visited.add(key);
    }

    //The most optimal
    HashSet<Integer> allLengths2(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>();
        for (int nShorter = 0; nShorter <= k; nShorter++) {
            int nLonger = k - nShorter;
            int length = nShorter * shorter + nLonger * longer;
            lengths.add(length);
        }
        return lengths;
    }
}
