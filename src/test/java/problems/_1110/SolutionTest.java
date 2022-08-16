package problems._1110;

import junit.framework.TestCase;

import java.util.List;

public class SolutionTest extends TestCase {
    public void test() {
        {
            final List<Solution.TreeNode> expectedRoots = List.of(
                    new Solution.TreeNode(
                            1,
                            new Solution.TreeNode(2, new Solution.TreeNode(4), null),
                            null
                    ),
                    new Solution.TreeNode(6),
                    new Solution.TreeNode(7)
            );
            final List<Solution.TreeNode> calculatedNodes = new Solution().delNodes(
                    new Solution.TreeNode(
                            1,
                            new Solution.TreeNode(
                                    2,
                                    new Solution.TreeNode(4),
                                    new Solution.TreeNode(5)
                            ),
                            new Solution.TreeNode(
                                    3,
                                    new Solution.TreeNode(6),
                                    new Solution.TreeNode(7)
                            )
                    ),
                    new int[]{3, 5}
            );
            assertTrue(expectedRoots.containsAll(calculatedNodes));
            assertTrue(calculatedNodes.containsAll(expectedRoots));
        }

        {

            final List<Solution.TreeNode> expectedNodes = List.of(
                    new Solution.TreeNode(
                            1,
                            new Solution.TreeNode(2),
                            new Solution.TreeNode(4)
                    )
            );
            final List<Solution.TreeNode> calculatedNodes = new Solution().delNodes(
                    new Solution.TreeNode(
                            1,
                            new Solution.TreeNode(2, null, new Solution.TreeNode(3)),
                            new Solution.TreeNode(4)
                    ),
                    new int[]{3}
            );
            assertTrue(expectedNodes.containsAll(calculatedNodes));
            assertTrue(calculatedNodes.containsAll(expectedNodes));
        }

    }
}