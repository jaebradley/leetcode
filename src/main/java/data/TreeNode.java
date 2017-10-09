package data;

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
}
