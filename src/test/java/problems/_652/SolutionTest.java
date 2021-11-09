package problems._652;

import data.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void test() {

        final List<TreeNode> expected = List.of(
                new TreeNode(
                        2,
                        new TreeNode(4),
                        null
                ),
                new TreeNode(4)
        );

        final List<TreeNode> calculated = new Solution().findDuplicateSubtrees(
                new TreeNode(
                        1,
                        new TreeNode(
                                2,
                                new TreeNode(4),
                                null
                        ),
                        new TreeNode(
                                3,
                                new TreeNode(
                                        2,
                                        new TreeNode(4),
                                        null
                                ),
                                new TreeNode(4)
                        )
                )
        );
        Assert.assertEquals(
                expected.size(),
                calculated.size()
        );
        Assert.assertTrue(
                expected.containsAll(calculated)
        );
        Assert.assertTrue(
                calculated.containsAll(expected)
        );

        Assert.assertEquals(
                List.of(
                        new TreeNode(1)
                ),
                new Solution().findDuplicateSubtrees(
                        new TreeNode(
                                22,
                                new TreeNode(1),
                                new TreeNode(1)
                        )
                )
        );
    }
}