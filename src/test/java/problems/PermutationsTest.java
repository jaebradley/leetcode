package problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PermutationsTest {

    @Test
    public void onePermutationForSingleElementList() {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> singleElementPermutation = new ArrayList<>();
        singleElementPermutation.add(1);
        permutations.add(singleElementPermutation);
        assertEquals(permutations, Permutations.permute(new int[] {1}));
    }

    @Test
    public void twoPermutationForTwoElementList() {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> firstPermutation = new ArrayList<>();
        firstPermutation.add(1);
        firstPermutation.add(2);
        List<Integer> secondPermutation = new ArrayList<>();
        secondPermutation.add(2);
        secondPermutation.add(1);
        permutations.add(firstPermutation);
        permutations.add(secondPermutation);
        assertEquals(permutations, Permutations.permute(new int[] {1, 2}));
    }

    @Test
    public void sixPermutationForThreeElementList() {
        List<Integer> firstPermutation = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> secondPermutation = new ArrayList<>(Arrays.asList(1, 3, 2));
        List<Integer> thirdPermutation = new ArrayList<>(Arrays.asList(2, 1, 3));
        List<Integer> fourthPermutation = new ArrayList<>(Arrays.asList(2, 3, 1));
        List<Integer> fifthPermutation = new ArrayList<>(Arrays.asList(3, 1, 2));
        List<Integer> sixthPermutation = new ArrayList<>(Arrays.asList(3, 2, 1));
        List<List<Integer>> permutations = new ArrayList<>(Arrays.asList(firstPermutation, secondPermutation, thirdPermutation, fourthPermutation, fifthPermutation, sixthPermutation));
        assertEquals(permutations, Permutations.permute(new int[] {1, 2, 3}));
    }
}