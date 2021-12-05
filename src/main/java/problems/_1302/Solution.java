package problems._1302;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 *
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 * Example 2:
 *
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 19
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 100
 */

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int deepestLeavesSum(TreeNode root) {
        int previousLevelSum = 0;
        if (null != root) {
            final Queue<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            while (!nodes.isEmpty()) {
                int currentLevelSum = 0;
                int currentLevelSize = nodes.size();
                for (int i = 0; i < currentLevelSize; i += 1) {
                    final TreeNode currentNode = nodes.remove();
                    currentLevelSum += currentNode.val;

                    if (null != currentNode.left) {
                        nodes.add(currentNode.left);
                    }

                    if (null != currentNode.right) {
                        nodes.add(currentNode.right);
                    }
                }
                previousLevelSum = currentLevelSum;
            }
        }

        return previousLevelSum;
    }
}
