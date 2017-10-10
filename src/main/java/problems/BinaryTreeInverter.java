package problems;

import data.TreeNode;

public class BinaryTreeInverter {
    public static void invert(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.getLeft();
        TreeNode right = root.getRight();

        root.setLeft(right);
        root.setRight(left);

        invert(right);
        invert(left);
    }
}
