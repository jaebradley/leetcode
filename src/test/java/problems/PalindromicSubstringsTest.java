package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromicSubstringsTest {

    @Test
    public void abcShouldBeThree() {
        assertEquals(3, PalindromicSubstrings.countSubstrings("abc"));
    }

    @Test
    public void aaaShouldBeSix() {
        assertEquals(6, PalindromicSubstrings.countSubstrings("aaa"));
    }

    @Test
    public void abbaShouldBeSix() {
        assertEquals(6, PalindromicSubstrings.countSubstrings("abba"));
    }
}