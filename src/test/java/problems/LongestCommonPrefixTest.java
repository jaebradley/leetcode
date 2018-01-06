package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonPrefixTest {
    @Test
    public void itShouldReturnPrefixesWhereFirstIsSubstring() {
        String[] values = new String[] { "a", "ab", "abc" };
        assertEquals("a", LongestCommonPrefix.longestCommonPrefix(values));
    }

    @Test
    public void itShouldReturnPrefixesWhereSecondIsSubstringOfFirst() {
        String[] values = new String[] { "aa", "a" };
        assertEquals("a", LongestCommonPrefix.longestCommonPrefix(values));
    }

    @Test
    public void itShouldReturnEmptyStringForNoCommonPrefix() {
        String[] values = new String[] { "abc", "bcd" };
        assertEquals("", LongestCommonPrefix.longestCommonPrefix(values));
    }

    @Test
    public void itShouldReturnEmptyStringForNull() {
        assertEquals("", LongestCommonPrefix.longestCommonPrefix(null));
    }

    @Test
    public void itShouldReturnEmptyStringForEmpty() {
        assertEquals("", LongestCommonPrefix.longestCommonPrefix(new String[] {}));
    }

    @Test
    public void itShouldReturnOnlyString() {
        String[] values = new String[] { "jaebaebae" };
        assertEquals("jaebaebae", LongestCommonPrefix.longestCommonPrefix(values));
    }
}