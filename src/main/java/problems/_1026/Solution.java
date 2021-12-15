package problems._1026;

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

    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }

    private static int helper(final TreeNode node, int minimumAncestorValue, int maximumAncestorValue) {
        if (null == node) {
            return maximumAncestorValue - minimumAncestorValue;
        }

        return Math.max(
                helper(node.left, Math.min(minimumAncestorValue, node.val), Math.max(maximumAncestorValue, node.val)),
                helper(node.right, Math.min(minimumAncestorValue, node.val), Math.max(maximumAncestorValue, node.val))
        );
    }

}
