package problems._1022;

import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 * <p>
 * You are given the root of a binary tree where each node has a value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 * <p>
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 * <p>
 * Return the sum of these numbers. The answer is guaranteed to fit in a 32-bits integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * Example 2:
 * <p>
 * Input: root = [0]
 * Output: 0
 * Example 3:
 * <p>
 * Input: root = [1]
 * Output: 1
 * Example 4:
 * <p>
 * Input: root = [1,1]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 1000].
 * Node.val is 0 or 1.
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

    public int sumRootToLeaf(TreeNode root) {
        // adding 0 to end of a value is same as multiplying by 2
        // adding 1 to end of a value is same as multiplying by 2 and adding 1
        int sum = 0;
        if (null != root) {
            final Stack<Map.Entry<TreeNode, Integer>> nodes = new Stack<>();
            nodes.add(Map.entry(root, 0));

            while (!nodes.empty()) {
                final Map.Entry<TreeNode, Integer> currentNodeData = nodes.pop();
                int nextValue = currentNodeData.getValue() * 2;
                if (1 == currentNodeData.getKey().val) {
                    nextValue += 1;
                }
                final TreeNode left = currentNodeData.getKey().left;
                final TreeNode right = currentNodeData.getKey().right;
                if (null == left && null == right) {
                    sum += nextValue;
                }

                if (null != left) {
                    nodes.add(Map.entry(left, nextValue));
                }

                if (null != right) {
                    nodes.add(Map.entry(right, nextValue));
                }
            }
        }

        return sum;
    }
}
