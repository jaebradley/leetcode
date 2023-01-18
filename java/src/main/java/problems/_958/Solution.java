package problems._958;

import java.util.LinkedList;
import java.util.Objects;
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

    public boolean isCompleteTree(TreeNode root) {
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        boolean isLastLevel = false;
        while (!queue.isEmpty()) {
            final int size = queue.size();
            if (!isLastLevel && size != Math.pow(2, level)) {
                return false;
            }
            for (int i = 0; i < size; i += 1) {
                final TreeNode currentNode = queue.poll();
                if (null == currentNode) {
                    isLastLevel = true;
                } else if (isLastLevel) {
                    return false;
                } else {
                    queue.add(currentNode.left);
                    queue.add(currentNode.right);
                }
            }
            level += 1;
        }

        return true;
    }

}
