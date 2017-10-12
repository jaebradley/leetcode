package problems;

import data.TreeNode;

/**
 * Merge Two Binary Trees (https://leetcode.com/problems/merge-two-binary-trees/description/)
 *
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree.
 * The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 */

public class BinaryTreesMerger {
    public static TreeNode merge(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 != null) {
            return tree2;
        }

        else if (tree1 != null && tree2 == null) {
            return tree1;
        }

        else if (tree1 == null) {
            return null;
        }

        return new TreeNode(tree1.getValue() + tree2.getValue(),
                merge(tree1.getLeft(), tree2.getLeft()),
                merge(tree1.getRight(), tree2.getRight())
        );
    }
}
