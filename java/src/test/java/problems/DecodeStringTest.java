package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecodeStringTest {
    @Test
    public void basicNumberLetterCombination() {
        assertEquals("aaa", DecodeString.decodeString("3[a]"));
    }

    @Test
    public void basicNumberMultipleLetterCombination() {
        assertEquals("ababab", DecodeString.decodeString("3[ab]"));
    }

    @Test
    public void oneHundredLeetcode() {
        assertEquals("leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode", DecodeString.decodeString("100[leetcode]"));
    }

    @Test
    public void nestedLetterCombination() {
        assertEquals("accaccacc", DecodeString.decodeString("3[a2[c]]"));
    }

    @Test
    public void numberLetterCombinationWithRegularLetters() {
        assertEquals("abcabcef", DecodeString.decodeString("2[abc]ef"));
    }

    @Test
    public void nestedNumberLetterCombinationsWithRegularLetters() {
        assertEquals("abcceabccef", DecodeString.decodeString("2[ab2[c]e]f"));
    }

    @Test
    public void multipleNumberLetterCombinationWithRegularLetters() {
        assertEquals("ababcbababad", DecodeString.decodeString("2[ab]c3[ba]d"));
    }
}