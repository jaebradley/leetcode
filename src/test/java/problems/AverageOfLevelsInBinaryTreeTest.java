package problems;

import org.junit.Test;
import problems.AverageOfLevelsInBinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AverageOfLevelsInBinaryTreeTest {

    @Test
    public void testEmptyTree() {
        assertEquals(
                new ArrayList<>(),
                new AverageOfLevelsInBinaryTree().averageOfLevels(null)
        );
    }

    @Test
    public void testSingleNodeTree() {
        assertEquals(
                List.of(Integer.valueOf(1).doubleValue()),
                new AverageOfLevelsInBinaryTree().averageOfLevels(new TreeNode(1, null, null))
        );
    }

    @Test
    public void testSingleLeftChildTree() {
        assertEquals(
                List.of(Integer.valueOf(1).doubleValue(), Integer.valueOf(2).doubleValue()),
                new AverageOfLevelsInBinaryTree().averageOfLevels(
                        new TreeNode(
                                1,
                                new TreeNode(2, null, null),
                                null
                        )
                )
        );
    }

    @Test
    public void testSingleRightChildTree() {
        assertEquals(
                List.of(Integer.valueOf(1).doubleValue(), Integer.valueOf(2).doubleValue()),
                new AverageOfLevelsInBinaryTree().averageOfLevels(
                        new TreeNode(
                                1,
                                null,
                                new TreeNode(2, null, null)
                        )
                )
        );
    }

    @Test
    public void testCompleteTwoLevelTree() {
        assertEquals(
                List.of(Integer.valueOf(1).doubleValue(), 2.5),
                new AverageOfLevelsInBinaryTree().averageOfLevels(
                        new TreeNode(
                                1,
                                new TreeNode(2, null, null),
                                new TreeNode(3, null, null)
                        )
                )
        );
    }
}