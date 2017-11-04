package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeValidatorTest {
    @Test
    public void trueForEmptyString() {
        assertTrue(PalindromeValidator.isAlphaNumericPalindromeIgnoringCase(""));
    }

    @Test
    public void trueForSingleCharacterString() {
        assertTrue(PalindromeValidator.isAlphaNumericPalindromeIgnoringCase("a"));
    }

    @Test
    public void trueForSingleAlphanumericCharacterWithNonAlphanumericCharacter() {
        assertTrue(PalindromeValidator.isAlphaNumericPalindromeIgnoringCase("a."));
    }

    @Test
    public void trueForNonAlphanumericCharacters() {
        assertTrue(PalindromeValidator.isAlphaNumericPalindromeIgnoringCase(",."));
    }

    @Test
    public void falseForTwoDistinctCharacterString() {
        assertFalse(PalindromeValidator.isAlphaNumericPalindromeIgnoringCase("ab"));
    }

    @Test
    public void trueForPalindromeWithSpaces() {
        assertTrue(PalindromeValidator.isAlphaNumericPalindromeIgnoringCase("A man, a plan, a canal: Panama"));
    }

    @Test
    public void trueForPalindromeWithNumbers() {
        assertTrue(PalindromeValidator.isAlphaNumericPalindromeIgnoringCase("1234321"));
    }

    @Test
    public void isAlphanumericForAlphabeticCharacter() {
        assertTrue(PalindromeValidator.isAlphanumeric('A'));
    }

    @Test
    public void isAlphanumericForNumericCharacter() {
        assertTrue(PalindromeValidator.isAlphanumeric('1'));
    }

    @Test
    public void isNotAlphanumeric() {
        assertFalse(PalindromeValidator.isAlphanumeric(':'));
    }

    @Test
    public void isAnAlphabeticCharacterPair() {
        assertTrue(PalindromeValidator.isAlphabeticCharacterPair('A', 'b'));
    }

    @Test
    public void isNotAnAlphabeticCharacterPair() {
        assertFalse(PalindromeValidator.isAlphabeticCharacterPair('A', '1'));
    }

    @Test
    public void isNumericCharacterPair() {
        assertTrue(PalindromeValidator.isNumericCharacterPair('0', '1'));
    }

    @Test
    public void isNotANumericCharacterPair() {
        assertFalse(PalindromeValidator.isNumericCharacterPair('A', '1'));
    }
}