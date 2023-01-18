package problems._2192;

import junit.framework.TestCase;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                Stream.of(
                        Collections.emptyList(),
                        Collections.emptyList(),
                        Collections.emptyList(),
                        List.of(0, 1),
                        List.of(0, 2),
                        List.of(0, 1, 3),
                        List.of(0, 1, 2, 3, 4),
                        List.of(0, 1, 2, 3)
                ).collect(Collectors.toList()),
                new Solution().getAncestors(
                        8,
                        new int[][]{
                                new int[]{0, 3},
                                new int[]{0, 4},
                                new int[]{1, 3},
                                new int[]{2, 4},
                                new int[]{2, 7},
                                new int[]{3, 5},
                                new int[]{3, 6},
                                new int[]{3, 7},
                                new int[]{4, 6}
                        }
                )
        );
    }
}