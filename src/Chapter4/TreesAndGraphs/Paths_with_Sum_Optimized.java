package Chapter4.TreesAndGraphs;

import Chapter4.TreesAndGraphs.very_important_tree_creation.TreeNode;

import java.util.HashMap;

/**
 * O(n)  time / O(logN) space
 */
public class Paths_with_Sum_Optimized {
    int countPathsWithSum(TreeNode root, int targetSum) {
        return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
    }

    private int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (node == null) return 0; // Base case

        //Count paths with sum ending at the current node
        runningSum += node.data();
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        //If runningSum equals targetSum, then one additional path starts at root.
        //Add in this path
        if (runningSum == targetSum) {
            totalPaths++;
        }

        //Increment pathCount, recurse, then decrement pathCount
        incrementHashTable(pathCount, runningSum, 1); //Increment pathCount
        totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);
        return totalPaths;
    }

    private void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) { //Remove when zero to reduce space usage
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }

}
