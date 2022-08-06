package problems._1145;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-coloring-game/
 * <p>
 * Two players play a turn based game on a binary tree. We are given the root of this binary tree, and the number of nodes n in the tree. n is odd, and each node has a distinct value from 1 to n.
 * <p>
 * Initially, the first player names a value x with 1 <= x <= n, and the second player names a value y with 1 <= y <= n and y != x. The first player colors the node with value x red, and the second player colors the node with value y blue.
 * <p>
 * Then, the players take turns starting with the first player. In each turn, that player chooses a node of their color (red if player 1, blue if player 2) and colors an uncolored neighbor of the chosen node (either the left child, right child, or parent of the chosen node.)
 * <p>
 * If (and only if) a player cannot choose such a node in this way, they must pass their turn. If both players pass their turn, the game ends, and the winner is the player that colored more nodes.
 * <p>
 * You are the second player. If it is possible to choose such a y to ensure you win the game, return true. If it is not possible, return false.
 * <p>
 * Approach:
 * So there are three subtrees to check:
 * 1. Parent / Sibling subtree
 * 2. Left child subtree
 * 3. Right child subtree
 * <p>
 * Post order traverse the tree (L, R, Current Node)
 * If current node is first player's guess, calculate depth of left subtree and right subtree
 * If either depth is > n / 2, return true
 * If n / 2 > depth of left subtree + depth of right subtree + 1, return true
 * Else return false
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

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {

        final Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            final TreeNode currentNode = nodes.remove();
            if (x == currentNode.val) {
                final int leftSubtreeCount = calculateNodeCount(currentNode.left);
                final int rightSubtreeCount = calculateNodeCount(currentNode.right);

                return Math.max(
                        Math.max(
                                leftSubtreeCount,
                                rightSubtreeCount
                        ),
                        n - leftSubtreeCount - rightSubtreeCount - 1
                ) > n / 2;
            }

            if (null != currentNode.left) {
                nodes.add(currentNode.left);
            }

            if (null != currentNode.right) {
                nodes.add(currentNode.right);
            }
        }

        return false;
    }

    private static int calculateNodeCount(final TreeNode node) {
        if (null != node) {
            return 1 + calculateNodeCount(node.left) + calculateNodeCount(node.right);
        }
        return 0;
    }
}
