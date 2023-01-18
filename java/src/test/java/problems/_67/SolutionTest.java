package problems._67;

import junit.framework.TestCase;

import java.util.Map;

public class SolutionTest extends TestCase {

    public void test() {
        Map.of(
                        Map.entry("11", "1"),
                        "100",
                        Map.entry("1010", "1011"),
                        "10101",
                        Map.entry("1111", "1111"),
                        "11110"

                )
                .forEach((key, value) -> assertEquals(
                        value,
                        new Solution().addBinary(key.getKey(), key.getValue())
                ));
    }
}