package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.HouseRobberThree.*;

public class HouseRobberThreeTest {

    @Test
    public void threeLevelRobberyShouldBe7() {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftRight = new TreeNode(3);
        TreeNode rightRight = new TreeNode(1);

        root.left = left;
        root.right = right;
        right.right = rightRight;
        left.right = leftRight;

        assertEquals(7, rob(root));
    }

    @Test
    public void emptyTreeShouldBe0() {
        assertEquals(0, rob(null));
    }

    @Test
    public void simpleTreeShouldBeChildren() {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;

        assertEquals(5, rob(root));
    }

    @Test
    public void simpleTreeShouldBeRootValue() {
        TreeNode root = new TreeNode(6);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;

        assertEquals(6, rob(root));
    }
}