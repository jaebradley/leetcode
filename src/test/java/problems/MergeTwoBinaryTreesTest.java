package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.MergeTwoBinaryTrees.*;

public class MergeTwoBinaryTreesTest {
    @Test
    public void mergeComplete() {
        TreeNode merged = new MergeTwoBinaryTrees().mergeTrees(
                new TreeNode(
                        1,
                        new TreeNode(2),
                        new TreeNode(3)
                ),
                new TreeNode(
                        4,
                        new TreeNode(5),
                        new TreeNode(6)
                )
        );
        assertEquals(merged.val, 5);
        assertEquals(merged.left.val, 7);
        assertEquals(merged.right.val, 9);
    }

    @Test
    public void mergeIncompleteLeftChild() {
        TreeNode merged = new MergeTwoBinaryTrees().mergeTrees(
                new TreeNode(
                        1,
                        null,
                        new TreeNode(3)
                ),
                new TreeNode(
                        4,
                        new TreeNode(5),
                        new TreeNode(6)
                )
        );
        assertEquals(merged.val, 5);
        assertEquals(merged.left.val, 5);
        assertEquals(merged.right.val, 9);
    }

    @Test
    public void mergeIncompleteRightChild() {
        TreeNode merged = new MergeTwoBinaryTrees().mergeTrees(
                new TreeNode(
                        1,
                        new TreeNode(2),
                        new TreeNode(3)
                ),
                new TreeNode(
                        4,
                        new TreeNode(5),
                        null
                )
        );
        assertEquals(merged.val, 5);
        assertEquals(merged.left.val, 7);
        assertEquals(merged.right.val, 3);
    }

    @Test
    public void testMergeEmptyTrees() {
        assertEquals(
                null,
                new MergeTwoBinaryTrees().mergeTrees(null, null)
        );
    }
}
