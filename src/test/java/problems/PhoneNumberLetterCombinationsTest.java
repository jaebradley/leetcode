package problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PhoneNumberLetterCombinationsTest {
    @Test
    public void itShouldReturnPhoneNumberLetterCombinations() {
        List<String> expected = new ArrayList<>();
        expected.add("ad");
        expected.add("ae");
        expected.add("af");
        expected.add("bd");
        expected.add("be");
        expected.add("bf");
        expected.add("cd");
        expected.add("ce");
        expected.add("cf");
        assertEquals(expected, PhoneNumberLetterCombinations.letterCombinations("23"));
    }

    @Test
    public void itShouldReturnEmptyListForNull() {
        assertEquals(new ArrayList<>(), PhoneNumberLetterCombinations.letterCombinations(null));
    }

    @Test
    public void itShouldReturnEmptyListForEmptyString() {
        assertEquals(new ArrayList<>(), PhoneNumberLetterCombinations.letterCombinations(""));
    }
}