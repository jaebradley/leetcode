package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 *
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
 *
 * Approach:
 *
 * 1.
 */

public class AverageOfLevelsInBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();

        if (root != null) {
            Queue<TreeNode> levels = new LinkedList<>();

            levels.add(root);

            while (!levels.isEmpty()) {
                double levelSum = 0;
                double levelCount = levels.size();
                Queue<TreeNode> nextLevels = new LinkedList<>();

                for (TreeNode node : levels) {
                    if (node != null) {
                        levelSum += node.val;

                        if (node.left != null) {
                            nextLevels.add(node.left);
                        }

                        if (node.right != null) {
                            nextLevels.add(node.right);
                        }
                    }
                }

                levels = nextLevels;
                averages.add(levelSum / levelCount);
            }
        }

        return averages;
    }
}
