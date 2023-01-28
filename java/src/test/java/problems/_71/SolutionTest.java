package problems._71;

import junit.framework.TestCase;

import java.util.Map;

public class SolutionTest extends TestCase {
    public void test() {
        Map.of(
                "/home",
                "/home/",
                "/",
                "/../",
                "/home/foo",
                "/home//foo/",
                "/TJbrd/owxdG",
                "///TJbrd/owxdG//"
        ).forEach((expected, input) -> assertEquals(expected, new Solution().simplifyPath(input)));
    }
}