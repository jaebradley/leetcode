package problems._1110;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 * <p>
 * Given the root of a binary tree, each node in the tree has a distinct value.
 * <p>
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 * <p>
 * Return the roots of the trees in the remaining forest. You may return the result in any order.
 * <p>
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


    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        final Set<Integer> valuesToDelete = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        final List<TreeNode> roots = new ArrayList<>();
        helper(
                root,
                true,
                roots,
                valuesToDelete
        );
        return roots;
    }

    private static TreeNode helper(
            final TreeNode currentNode,
            final boolean isRoot,
            final List<TreeNode> roots,
            final Set<Integer> valuesToDelete
    ) {
        if (null != currentNode) {
            final boolean shouldDeleteCurrentNode = valuesToDelete.contains(currentNode.val);

            if (isRoot && !shouldDeleteCurrentNode) {
                roots.add(currentNode);
            }

            currentNode.left = helper(currentNode.left, shouldDeleteCurrentNode, roots, valuesToDelete);
            currentNode.right = helper(currentNode.right, shouldDeleteCurrentNode, roots, valuesToDelete);

            if (!shouldDeleteCurrentNode) {
                return currentNode;
            }
        }

        return null;
    }
}
