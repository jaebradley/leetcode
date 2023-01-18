package problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static problems.PreorderTraversal.*;

public class PreorderTraversalTest {
    @Test
    public void traverseRecursivelyWithOnlyRight() {
        TreeNode root = new TreeNode(1);
        TreeNode one1 = new TreeNode(2);
        TreeNode two2 = new TreeNode(3);

        root.right = one1;
        one1.left = two2;

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        assertEquals(expected, PreorderTraversal.preorderTraversalRecursively(root));
    }

    @Test
    public void traverseRecursivelyWithOnlyLeft() {
        TreeNode root = new TreeNode(1);
        TreeNode one1 = new TreeNode(2);
        TreeNode two2 = new TreeNode(3);

        root.left = one1;
        one1.left = two2;

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        assertEquals(expected, PreorderTraversal.preorderTraversalRecursively(root));
    }

    @Test
    public void traverseRecursivelyLeftAndRight() {
        TreeNode root = new TreeNode(1);
        TreeNode one0 = new TreeNode(2);
        TreeNode one1 = new TreeNode(3);
        TreeNode two0 = new TreeNode(4);
        TreeNode two1 = new TreeNode(5);
        TreeNode two2 = new TreeNode(6);
        TreeNode two3 = new TreeNode(7);

        root.left = one0;
        root.right = one1;
        one0.left = two0;
        one0.right = two1;
        one1.left = two2;
        one1.right = two3;

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
        expected.add(3);
        expected.add(6);
        expected.add(7);

        assertEquals(expected, PreorderTraversal.preorderTraversalRecursively(root));
    }

    @Test
    public void traverseIterativelyWithOnlyRight() {
        TreeNode root = new TreeNode(1);
        TreeNode one1 = new TreeNode(2);
        TreeNode two2 = new TreeNode(3);

        root.right = one1;
        one1.left = two2;

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        assertEquals(expected, PreorderTraversal.preorderTraversalIteratively(root));
    }

    @Test
    public void traverseIterativelyWithOnlyLeft() {
        TreeNode root = new TreeNode(1);
        TreeNode one1 = new TreeNode(2);
        TreeNode two2 = new TreeNode(3);

        root.left = one1;
        one1.left = two2;

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        assertEquals(expected, PreorderTraversal.preorderTraversalIteratively(root));
    }

    @Test
    public void traverseIterativelyLeftAndRight() {
        TreeNode root = new TreeNode(1);
        TreeNode one0 = new TreeNode(2);
        TreeNode one1 = new TreeNode(3);
        TreeNode two0 = new TreeNode(4);
        TreeNode two1 = new TreeNode(5);
        TreeNode two2 = new TreeNode(6);
        TreeNode two3 = new TreeNode(7);

        root.left = one0;
        root.right = one1;
        one0.left = two0;
        one0.right = two1;
        one1.left = two2;
        one1.right = two3;

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
        expected.add(3);
        expected.add(6);
        expected.add(7);

        assertEquals(expected, PreorderTraversal.preorderTraversalIteratively(root));
    }

}