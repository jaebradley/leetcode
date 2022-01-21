package problems._241;

import junit.framework.TestCase;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SolutionTest extends TestCase {

    public void test() {
        {
            assertEquals(
                    Map.of(
                            0, 1,
                            2, 1
                    ),
                    new Solution().diffWaysToCompute("2-1-1")
                            .stream()
                            .collect(
                                    Collectors.toMap(
                                            Function.identity(),
                                            v -> 1,
                                            Math::addExact
                                    )
                            )
            );
        }

        {
            assertEquals(
                    Map.of(
                            -34, 1,

                            -14, 1,
                            -10, 2,
                            10, 1
                    ),
                    new Solution().diffWaysToCompute("2*3-4*5")
                            .stream()
                            .collect(
                                    Collectors.toMap(
                                            Function.identity(),
                                            v -> 1,
                                            Math::addExact
                                    )
                            )
            );
        }
    }
}