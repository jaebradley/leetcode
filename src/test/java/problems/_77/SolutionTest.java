package problems._77;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void test() {
        {
            final List<List<Integer>> expected = List.of(
                    List.of(2, 4),
                    List.of(3, 4),
                    List.of(2, 3),
                    List.of(1, 2),
                    List.of(1, 3),
                    List.of(1, 4)
            );
            final List<List<Integer>> calculated = new Solution().combine(4, 2);
            Assert.assertTrue(expected.containsAll(calculated));
            Assert.assertTrue(calculated.containsAll(expected));
        }
    }
}