package data;

import java.util.Objects;

public class TreeNode {
    private final int value;
    private final TreeNode left;
    private final TreeNode right;

    public TreeNode(final int value, final TreeNode left, final TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        TreeNode treeNode = (TreeNode) obj;

        return Objects.equals(value, treeNode.value)
                && Objects.equals(left, treeNode.left)
                && Objects.equals(right, treeNode.right);
    }
}
