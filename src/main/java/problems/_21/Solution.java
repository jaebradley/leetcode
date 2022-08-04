package problems._21;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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

    public boolean findTarget(TreeNode root, int k) {
        final Set<Integer> complements = new HashSet<>();
        final Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            final TreeNode currentNode = nodes.remove();
            if (complements.contains(currentNode.val)) {
                return true;
            }

            complements.add(k - currentNode.val);

            if (null != currentNode.left) {
                nodes.add(currentNode.left);
            }

            if (null != currentNode.right) {
                nodes.add(currentNode.right);
            }
        }

        return false;
    }
}
