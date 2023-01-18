package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.TrimABinarySearchTree.*;

public class TrimABinarySearchTreeTest {
    @Test
    public void testEmptyTree() {
        assertNull(new TrimABinarySearchTree().trimBST(null, 0, 10));
    }

    @Test
    public void testOneLevelTreeWithinRange() {
        TreeNode trimmedRoot = new TrimABinarySearchTree().trimBST(
                new TreeNode(5,null,null),
                0,
                10
        );
        assertEquals(5, trimmedRoot.val);
        assertNull(trimmedRoot.left);
        assertNull(trimmedRoot.right);
    }

    @Test
    public void testOneLevelTreeThatIsSmallerThanFloor() {
        TreeNode trimmedRoot = new TrimABinarySearchTree().trimBST(
                new TreeNode(0,null,null),
                5,
                10
        );
        assertNull(trimmedRoot);
    }

    @Test
    public void testOneLevelTreeThatIsLargerThanFloor() {
        TreeNode trimmedRoot = new TrimABinarySearchTree().trimBST(
                new TreeNode(20,null,null),
                5,
                10
        );
        assertNull(trimmedRoot);
    }

    @Test
    public void testThreeFourLevelExampleWhereLeftSubtreeHasARightSubtreeInRange() {
        TreeNode trimmedRoot = new TrimABinarySearchTree().trimBST(
                new TreeNode(
                        5,
                        new TreeNode(
                                0,
                                null,
                                new TreeNode(
                                        2,
                                        new TreeNode(1, null, null),
                                        null
                                )
                        ),
                        new TreeNode(10, null, null)
                    ),
                1,
                5
        );
        assertEquals(5, trimmedRoot.val);
        assertEquals(2, trimmedRoot.left.val);
        assertNull(trimmedRoot.left.right);
        assertEquals(1, trimmedRoot.left.left.val);
        assertNull(trimmedRoot.right);
    }
}