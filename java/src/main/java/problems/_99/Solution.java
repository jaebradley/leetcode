package problems._99;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 * <p>
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 * <p>
 * Approach:
 * In-order traversal represents iterating over the nodes in order from smallest to largest.
 * When iterating, find first node where previous node value is > current node value - the previous node will be the first invalid node
 * Then find next node where previous node value is > current node value - this will be the next invalid node
 * Swap the two node values
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

    public void recoverTree(TreeNode root) {
        final AtomicReference<Optional<TreeNode>> firstInvalidNode = new AtomicReference<>(Optional.empty());
        final AtomicReference<Optional<TreeNode>> secondInvalidNode = new AtomicReference<>(Optional.empty());
        final AtomicReference<Optional<TreeNode>> previousNode = new AtomicReference<>(Optional.empty());
        traverse(root, firstInvalidNode, secondInvalidNode, previousNode);
        secondInvalidNode.get().ifPresent(v -> {
            final int secondInvalidNodeValue = v.val;
            firstInvalidNode.get().ifPresent(v2 -> {
                final int firstInvalidNodeValue = v2.val;

                v2.val = secondInvalidNodeValue;
                v.val = firstInvalidNodeValue;
            });
        });
    }

    private static void traverse(
            final TreeNode currentNode,
            final AtomicReference<Optional<TreeNode>> firstInvalidNode,
            final AtomicReference<Optional<TreeNode>> secondInvalidNode,
            final AtomicReference<Optional<TreeNode>> previousNode
    ) {
        if (null != currentNode) {
            traverse(currentNode.left, firstInvalidNode, secondInvalidNode, previousNode);

            if (firstInvalidNode.get().isEmpty()) {
                if (previousNode.get().isPresent() && previousNode.get().get().val >= currentNode.val) {
                    firstInvalidNode.set(previousNode.get());
                }
            }

            if (firstInvalidNode.get().isPresent()) {
                if (previousNode.get().isPresent() && previousNode.get().get().val >= currentNode.val) {
                    secondInvalidNode.set(Optional.of(currentNode));
                }
            }

            previousNode.set(Optional.of(currentNode));

            traverse(currentNode.right, firstInvalidNode, secondInvalidNode, previousNode);
        }
    }
}
