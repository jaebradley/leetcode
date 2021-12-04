package problems._1022;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(0, new Solution().sumRootToLeaf(null));
        assertEquals(1, new Solution().sumRootToLeaf(new Solution.TreeNode(1)));
        assertEquals(0, new Solution().sumRootToLeaf(new Solution.TreeNode(0)));

        assertEquals(
                22,
                new Solution()
                        .sumRootToLeaf(
                                new Solution.TreeNode(
                                        1,
                                        new Solution.TreeNode(
                                                0,
                                                new Solution.TreeNode(0),
                                                new Solution.TreeNode(1)
                                        ),
                                        new Solution.TreeNode(
                                                1,
                                                new Solution.TreeNode(0),
                                                new Solution.TreeNode(1)
                                        )
                                )
                        )
        );
    }
}