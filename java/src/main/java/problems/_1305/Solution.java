package problems._1305;

import java.util.*;

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

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        final List<Integer> values = new ArrayList<>();
        final Queue<Integer> tree1Values = getElementValuesForTree(root1);
        final Queue<Integer> tree2Values = getElementValuesForTree(root2);
        while (!tree1Values.isEmpty() && !tree2Values.isEmpty()) {
            if (tree1Values.peek() > tree2Values.peek()) {
                values.add(tree2Values.remove());
            } else {
                values.add(tree1Values.remove());
            }
        }

        if (tree1Values.isEmpty()) {
            values.addAll(tree2Values);
        } else {
            values.addAll(tree1Values);
        }

        return values;
    }

    public static Queue<Integer> getElementValuesForTree(final TreeNode tree) {
        final Queue<Integer> values = new LinkedList<>();
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = tree;
        while (null != currentNode || !stack.isEmpty()) {
            while (null != currentNode) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            values.add(currentNode.val);
            currentNode = currentNode.right;
        }

        return values;
    }

}
