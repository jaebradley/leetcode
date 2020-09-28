package problems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * Approach:
 *
 * 1. Keep level order traversal nodes in a queue
 * 2. Zig-Zag is just reversing the order every-other level
 */

public class BinaryTreeZigZagLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        if (null == root) {
            return results;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean readLeftToRight = true;

        while (!queue.isEmpty()) {
            List<TreeNode> nodes = new ArrayList<>();
            Queue<TreeNode> nextQueue = new LinkedList<>();

            for (TreeNode node : queue) {
                if (node != null) {
                    if (node.left != null) {
                        nextQueue.add(node.left);
                    }

                    if (node.right != null) {
                        nextQueue.add(node.right);
                    }

                    nodes.add(node);
                }
            }
            List<Integer> nodeValues = nodes.stream().map(node -> node.val).collect(Collectors.toList());

            if (!readLeftToRight) {
                Collections.reverse(nodeValues);
            }
            results.add(nodeValues);

            readLeftToRight = !readLeftToRight;
            queue = nextQueue;
        }

        return results;
    }
}
