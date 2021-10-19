package problems._1448;

import java.util.Objects;
import java.util.Stack;

/**
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * <p>
 * Return the number of good nodes in the binary tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [3,3,null,4,2]
 * Output: 3
 * Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
 * Example 3:
 * <p>
 * Input: root = [1]
 * Output: 1
 * Explanation: Root is considered as good.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the binary tree is in the range [1, 10^5].
 * Each node's value is between [-10^4, 10^4].
 */


public class IterativeSolution {
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

    public static class Tuple {
        private final TreeNode node;
        private final int maximumPathValue;

        public Tuple(final TreeNode node, final int maximumPathValue) {
            this.node = node;
            this.maximumPathValue = maximumPathValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return maximumPathValue == tuple.maximumPathValue && Objects.equals(node, tuple.node);
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, maximumPathValue);
        }


        public TreeNode getNode() {
            return node;
        }

        public int getMaximumPathValue() {
            return maximumPathValue;
        }
    }

    public int goodNodes(TreeNode root) {
        int countOfGoodNodes = 0;
        final Stack<Tuple> stack = new Stack<>();
        stack.push(
                new Tuple(root, Integer.MIN_VALUE)
        );

        while (!stack.isEmpty()) {
            final Tuple nodeData = stack.pop();
            if (nodeData.node.val >= nodeData.getMaximumPathValue()) {
                countOfGoodNodes += 1;
            }
            final int maximumPathValue = Math.max(nodeData.node.val, nodeData.getMaximumPathValue());
            if (null != nodeData.node.right) {
                stack.push(new Tuple(nodeData.node.right, maximumPathValue));
            }

            if (null != nodeData.node.left) {
                stack.push(new Tuple(nodeData.node.left, maximumPathValue));
            }
        }

        return countOfGoodNodes;
    }
}
