package problems._530;

import java.util.Objects;
import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 * <p>
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [4,2,6,1,3]
 * Output: 1
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [2, 104].
 * 0 <= Node.val <= 105
 * <p>
 * <p>
 * Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */

public class IterativeSolution {
    public static class TreeNode {
        public final int val;
        public final TreeNode left;
        public final TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public int getVal() {
            return val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null) {
                return false;
            }

            if (getClass() != obj.getClass()) {
                return false;
            }

            TreeNode treeNode = (TreeNode) obj;

            return Objects.equals(val, treeNode.val)
                    && Objects.equals(left, treeNode.left)
                    && Objects.equals(right, treeNode.right);
        }
    }

    public int getMinimumDifference(TreeNode root) {
        int minimumDifference = Integer.MAX_VALUE;
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        Integer previousValue = null;
        while (!stack.isEmpty() || (null != current)) {
            while (null != current) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (null != previousValue) {
                minimumDifference = Math.min(minimumDifference, Math.abs(previousValue - current.val));
            }
            previousValue = current.val;
            current = current.right;
        }
        return minimumDifference;
    }
}
