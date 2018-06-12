package problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GenerateParenthesisTest {
    @Test
    public void twoResultsWhenNIs2() {
        List<String> expected = new ArrayList<>();
        expected.add("(())");
        expected.add("()()");
        assertEquals(GenerateParenthesis.generateParenthesis(2), expected);
    }

    @Test
    public void fiveResultsWhenNIs3() {
        List<String> expected = new ArrayList<>();
        expected.add("((()))");
        expected.add("(()())");
        expected.add("(())()");
        expected.add("()(())");
        expected.add("()()()");
        assertEquals(GenerateParenthesis.generateParenthesis(3), expected);
    }
}