package problems._47;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class SolutionTest {
    @Test
    public void test() {
        {
            final List<List<Integer>> expected = List.of(
                    List.of(1, 2, 3),
                    List.of(1, 3, 2),
                    List.of(2, 1, 3),
                    List.of(2, 3, 1),
                    List.of(3, 1, 2),
                    List.of(3, 2, 1)
            );
            final List<List<Integer>> calculated = new Solution().permuteUnique(new int[]{1, 2, 3});
            Assert.assertTrue(expected.containsAll(calculated));
            Assert.assertTrue(calculated.containsAll(expected));
            Assert.assertEquals(expected.size(), calculated.size());
        }

        {
            final List<List<Integer>> expected = List.of(
                    List.of(1, 1, 2),
                    List.of(1, 2, 1),
                    List.of(2, 1, 1)
            );
            final List<List<Integer>> calculated = new Solution().permuteUnique(new int[]{1, 1, 2});
            Assert.assertTrue(expected.containsAll(calculated));
            Assert.assertTrue(calculated.containsAll(expected));
            Assert.assertEquals(expected.size(), calculated.size());
        }

        Assert.assertEquals(Collections.emptyList(), new Solution().permuteUnique(new int[]{}));
    }
}