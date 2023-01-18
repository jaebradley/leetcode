package problems._1448;

public class RecursiveSolution {
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

    public int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, 0);
    }

    private static int helper(final TreeNode node, final int maximumValueInPath, final int countOfGoodNodes) {
        if (null == node) {
            return 0;
        }
        final int nextMaximumValueInPath = Math.max(node.val, maximumValueInPath);

        return ((node.val >= maximumValueInPath) ? 1 : 0) + countOfGoodNodes + helper(node.left, nextMaximumValueInPath, countOfGoodNodes) + helper(node.right, nextMaximumValueInPath, countOfGoodNodes);
    }
}
