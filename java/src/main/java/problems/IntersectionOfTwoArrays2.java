package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 */

public class IntersectionOfTwoArrays2 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersection = new ArrayList<>();
        Map<Integer, Integer> firstValuesFrequency = new HashMap<>();
        Map<Integer, Integer> secondValuesFrequency = new HashMap<>();

        for (int value : nums1) {
            firstValuesFrequency.merge(value, 1, (a, b) -> a + b);
        }

        for (int value : nums2) {
            secondValuesFrequency.merge(value, 1, (a, b) -> a + b);
        }

        for (Map.Entry<Integer, Integer> firstValueFrequency : firstValuesFrequency.entrySet()) {
            Integer secondValueFrequency = secondValuesFrequency.get(firstValueFrequency.getKey());
            if (secondValueFrequency != null) {
                for (int i = 0; i < Math.min(firstValueFrequency.getValue(), secondValueFrequency); i++) {
                    intersection.add(firstValueFrequency.getKey());
                }
            }
        }

        int[] intersectionValues = new int[intersection.size()];

        for (int i = 0; i < intersection.size(); i++) {
            intersectionValues[i] = intersection.get(i);
        }

        return intersectionValues;
    }
}
