package problems._965;

import java.util.Stack;

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

    public boolean isUnivalTree(TreeNode root) {
        if (null == root) {
            return false;
        }
        final Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            final TreeNode currentNode = nodes.pop();
            if (currentNode.val != root.val) {
                return false;
            }

            if (null != currentNode.left) {
                nodes.add(currentNode.left);
            }

            if (null != currentNode.right) {
                nodes.add(currentNode.right);
            }
        }

        return true;
    }
}
