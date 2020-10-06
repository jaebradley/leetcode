package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonSubsequenceTest {

    @Test
    public void testTwoIdenticalStringsReturnLength() {
        assertEquals(
                4,
                new LongestCommonSubsequence().longestCommonSubsequence("fuck", "fuck")
        );
    }

    @Test
    public void testLeadingSubstringReturnsLengthOfSubstring() {
        assertEquals(
                4,
                new LongestCommonSubsequence().longestCommonSubsequence("fuck", "fuckall")
        );
    }

    @Test
    public void testSharedLeadingSubstringReturnsLengthOfSubstring() {
        assertEquals(
                4,
                new LongestCommonSubsequence().longestCommonSubsequence("fuckaduck", "fuckzyx")
        );

    }

    @Test
    public void testBoundedSubstringReturnsLengthOfSubstring() {
        assertEquals(
                4,
                new LongestCommonSubsequence().longestCommonSubsequence("abcfuckdef", "zyxwvfuckutsrq")
        );
    }

    @Test
    public void testEndingSubstringReturnsLengthOfSubstring() {
        assertEquals(
                4,
                new LongestCommonSubsequence().longestCommonSubsequence("fuck", "zyxfuck")
        );
    }

    @Test
    public void testSharedEndingSubstringReturnsLengthOfSubstring() {
        assertEquals(
                4,
                new LongestCommonSubsequence().longestCommonSubsequence("abcfuck", "zyxfuck")
        );
    }

    @Test
    public void testMissingCharactersInSharedSubsequence() {
        assertEquals(
                3,
                new LongestCommonSubsequence().longestCommonSubsequence("fuck", "fck")
        );
    }
}