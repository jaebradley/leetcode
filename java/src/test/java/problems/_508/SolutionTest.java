package problems._508;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                Set.of(2, -3, 4),
                Arrays.stream(
                        new Solution().findFrequentTreeSum(
                                new Solution.TreeNode(
                                        5,
                                        new Solution.TreeNode(2),
                                        new Solution.TreeNode(-3)
                                )
                        )
                ).boxed().collect(Collectors.toSet())
        );

        assertEquals(
                Set.of(2),
                Arrays.stream(
                        new Solution().findFrequentTreeSum(
                                new Solution.TreeNode(
                                        5,
                                        new Solution.TreeNode(2),
                                        new Solution.TreeNode(-5)
                                )
                        )
                ).boxed().collect(Collectors.toSet())
        );
    }
}