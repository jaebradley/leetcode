package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.KthSmallestElementInBST.*;

public class KthSmallestElementInBSTTest {

    @Test
    public void returnSmallestElement() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(-1);
        TreeNode right = new TreeNode(1);

        root.left = left;
        root.right = right;

        assertEquals(-1, KthSmallestElementInBST.kthSmallestIterative(root, 1));
    }

    @Test
    public void returnSecondSmallestElement() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(-1);
        TreeNode right = new TreeNode(1);

        root.left = left;
        root.right = right;

        assertEquals(0, KthSmallestElementInBST.kthSmallestIterative(root, 2));
    }

    @Test
    public void returnThirdSmallestElement() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(-1);
        TreeNode right = new TreeNode(1);

        root.left = left;
        root.right = right;

        assertEquals(1, KthSmallestElementInBST.kthSmallestIterative(root, 3));
    }
}