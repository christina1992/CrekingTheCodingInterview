package Chapter4.TreesAndGraphs;

import Chapter4.TreesAndGraphs.very_important_tree_creation.TreeNode;

/**
 * Paths with Sum: You are given a binary tree in which each node contains an integer value (which
 * might be positive or negative). Design an algorithm to count the number of paths that sum to a
 * given value. The path does not need to start or end at the root or a leaf, but it must go downwards
 * (traveling only from parent nodes to ch ild nodes).
 * The runtime is O(N log N). in a balanced tree
 * In not balanced tree / worst case this gous up to O(n^2)
 */
public class Paths_with_Sum {
    int countPathsWithSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        //Count paths with sum starting from the root
        int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);

        //Try the nodes on the left and right
        int pathsOnLeft = countPathsWithSum(root.left, targetSum);
        int pathsOnRight = countPathsWithSum(root.right, targetSum);

        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    //Returns the number of paths with this sum starting from this node
    private int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
        if (node == null) return 0;
        currentSum += node.data();

        int totalPaths = 0;
        if (currentSum == targetSum) {
            totalPaths++;
        }

        totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum);
        totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum);
        return totalPaths;
    }

}
