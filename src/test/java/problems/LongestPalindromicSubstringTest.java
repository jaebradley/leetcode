package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromicSubstringTest {
    private final LongestPalindromicSubstring problem = new LongestPalindromicSubstring();

    @Test
    public void identifiesAforA() {
        assertEquals("a", problem.longestPalindrome("a"));
    }

    @Test
    public void identifiesAforAB() {
        assertEquals("a", problem.longestPalindrome("ab"));
    }

    @Test
    public void identifiesABBAForABBA() {
        assertEquals("abba", problem.longestPalindrome("abba"));
    }

    @Test
    public void identifiesABAForABA() {
        assertEquals("aba", problem.longestPalindrome("aba"));
    }

    @Test
    public void identifiesAAForBAA() {
        assertEquals("aa", problem.longestPalindrome("baa"));
    }

    @Test
    public void identifiesAAForAAB() {
        assertEquals("aa", problem.longestPalindrome("aab"));
    }

    @Test
    public void identifiesBABForBAB() {
        assertEquals("bab", problem.longestPalindrome("bab"));
    }

    @Test
    public void identifiesBAABForBAABC() {
        assertEquals("baab", problem.longestPalindrome("bbaabc"));
    }
}