package problems;

import org.junit.Test;
import problems.BSTIterator.TreeNode;

import static org.junit.Assert.*;

public class BSTIteratorTest {

    @Test
    public void testThreeLevelLeftTree() {
        TreeNode root = new TreeNode(
                3,
                new TreeNode(
                        2,
                        new TreeNode(
                                1,
                                null,
                                null
                        ),
                        null
                ),
                null
        );
        BSTIterator iterator = new BSTIterator(root);
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
    }

    @Test
    public void testThreeLevelRightTree() {
        TreeNode root = new TreeNode(
                1,
                null,
                new TreeNode(
                        2,
                        null,
                        new TreeNode(
                                3,
                                null,
                                null
                        )
                )
        );
        BSTIterator iterator = new BSTIterator(root);
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
    }

    @Test
    public void testFullThreeLevelTree() {
        TreeNode root = new TreeNode(
                7,
                new TreeNode(
                        3,
                        new TreeNode(
                                1,
                                null,
                                null
                        ),
                        new TreeNode(
                                4,
                                null,
                                null
                        )
                ),
                new TreeNode(
                        10,
                        new TreeNode(
                                8,
                                null,
                                null
                        ),
                        new TreeNode(
                                11,
                                null,
                                null
                        )
                )
        );
        BSTIterator iterator = new BSTIterator(root);
        assertEquals(1, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(4, iterator.next());
        assertEquals(7, iterator.next());
        assertEquals(8, iterator.next());
        assertEquals(10, iterator.next());
        assertEquals(11, iterator.next());
    }
}
