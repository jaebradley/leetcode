package problems;

import org.junit.Test;
import problems.BinaryTreePaths.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreePathsTest {

    @Test
    public void getPathsForSingleLeavesOnEitherSide() {
        TreeNode two1 = new TreeNode(5);
        TreeNode one0 = new TreeNode(2);
        TreeNode one1 = new TreeNode(3);
        TreeNode root = new TreeNode(1);

        root.left = one0;
        root.right = one1;
        one0.right = two1;

        List<String> paths = new ArrayList<>();
        paths.add("1->2->5");
        paths.add("1->3");
        assertEquals(paths, BinaryTreePaths.binaryTreePaths(root));
    }

    @Test
    public void getPathsForDoubleLeavesOnEitherSide() {
        TreeNode two0 = new TreeNode(4);
        TreeNode two1 = new TreeNode(5);
        TreeNode two2 = new TreeNode(6);
        TreeNode two3 = new TreeNode(7);
        TreeNode one0 = new TreeNode(2);
        TreeNode one1 = new TreeNode(3);
        TreeNode root = new TreeNode(1);

        root.left = one0;
        root.right = one1;
        one0.left = two0;
        one0.right = two1;
        one1.left = two2;
        one1.right = two3;

        List<String> paths = new ArrayList<>();
        paths.add("1->2->4");
        paths.add("1->2->5");
        paths.add("1->3->6");
        paths.add("1->3->7");
        assertEquals(paths, BinaryTreePaths.binaryTreePaths(root));
    }
}