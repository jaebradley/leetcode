package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.PathSum3.*;

public class PathSum3Test {

    @Test
    public void shouldReturn3() {
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(-3);
        TreeNode leftRight = new TreeNode(2);
        TreeNode leftRightRight = new TreeNode(1);
        TreeNode leftLeft = new TreeNode(3);
        TreeNode rightRight = new TreeNode(11);

        root.left = left;
        root.right = right;
        root.left.left = leftLeft;
        root.left.right = leftRight;
        root.left.right.right = leftRightRight;
        root.right.right = rightRight;

        assertEquals(3, PathSum3.pathSum(root, 8));
    }
}