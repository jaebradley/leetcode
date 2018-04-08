package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringWithAtLeastKRepeatingCharactersTest {
    @Test
    public void itShouldReturnLengthForKOf1() {
        String s = "abbcccdddd";
        assertEquals(s.length(), LongestSubstringWithAtLeastKRepeatingCharacters.longestSubstring(s, 1));
    }

    @Test
    public void itShouldReturnZeroForStringLessThanK() {
        assertEquals(0, LongestSubstringWithAtLeastKRepeatingCharacters.longestSubstring("a", 2));
    }

    @Test
    public void itShouldReturnFourForRightMax() {
        assertEquals(4, LongestSubstringWithAtLeastKRepeatingCharacters.longestSubstring("ccdabba", 2));
    }

    @Test
    public void itShouldReturnFourForLeftOfRightMax() {
        assertEquals(4, LongestSubstringWithAtLeastKRepeatingCharacters.longestSubstring("ccdabbae", 2));
    }

    @Test
    public void itShouldReturnLeftMax() {
        assertEquals(2, LongestSubstringWithAtLeastKRepeatingCharacters.longestSubstring("ccdabc", 2));
    }
}