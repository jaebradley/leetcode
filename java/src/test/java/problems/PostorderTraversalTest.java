package problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static problems.PostorderTraversal.*;

public class PostorderTraversalTest {

    @Test
    public void recursivelyTraverseLeftOnly() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);

        root.left = left;

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(0);

        assertEquals(expected, PostorderTraversal.postorderTraversalRecursively(root));
    }

    @Test
    public void iterativelyTraverseLeftOnly() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);

        root.left = left;

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(0);

        assertEquals(expected, PostorderTraversal.postOrderTraversalIteratively(root));
    }

    @Test
    public void recursivelyTraverseRightOnly() {
        TreeNode root = new TreeNode(0);
        TreeNode right = new TreeNode(1);

        root.right = right;

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(0);

        assertEquals(expected, PostorderTraversal.postorderTraversalRecursively(root));
    }

    @Test
    public void iterativelyTraverseRightOnly() {
        TreeNode root = new TreeNode(0);
        TreeNode right = new TreeNode(1);

        root.right = right;

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(0);

        assertEquals(expected, PostorderTraversal.postOrderTraversalIteratively(root));
    }

    @Test
    public void recursivelyTraverseLeftAndRight() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);

        root.left = left;
        root.right = right;

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(0);

        assertEquals(expected, PostorderTraversal.postorderTraversalRecursively(root));
    }

    @Test
    public void iterativelyTraverseLeftAndRight() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);

        root.left = left;
        root.right = right;

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(0);

        assertEquals(expected, PostorderTraversal.postOrderTraversalIteratively(root));
    }

    @Test
    public void iterativelyTraverseEmptyTree() {
        assertEquals(new ArrayList<Integer>(), PostorderTraversal.postOrderTraversalIteratively(null));
    }
}