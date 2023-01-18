package problems;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static problems.UniqueBinarySearchTrees2.TreeNode;

public class UniqueBinarySearchTrees2Test {
    @Test
    public void testWhenNIsOne() {
        assertEquals(
                Set.of(
                        new TreeNode(1)
                ),
                new HashSet<>(new UniqueBinarySearchTrees2().generateTrees(1))
        );
    }

    @Test
    public void testWhenNIsTwo() {
        assertEquals(
                Set.of(
                        new TreeNode(
                                1,
                                null,
                                new TreeNode(2)
                        ),
                        new TreeNode(
                                2,
                                new TreeNode(1),
                                null
                        )
                ),
                new HashSet<>(new UniqueBinarySearchTrees2().generateTrees(2))
        );
    }

    @Test
    public void testWhenNIsThree() {
        assertEquals(
                Set.of(
                        new TreeNode(
                                1,
                                null,
                                new TreeNode(
                                        2,
                                        null,
                                        new TreeNode(3)
                                )
                        ),
                        new TreeNode(
                                1,
                                null,
                                new TreeNode(
                                        3,
                                        new TreeNode(2),
                                        null
                                )
                        ),
                        new TreeNode(
                                2,
                                new TreeNode(1),
                                new TreeNode(3)
                        ),
                        new TreeNode(
                                3,
                                new TreeNode(
                                        2,
                                        new TreeNode(1),
                                        null
                                ),
                                null
                        ),
                        new TreeNode(
                                3,
                                new TreeNode(
                                        1,
                                        null,
                                        new TreeNode(2)
                                ),
                                null
                        )
                ),
                new HashSet<>(new UniqueBinarySearchTrees2().generateTrees(3))
        );
    }
}