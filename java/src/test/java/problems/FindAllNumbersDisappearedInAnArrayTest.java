package problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FindAllNumbersDisappearedInAnArrayTest {

    @Test
    public void itShouldFindFiveAndSix() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(6);
        assertEquals(expected, FindAllNumbersDisappearedInAnArray.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}