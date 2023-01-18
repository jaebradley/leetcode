package problems._191;

import junit.framework.TestCase;

import java.util.Map;
import java.util.stream.Stream;

public class SolutionTest extends TestCase {

    public void test() {
        Stream.of(
                Map.entry(0, 0),
                Map.entry(-3, 31),
                Map.entry(1, 1),
                Map.entry(2, 1),
                Map.entry(3, 2),
                Map.entry(4, 1)
        )
                .forEach(
                        e -> assertEquals(
                                (int) e.getValue(),
                                (int) new Solution().hammingWeight(e.getKey())
                        )
                );
    }
}