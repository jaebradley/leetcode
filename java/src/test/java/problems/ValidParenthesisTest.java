package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidParenthesisTest {
    @Test
    public void itShouldReturnTrueForSeparatePairs() {
        assertTrue(ValidParenthesis.isValid("(){}[]"));
        assertTrue(ValidParenthesis.isValid2("(){}[]"));
    }

    @Test
    public void itShouldReturnFalseForMissingPair() {
        assertFalse(ValidParenthesis.isValid("({)[]}"));
        assertFalse(ValidParenthesis.isValid2("({)[]}"));
    }

    @Test
    public void itShouldReturnFalseForSingleParenthesis() {
        assertFalse(ValidParenthesis.isValid("["));
        assertFalse(ValidParenthesis.isValid2("["));
    }

    @Test
    public void itShouldReturnFalseForSingleClosedParenthesis() {
        assertFalse(ValidParenthesis.isValid("]"));
        assertFalse(ValidParenthesis.isValid2("]"));
    }
}