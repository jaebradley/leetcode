package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/4sum-ii/description/
 *
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that
 * A[i] + B[j] + C[k] + D[l] is zero.
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 * All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 */

public class FourSumCounter {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;

        Map<Integer, Integer> sumCounts1 = new HashMap<>();
        Map<Integer, Integer> sumCounts2 = new HashMap<>();

        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                sumCounts1.merge(sum, 1, (a1, b1) -> a1 + b1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                sumCounts2.merge(sum, 1, (a1, b1) -> a1 + b1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : sumCounts1.entrySet()) {
            Integer sumCounts = sumCounts2.get(-entry.getKey());
            if (sumCounts != null) {
                count += sumCounts * entry.getValue();
            }
        }

        return count;
    }
}
