package problems._589;

import junit.framework.TestCase;

import java.util.Collections;
import java.util.List;

public class SolutionTest extends TestCase {

    public void test() {
        {
            final List<Integer> expected = List.of(1, 3, 5, 6, 2, 4);
            final List<Integer> calculated = new Solution().preorder(
                    new Solution.Node(
                            1,
                            List.of(
                                    new Solution.Node(
                                            3,
                                            List.of(
                                                    new Solution.Node(
                                                            5,
                                                            Collections.emptyList()
                                                    ),
                                                    new Solution.Node(
                                                            6,
                                                            Collections.emptyList()
                                                    )
                                            )
                                    ),
                                    new Solution.Node(2, Collections.emptyList()),
                                    new Solution.Node(4, Collections.emptyList())
                            )
                    )
            );

            assertEquals(
                    expected,
                    calculated
            );
        }
    }
}