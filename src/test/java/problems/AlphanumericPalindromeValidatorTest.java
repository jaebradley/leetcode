package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlphanumericPalindromeValidatorTest {
    @Test
    public void trueForEmptyString() {
        assertTrue(AlphanumericPalindromeValidator.isValid(""));
    }

    @Test
    public void trueForSingleCharacterString() {
        assertTrue(AlphanumericPalindromeValidator.isValid("a"));
    }

    @Test
    public void trueForSingleAlphanumericCharacterWithNonAlphanumericCharacter() {
        assertTrue(AlphanumericPalindromeValidator.isValid("a."));
    }

    @Test
    public void trueForNonAlphanumericCharacters() {
        assertTrue(AlphanumericPalindromeValidator.isValid(",."));
    }

    @Test
    public void falseForTwoDistinctCharacterString() {
        assertFalse(AlphanumericPalindromeValidator.isValid("ab"));
    }

    @Test
    public void trueForPalindromeWithSpaces() {
        assertTrue(AlphanumericPalindromeValidator.isValid("A man, a plan, a canal: Panama"));
    }

    @Test
    public void trueForPalindromeWithNumbers() {
        assertTrue(AlphanumericPalindromeValidator.isValid("1234321"));
    }

    @Test
    public void isAlphanumericForAlphabeticCharacter() {
        assertTrue(AlphanumericPalindromeValidator.isAlphanumeric('A'));
    }

    @Test
    public void isAlphanumericForNumericCharacter() {
        assertTrue(AlphanumericPalindromeValidator.isAlphanumeric('1'));
    }

    @Test
    public void isNotAlphanumeric() {
        assertFalse(AlphanumericPalindromeValidator.isAlphanumeric(':'));
    }

    @Test
    public void isAnAlphabeticCharacterPair() {
        assertTrue(AlphanumericPalindromeValidator.isAlphabeticCharacterPair('A', 'b'));
    }

    @Test
    public void isNotAnAlphabeticCharacterPair() {
        assertFalse(AlphanumericPalindromeValidator.isAlphabeticCharacterPair('A', '1'));
    }

    @Test
    public void isNumericCharacterPair() {
        assertTrue(AlphanumericPalindromeValidator.isNumericCharacterPair('0', '1'));
    }

    @Test
    public void isNotANumericCharacterPair() {
        assertFalse(AlphanumericPalindromeValidator.isNumericCharacterPair('A', '1'));
    }
}