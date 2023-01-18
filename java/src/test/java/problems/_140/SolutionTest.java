package problems._140;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void test() {
        {
            final List<String> expected = List.of(
                    "cats and dog",
                    "cat sand dog"
            );
            final List<String> computed = new Solution().wordBreak(
                    "catsanddog",
                    List.of("cat","cats","and","sand","dog")
            );

            assertTrue(expected.containsAll(computed));
            assertTrue(computed.containsAll(expected));
        }
        {
            final List<String> expected = List.of(
                    "pine apple pen apple",
                    "pineapple pen apple",
                    "pine applepen apple"
            );
            final List<String> computed = new Solution().wordBreak(
                    "pineapplepenapple",
                    List.of("apple","pen","applepen","pine","pineapple")
            );

            assertTrue(expected.containsAll(computed));
            assertTrue(computed.containsAll(expected));
        }

        {
            assertTrue(
                    new Solution().wordBreak(
                            "foobar",
                            List.of("baz")
                    ).isEmpty()
            );
        }
    }
}