package problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SubsetsTest {

    @Test
    public void emptyListForEmptyNumbers() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>());
        assertEquals(expected, Subsets.subsets(new int[] {}));
    }

    @Test
    public void singleSubsetForSingleValue() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>());
        List<Integer> subset = new ArrayList<>();
        subset.add(1);
        expected.add(subset);
        assertEquals(expected, Subsets.subsets(new int[] {1}));
    }

    @Test
    public void threeValuePowerSet() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>());
        List<Integer> subset1 = new ArrayList<>();
        List<Integer> subset2 = new ArrayList<>();
        List<Integer> subset3 = new ArrayList<>();
        List<Integer> subset12 = new ArrayList<>();
        List<Integer> subset13 = new ArrayList<>();
        List<Integer> subset23 = new ArrayList<>();
        List<Integer> subset123 = new ArrayList<>();
        subset1.add(1);
        subset2.add(2);
        subset3.add(3);
        subset12.add(1);
        subset12.add(2);
        subset13.add(1);
        subset13.add(3);
        subset23.add(2);
        subset23.add(3);
        subset123.add(1);
        subset123.add(2);
        subset123.add(3);
        expected.add(subset1);
        expected.add(subset12);
        expected.add(subset123);
        expected.add(subset13);
        expected.add(subset2);
        expected.add(subset23);
        expected.add(subset3);
        assertEquals(expected, Subsets.subsets(new int[] {1, 2, 3}));
    }
}