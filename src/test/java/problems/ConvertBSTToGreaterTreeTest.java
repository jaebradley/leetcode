package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.ConvertBSTToGreaterTree.*;

public class ConvertBSTToGreaterTreeTest {

    @Test
    public void convertsSingleLevelBSTToGreaterTreeRecursively() {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(13);

        root.left = left;
        root.right = right;

        ConvertBSTToGreaterTree converter = new ConvertBSTToGreaterTree();

        converter.convertBSTRecursively(root);

        assertEquals(18, root.val);
        assertEquals(20, root.left.val);
        assertEquals(13, root.right.val);
    }

    @Test
    public void convertsSingleLevelBSTToGreaterTreeIteratively() {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(13);

        root.left = left;
        root.right = right;

        ConvertBSTToGreaterTree.convertBSTIteratively(root);

        assertEquals(18, root.val);
        assertEquals(20, root.left.val);
        assertEquals(13, root.right.val);
    }

    @Test
    public void convertsMultiLevelBSTToGreaterTreeRecursively() {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(13);
        TreeNode leftLeft = new TreeNode(1);
        TreeNode leftRight = new TreeNode(3);
        TreeNode rightRight = new TreeNode(14);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightLeftRight = new TreeNode(7);

        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.left = rightLeft;
        right.right = rightRight;
        rightLeft.right = rightLeftRight;

        ConvertBSTToGreaterTree converter = new ConvertBSTToGreaterTree();

        converter.convertBSTRecursively(root);

        assertEquals(45, root.val);
        assertEquals(50, root.left.val);
        assertEquals(51, root.left.left.val);
        assertEquals(48, root.left.right.val);
        assertEquals(27, root.right.val);
        assertEquals(40, root.right.left.val);
        assertEquals(14, root.right.right.val);
        assertEquals(34, root.right.left.right.val);
    }

    @Test
    public void convertsMultiLevelBSTToGreaterTreeIteratively() {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(13);
        TreeNode leftLeft = new TreeNode(1);
        TreeNode leftRight = new TreeNode(3);
        TreeNode rightRight = new TreeNode(14);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightLeftRight = new TreeNode(7);

        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.left = rightLeft;
        right.right = rightRight;
        rightLeft.right = rightLeftRight;

        ConvertBSTToGreaterTree.convertBSTIteratively(root);

        assertEquals(45, root.val);
        assertEquals(50, root.left.val);
        assertEquals(51, root.left.left.val);
        assertEquals(48, root.left.right.val);
        assertEquals(27, root.right.val);
        assertEquals(40, root.right.left.val);
        assertEquals(14, root.right.right.val);
        assertEquals(34, root.right.left.right.val);
    }
}