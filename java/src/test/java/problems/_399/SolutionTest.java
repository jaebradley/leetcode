package problems._399;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void test() {
        Assert.assertArrayEquals(
                new double[]{
                        6.0,
                        0.5,
                        -1.0,
                        1.0,
                        -1.0
                },
                new Solution().calcEquation(
                        List.of(
                                List.of("a", "b"),
                                List.of("b", "c")
                        ),
                        new double[]{2.0, 3.0},
                        List.of(
                                List.of("a", "c"),
                                List.of("b", "a"),
                                List.of("a", "e"),
                                List.of("a", "a"),
                                List.of("x", "x")
                        )
                ),
                0.25
        );
    }
}