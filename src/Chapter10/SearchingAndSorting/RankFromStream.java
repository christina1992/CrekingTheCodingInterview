package Chapter10.SearchingAndSorting;

/**
 * Rank from Stream: Imagine you are reading in a stream of integers. Periodically, you wish
 * to be able to look up the rank of a number x (the number of values less than or equal to x).
 * Implement the data structures and algorithms to support these operations. That is, implement
 * the method track(int x), which is called when each number is generated, and the method
 * getRankOfNumber(int x), which returns the number of values less than or equal to x (not
 * including x itself).
 */
public class RankFromStream {
    RankNode root = null;

    void track(int number) {
        if (root == null) {
            root = new RankNode(number);
        } else {
            root.insert(number);
        }
    }

    int getRankOfNumber(int number) {
        return root.getRank(number);
    }
}
