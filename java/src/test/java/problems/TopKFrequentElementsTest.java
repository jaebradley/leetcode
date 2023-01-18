package problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TopKFrequentElementsTest {

    @Test
    public void itShouldGetOneAndTwo() {
        int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        assertEquals(expected, TopKFrequentElements.topKFrequent(nums, 2));
    }

    @Test
    public void itShouldGetEmptyListForNoNumbers() {
        assertEquals(new ArrayList<>(), TopKFrequentElements.topKFrequent(new int[] {}, 0));
    }

    @Test
    public void itShouldGetTwo() {
        int[] nums = new int[] { 1, 1, 1, 2, 2, 2, 3 };
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        assertEquals(expected, TopKFrequentElements.topKFrequent(nums, 2));
    }
}