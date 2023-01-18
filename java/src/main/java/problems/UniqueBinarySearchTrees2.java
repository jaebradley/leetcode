package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * <p>
 * Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 3
 * Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: [[1]]
 *
 * Approach:
 *
 * 1. Note that for a given N, the left subtree can be 1 to N and the right subtree can be N to 1
 * 2. So for some "root" candidate X, the left subtree can be 1 to X - 1, and the right subtree is X + 1 to N
 * 3. Can continue this logic recursively for each subtree
 * 4. For each possible left node, combine that with each possible right node to get the full set of node combinations for a given level
 * 5. The number of binary search trees is Catalan(N). Catalan numbers are O(4^N) so the time complexity is ~O(4^N)
 */

public class UniqueBinarySearchTrees2 {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }

    public List<TreeNode> generateTrees(int n) {
        return generateInRange(1, n);
    }

    private static List<TreeNode> generateInRange(final int start, final int end) {
        final List<TreeNode> values = new ArrayList<>();
        if (start > end) {
            values.add(null);
            return values;
        }

        if (start == end) {
            values.add(
                    new TreeNode(start)
            );
            return values;
        }

        for (int currentValue = start; currentValue <= end; currentValue++) {
            final List<TreeNode> possibleLeftNodes = generateInRange(start, currentValue - 1);
            final List<TreeNode> possibleRightNodes = generateInRange(currentValue + 1, end);

            for (final TreeNode leftNode : possibleLeftNodes) {
                for (final TreeNode rightNode : possibleRightNodes) {
                    values.add(
                            new TreeNode(
                                    currentValue,
                                    leftNode,
                                    rightNode
                            )
                    );
                }
            }
        }

        return values;
    }
}
