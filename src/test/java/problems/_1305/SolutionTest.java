package problems._1305;

import junit.framework.TestCase;

import java.util.List;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                List.of(0, 1, 1, 2, 3, 4),
                new Solution().getAllElements(
                        new Solution.TreeNode(2, new Solution.TreeNode(1), new Solution.TreeNode(4)),
                        new Solution.TreeNode(1, new Solution.TreeNode(0), new Solution.TreeNode(3))
                )
        );

        assertEquals(
                List.of(1, 1, 8, 8),
                new Solution().getAllElements(
                        new Solution.TreeNode(1, null, new Solution.TreeNode(8)),
                        new Solution.TreeNode(8, new Solution.TreeNode(1), null)
                )
        );
    }
}