package problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WordBreakTest {

    @Test
    public void itShouldReturnTrueForFoobar() {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("foo");
        dictionary.add("bar");

        assertTrue(WordBreak.wordBreak("foobar", dictionary));
    }

    @Test
    public void itShouldReturnFalseForFoobar() {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("foo");

        assertFalse(WordBreak.wordBreak("foobar", dictionary));
    }
}