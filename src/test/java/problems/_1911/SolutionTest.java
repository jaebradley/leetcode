package problems._1911;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                7,
                new Solution().maxAlternatingSum(new int[]{4, 2, 5, 3})
        );

        assertEquals(
                8,
                new Solution().maxAlternatingSum(new int[]{5, 6, 7, 8})
        );

        assertEquals(
                10,
                new Solution().maxAlternatingSum(new int[]{6, 2, 1, 2, 4, 5})
        );

        assertEquals(
                1,
                new Solution().maxAlternatingSum(new int[]{374,126,84,237,195,139,328,353,286,113,351,167,394,398,29,118,17,162,206,138,34,109,291,368,162,109,336,256,203,330,235,74,136,72,127,382,288,276,135,383,300,220,299,205,186,113,71,261,253,47,387,25,57,79,322,82,349,217,306,33,198,196,306,240,271,129,284,6,349,370,59,350,275,385,137,394,329,175,58,151,223,81,233,2,370,369,135,257,391,92,260,55,321,153,328,260,312,102,79,192})
        );
    }
}