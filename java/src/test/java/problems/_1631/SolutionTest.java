package problems._1631;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void test() {
        Assert.assertEquals(
                2,
                new Solution().minimumEffortPath(
                        new int[][]{
                                new int[]{1, 2, 2},
                                new int[]{3, 8, 2},
                                new int[]{5, 3, 5}
                        }
                )
        );
    }
}