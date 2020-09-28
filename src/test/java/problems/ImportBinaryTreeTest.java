package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.ImportBinaryTree.*;

public class ImportBinaryTreeTest {
    @Test
    public void invertCompleteThreeLevelTree() {
        TreeNode invertedTree = new ImportBinaryTree().invertTree(
                new TreeNode(
                        1,
                        new TreeNode(
                                2,
                                new TreeNode(3),
                                new TreeNode(4)
                        ),
                        new TreeNode(
                                5,
                                new TreeNode(6),
                                new TreeNode(7)
                        )
                )
        );

        assertEquals(invertedTree.val, 1);
        assertEquals(invertedTree.left.val, 5);
        assertEquals(invertedTree.right.val, 2);
        assertEquals(invertedTree.left.left.val, 7);
        assertEquals(invertedTree.left.right.val, 6);
        assertEquals(invertedTree.right.left.val, 4);
        assertEquals(invertedTree.right.right.val, 3);
    }

    @Test
    public void invertIncompleteLeftChildTree() {
        TreeNode invertedTree = new ImportBinaryTree().invertTree(
                new TreeNode(
                        1,
                        null,
                        new TreeNode(
                                5,
                                new TreeNode(6),
                                new TreeNode(7)
                        )
                )
        );

        assertEquals(invertedTree.val, 1);
        assertEquals(invertedTree.left.val, 5);
        assertEquals(invertedTree.right, null);
        assertEquals(invertedTree.left.left.val, 7);
        assertEquals(invertedTree.left.right.val, 6);
    }
}
