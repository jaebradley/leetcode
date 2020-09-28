package problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BinaryTreeZigZagLevelOrderTraversalTest {
    @Test
    public void testThreeLevelsWithSingleRightChild() {
        TreeNode root = new TreeNode(
                3,
                new TreeNode(
                        9
                ),
                new TreeNode(
                        20,
                        new TreeNode(
                                15
                        ),
                        new TreeNode(
                                7
                        )
                )
        );
        assertEquals(
                List.of(List.of(3), List.of(20, 9), List.of(15, 7)),
                new BinaryTreeZigZagLevelOrderTraversal().zigzagLevelOrder(root)
        );
    }

    @Test
    public void testNullRootReturnsEmptyList() {
        assertEquals(new ArrayList<>(), new BinaryTreeZigZagLevelOrderTraversal().zigzagLevelOrder(null));
    }

    @Test
    public void testFullThreeLevels() {
        TreeNode root = new TreeNode(
                3,
                new TreeNode(
                        9,
                        new TreeNode(10),
                        new TreeNode(13)
                ),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );
        assertEquals(
                List.of(List.of(3), List.of(20, 9), List.of(10, 13, 15, 7)),
                new BinaryTreeZigZagLevelOrderTraversal().zigzagLevelOrder(root)
        );
    }

    @Test
    public void testThreeLevelLeftChildren() {
        TreeNode root = new TreeNode(
                3,
                new TreeNode(
                        9,
                        new TreeNode(10),
                        new TreeNode(13)
                ),
                new TreeNode(20)
        );
        assertEquals(
                List.of(List.of(3), List.of(20, 9), List.of(10, 13)),
                new BinaryTreeZigZagLevelOrderTraversal().zigzagLevelOrder(root)
        );
    }
}
