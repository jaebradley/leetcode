package problems._623;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class Solution {
    public static class TreeNode {
        private final int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(final int val, final TreeNode left, final TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
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

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (1 == depth) {
            return new TreeNode(val, root, null);
        }
        final Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int currentDepth = depth;
        while (!queue.isEmpty() && 1 != currentDepth) {
            currentDepth -= 1;
            final int size = queue.size();
            for (int count = 0; count < size; count += 1) {
                final TreeNode node = queue.poll();
                if (null != node) {
                    if (null != node.left) {
                        queue.add(node.left);
                    }

                    if (null != node.right) {
                        queue.add(node.right);
                    }

                    if (1 == currentDepth) {
                        node.left = new TreeNode(val, node.left, null);
                        node.right = new TreeNode(val, null, node.right);
                    }
                }
            }
        }

        return root;
    }

}
