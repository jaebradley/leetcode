package problems._93;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        {
            final List<String> expected = List.of(
                    "255.255.11.135",
                    "255.255.111.35"
            );
            final List<String> computed = new Solution().restoreIpAddresses("25525511135");
            assertTrue(expected.containsAll(computed));
            assertTrue(computed.containsAll(expected));
        }
        {
            final List<String> expected = List.of(
                    "0.0.0.0"
            );
            final List<String> computed = new Solution().restoreIpAddresses("0000");
            assertTrue(expected.containsAll(computed));
            assertTrue(computed.containsAll(expected));
        }
        {
            final List<String> expected = List.of(
                    "1.1.1.1"
            );
            final List<String> computed = new Solution().restoreIpAddresses("1111");
            assertTrue(expected.containsAll(computed));
            assertTrue(computed.containsAll(expected));
        }
        {
            final List<String> expected = List.of(
                    "1.0.10.23",
                    "1.0.102.3",
                    "10.1.0.23",
                    "10.10.2.3",
                    "101.0.2.3"
            );
            final List<String> computed = new Solution().restoreIpAddresses("101023");
            assertTrue(expected.containsAll(computed));
            assertTrue(computed.containsAll(expected));
        }
    }
}