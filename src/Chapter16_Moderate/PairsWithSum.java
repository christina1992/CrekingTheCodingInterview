package Chapter16_Moderate;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hnastevska on 7/25/2017.
 * Pairs with Sum: Design an algorithm to find all pairs of integers within an array which sum to a
 * specified value.
 */
public class PairsWithSum {
    ArrayList<Pair> printPairSums(int[] array, int sum) {
        ArrayList<Pair> result = new ArrayList<>();
        HashMap<Integer, Integer> unpairedCount = new HashMap<>();
        for (int x : array) {
            int compliment = sum - x;
            if (unpairedCount.getOrDefault(compliment, 0) > 0) {
                result.add(new Pair(x, compliment));
                adjustCounterBy(unpairedCount, compliment, -1);// decrement compliment
            } else {
                adjustCounterBy(unpairedCount, x, 1);// increment count
            }
        }
        return result;
    }

    private void adjustCounterBy(HashMap<Integer, Integer> counter, int key, int delta) {
        counter.put(key, counter.getOrDefault(key, 0) + delta);
    }
}
