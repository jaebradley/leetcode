package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringWithoutRepeatingCharactersLengthIdentifierTest {
    @Test
    public void testEmptyString() {
        assertEquals(LongestSubstringWithoutRepeatingCharactersLengthIdentifier.identify(""), 0);
    }

    @Test
    public void testRepeatingCharacters() {
        assertEquals(LongestSubstringWithoutRepeatingCharactersLengthIdentifier.identify("aa"), 1);
    }

    @Test
    public void testGapBetweenRepeatingCharacters() {
        assertEquals(LongestSubstringWithoutRepeatingCharactersLengthIdentifier.identify("bpfbhmipx"), 7);
    }

    @Test
    public void testRepeatingCharactersWithAdditionalCharacters() {
        assertEquals(LongestSubstringWithoutRepeatingCharactersLengthIdentifier.identify("tmmzuxt"), 5);
    }
}