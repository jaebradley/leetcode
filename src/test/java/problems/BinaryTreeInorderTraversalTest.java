package problems;

import org.junit.Test;
import problems.BinaryTreeInorderTraversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeInorderTraversalTest {
    @Test
    public void testCompleteThreeLevelTree() {
        assertEquals(
                List.of(4, 2, 5, 1, 6, 3, 7),
                new BinaryTreeInorderTraversal().inorderTraversal(
                        new TreeNode(
                                1,
                                new TreeNode(
                                        2,
                                        new TreeNode(4),
                                        new TreeNode(5)
                                ),
                                new TreeNode(
                                        3,
                                        new TreeNode(6),
                                        new TreeNode(7)
                                )
                        )
                )
        );
    }

    @Test
    public void testEmptyTree() {
        assertEquals(
                new ArrayList<Integer>(),
                new BinaryTreeInorderTraversal().inorderTraversal(null)
        );
    }

    @Test
    public void testSingleValueTree() {
        assertEquals(
                List.of(1),
                new BinaryTreeInorderTraversal().inorderTraversal(new TreeNode(1))
        );
    }

    @Test
    public void testSingleLeftChildTree() {
        assertEquals(
                List.of(2, 1),
                new BinaryTreeInorderTraversal().inorderTraversal(new TreeNode(1, new TreeNode(2), null))
        );
    }

    @Test
    public void testSingleRightChildTree() {
        assertEquals(
                List.of(1, 2),
                new BinaryTreeInorderTraversal().inorderTraversal(new TreeNode(1, null, new TreeNode(2)))
        );
    }
}
