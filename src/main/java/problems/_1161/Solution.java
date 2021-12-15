package problems._1161;

import java.util.LinkedList;
import java.util.Queue;

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

    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int currentLevel = 1;
        while (!queue.isEmpty()) {
            int currentLevelSum = 0;
            final int size = queue.size();
            for (int i = 0; i < size; i += 1) {
                final TreeNode node = queue.remove();
                currentLevelSum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (currentLevelSum > maxSum) {
                maxLevel = currentLevel;
                maxSum = currentLevelSum;
            }
            currentLevel += 1;
        }

        return maxLevel;
    }
}
