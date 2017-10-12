package problems;

import data.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreesMergerTest {
    private final TreeNode tree1 = new TreeNode(1, null, null);

    @Test
    public void itShouldMergeBinaryTreesWithNullChildren() {
        TreeNode tree2Left = new TreeNode(2, null, null);
        TreeNode tree2Right = new TreeNode(3, null, null);
        TreeNode tree2 = new TreeNode(4, tree2Left, tree2Right);
        TreeNode mergedTreeLeft = new TreeNode(5, tree2Left, tree2Right);
        assertEquals(mergedTreeLeft, BinaryTreesMerger.merge(tree1, tree2));
    }

    @Test
    public void itShouldMergeTwoNullBinaryTrees() {
        assertEquals(null, BinaryTreesMerger.merge(null, null));
    }

    @Test
    public void itShouldMergeOnlyRightBinaryTree() {
        assertEquals(tree1, BinaryTreesMerger.merge(tree1, null));
    }

    @Test
    public void itShouldMergeOnlyLeftBinaryTree() {
        assertEquals(tree1, BinaryTreesMerger.merge(null, tree1));
    }
}