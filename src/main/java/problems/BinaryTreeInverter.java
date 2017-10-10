package problems;

import data.TreeNode;

/**
 * Invert a binary tree (https://leetcode.com/problems/invert-binary-tree/description/)
 *
 * Essentially convert
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * to
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 **/



public class BinaryTreeInverter {
    public static TreeNode createInvertedTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        return new TreeNode(root.getValue(), createInvertedTree(root.getRight()), createInvertedTree(root.getLeft()));
    }
}
