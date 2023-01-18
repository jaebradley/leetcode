package problems;

import java.util.Arrays;

/**
 * Array Partition 1 Problem (https://leetcode.com/problems/array-partition-i/description/)
 *
 * Given an array of 2n integers, group these integers into n pairs such that the sum of the minimum of each pair is
 * maximized.
 */

public class ArrayPairsMinimumElementSumMaximizer {
    /**
     * In order to get the maximum sum of pairs of integers, you would want to group the values such that the "distance"
     * between itself and the next value is minimized. In other words, sort the array values.
     * @param numbers an even number of integers
     * @return integer that represents the maximum sum
     */
    public static int getMaximumSum(int[] numbers) {
        Arrays.sort(numbers);

        int maximumSum = 0;
        for (int i = 0; i < numbers.length; i += 2) {
            maximumSum += numbers[i];
        }

        return maximumSum;
    }
}
