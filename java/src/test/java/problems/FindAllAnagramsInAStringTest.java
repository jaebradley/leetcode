package problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FindAllAnagramsInAStringTest {

    @Test
    public void findTwoAnagrams() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(6);
        assertEquals(expected, FindAllAnagramsInAString.findAnagrams("cbaebabacd", "abc"));
    }

    @Test
    public void findTwoAnagramsThatShareLetters() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        assertEquals(expected, FindAllAnagramsInAString.findAnagrams("cbac", "abc"));
    }
}