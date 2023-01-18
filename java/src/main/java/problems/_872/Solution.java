package problems._872;

import java.util.ArrayList;
import java.util.List;
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return calculateLeafSequence(root1).equals(calculateLeafSequence(root2));
    }

    private static List<Integer> calculateLeafSequence(final TreeNode root) {
        final List<Integer> sequence = new ArrayList<>();
        if (null == root) {
            return sequence;
        }
        final Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            final TreeNode node = nodes.pop();
            if (null != node.right) {
                nodes.add(node.right);
            }

            if (null != node.left) {
                nodes.add(node.left);
            }

            if (null == node.right && null == node.left) {
                sequence.add(node.val);
            }
        }

        return sequence;
    }

}
