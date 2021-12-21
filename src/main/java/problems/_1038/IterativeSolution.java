package problems._1038;

import java.util.Objects;
import java.util.Stack;

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

    public TreeNode bstToGst(TreeNode root) {
        final Stack<TreeNode> stack = new Stack<>();
        int currentCount = 0;
        TreeNode currentNode = root;
        while (null != currentNode || !stack.isEmpty()) {
            while (null != currentNode) {
                stack.push(currentNode);
                currentNode = currentNode.right;
            }

            currentNode = stack.pop();
            currentNode.val += currentCount;
            currentCount = currentNode.val;
            currentNode = currentNode.left;
        }

        return root;
    }

}
