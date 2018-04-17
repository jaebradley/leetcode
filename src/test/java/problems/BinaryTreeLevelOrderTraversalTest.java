package problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static problems.BinaryTreeLevelOrderTraversal.*;

public class BinaryTreeLevelOrderTraversalTest {

    @Test
    public void emptyTreeShouldBeEmptyListOfLists() {
        List<List<Integer>> expected = new ArrayList<>();
        assertEquals(expected, levelOrder(null));
    }

    @Test
    public void singleValueTreeShouldBeSingleValueListOfLists() {
        TreeNode root = new TreeNode(0);

        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> first = new ArrayList<>();

        first.add(0);
        expected.add(first);

        assertEquals(expected, levelOrder(root));
    }

    @Test
    public void multiLevelBalancedTreeShouldBeMultipleListsOfLists() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(4);
        TreeNode rightLeft = new TreeNode(5);
        TreeNode rightRight = new TreeNode(6);

        root.left = left;
        root.right = right;
        right.left = rightLeft;
        right.right = rightRight;
        left.left = leftLeft;
        left.right = leftRight;

        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> third = new ArrayList<>();

        first.add(0);
        second.add(1);
        second.add(2);
        third.add(3);
        third.add(4);
        third.add(5);
        third.add(6);

        expected.add(first);
        expected.add(second);
        expected.add(third);
        assertEquals(expected, levelOrder(root));
    }

    @Test
    public void unbalancedTreeShouldBeMultipleListsOfLists() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(4);

        root.left = left;
        left.left = leftLeft;
        left.right = leftRight;

        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> third = new ArrayList<>();

        first.add(0);
        second.add(1);
        third.add(3);
        third.add(4);

        expected.add(first);
        expected.add(second);
        expected.add(third);
        assertEquals(expected, levelOrder(root));
    }
}