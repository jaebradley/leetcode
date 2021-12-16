package problems._1382;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public TreeNode balanceBST(TreeNode root) {
        final List<TreeNode> inorderNodes = getInorderNodes(root);
        return createBalancedTree(inorderNodes, 0, inorderNodes.size() - 1);
    }

    private static TreeNode createBalancedTree(final List<TreeNode> nodes, int startingIndex, int endingIndex) {
        if (startingIndex > endingIndex) {
            return null;
        }
        final int middleIndex = startingIndex + (endingIndex - startingIndex) / 2;
        final TreeNode root = new TreeNode(nodes.get(middleIndex).val);
        if (startingIndex != endingIndex) {
            root.left = createBalancedTree(nodes, startingIndex, middleIndex - 1);
            root.right = createBalancedTree(nodes, middleIndex + 1, endingIndex);
        }

        return root;
    }

    private static List<TreeNode> getInorderNodes(TreeNode root) {
        final List<TreeNode> nodes = new ArrayList<>();
        TreeNode currentNode = root;
        final Stack<TreeNode> stack = new Stack<>();
        while (null != currentNode || !stack.isEmpty()) {
            while (null != currentNode) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            nodes.add(currentNode);
            currentNode = currentNode.right;
        }
        return nodes;
    }

}
