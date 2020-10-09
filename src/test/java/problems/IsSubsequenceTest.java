package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsSubsequenceTest {

    @Test
    public void testIdenticalStrings() {
        assertTrue(new IsSubsequence().isSubsequence("foobar", "foobar"));
    }

    @Test
    public void testPrefixed() {
        assertTrue(new IsSubsequence().isSubsequence("foobar", "jaebaebaefoobar"));
    }


    @Test
    public void testIntermediateCharacters() {
        assertTrue(new IsSubsequence().isSubsequence("foobar", "fzoyoxbwavrt"));
    }

    @Test
    public void testSuffix() {
        assertTrue(new IsSubsequence().isSubsequence("foobar", "foobarbazgaz"));
    }

    @Test
    public void testDifferentWords() {
        assertFalse(new IsSubsequence().isSubsequence("foobar", "jaebaebae"));
    }

    @Test
    public void testMissingLastCharacter() {
        assertFalse(new IsSubsequence().isSubsequence("foobar", "fooba"));
    }

    @Test
    public void testPrefixMissingCharacter() {
        assertFalse(new IsSubsequence().isSubsequence("aaaaa", "bbaaaa"));
    }
}