package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstUniqueCharacterIndexIdentifierTest {
    @Test
    public void itShouldReturnFirstCharacterIndex() {
        assertEquals(0, FirstUniqueCharacterIndexIdentifier.identify("jaebaebae"));
        assertEquals(0, FirstUniqueCharacterIndexIdentifier.identify1("jaebaebae"));
    }

    @Test
    public void itShouldReturnNegativeOneForNoNonRepeatingCharacters() {
        assertEquals(-1, FirstUniqueCharacterIndexIdentifier.identify("abccba"));
        assertEquals(-1, FirstUniqueCharacterIndexIdentifier.identify1("abccba"));
    }
}