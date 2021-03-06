package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.SubtreeOfAnotherTree.*;

public class SubtreeOfAnotherTreeTest {

    @Test
    public void isASubtree() {
        TreeNode thirdLeft = new TreeNode(1);
        TreeNode thirdRight = new TreeNode(2);

        TreeNode secondLeft = new TreeNode(4);
        secondLeft.left = thirdLeft;
        secondLeft.right = thirdRight;

        TreeNode secondRight = new TreeNode(5);
        TreeNode root = new TreeNode(3);
        root.left = secondLeft;
        root.right = secondRight;

        TreeNode subtreeLeft = new TreeNode(1);
        TreeNode subtreeRight = new TreeNode(2);

        TreeNode subtreeRoot = new TreeNode(4);
        subtreeRoot.left = subtreeLeft;
        subtreeRoot.right = subtreeRight;

        assertTrue(SubtreeOfAnotherTree.isSubtree(root, subtreeRoot));
    }

    @Test
    public void isNotASubtree() {
        TreeNode fourthLeft = new TreeNode(0);

        TreeNode thirdLeft = new TreeNode(1);
        TreeNode thirdRight = new TreeNode(2);
        thirdLeft.left = fourthLeft;

        TreeNode secondLeft = new TreeNode(4);
        secondLeft.left = thirdLeft;
        secondLeft.right = thirdRight;

        TreeNode secondRight = new TreeNode(5);
        TreeNode root = new TreeNode(3);
        root.left = secondLeft;
        root.right = secondRight;

        TreeNode subtreeLeft = new TreeNode(1);
        TreeNode subtreeRight = new TreeNode(2);

        TreeNode subtreeRoot = new TreeNode(4);
        subtreeRoot.left = subtreeLeft;
        subtreeRoot.right = subtreeRight;

        assertFalse(SubtreeOfAnotherTree.isSubtree(root, subtreeRoot));
    }

    @Test
    public void identicalTreeIsASubtree() {
        TreeNode secondLeft = new TreeNode(1);
        TreeNode secondRight = new TreeNode(2);

        TreeNode root = new TreeNode(4);
        root.left = secondLeft;
        root.right = secondRight;

        TreeNode subtreeLeft = new TreeNode(1);
        TreeNode subtreeRight = new TreeNode(2);

        TreeNode subtreeRoot = new TreeNode(4);
        subtreeRoot.left = subtreeLeft;
        subtreeRoot.right = subtreeRight;

        assertTrue(SubtreeOfAnotherTree.isSubtree(root, subtreeRoot));
    }
}