package problems._993;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/cousins-in-binary-tree/
 *
 * Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
 *
 * Two nodes of a binary tree are cousins if they have the same depth with different parents.
 *
 * Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
 *
 * Queue with root
 * While queue is not empty
 * Create next queue, using current queue, using null value to separate siblings
 * If see one of x or y, look for the other
 * If other is not found at current depth, return false
 * If other is found, and at least one null separates the values, then true,
 * else false
 */

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

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> currentNodes = new LinkedList<>();
        currentNodes.add(root);

        while (!currentNodes.isEmpty()) {
            Queue<TreeNode> nextNodes = new LinkedList<>();
            boolean potentiallyCousins = false;
            Integer seenSibling = null;

            while (!currentNodes.isEmpty()) {
                final TreeNode currentNode = currentNodes.poll();
                if (null == currentNode) {
                    potentiallyCousins = true;
                } else {
                    if (x == currentNode.val) {
                        if (null == seenSibling) {
                            seenSibling = x;
                            potentiallyCousins = false;
                        } else {
                            return potentiallyCousins;
                        }
                    } else if (y == currentNode.val) {
                        if (null == seenSibling) {
                            seenSibling = y;
                            potentiallyCousins = false;
                        } else {
                            return potentiallyCousins;
                        }
                    }
                    nextNodes.add(currentNode.left);
                    nextNodes.add(currentNode.right);
                    nextNodes.add(null);
                }
            }

            if (null != seenSibling) {
                return false;
            }

            currentNodes = nextNodes;
        }

        return false;
    }
}
