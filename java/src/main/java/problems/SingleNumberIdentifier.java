package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Single Number problem (https://leetcode.com/problems/single-number/description/)
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */

public class SingleNumberIdentifier {
    public static int identify(int[] numbers) {
        Map<Integer, Integer> numberCounts = new HashMap<>();
        for (Integer number : numbers) {
            Integer count = numberCounts.get(number);
            if (count == null) {
                numberCounts.put(number, 1);
            } else {
                numberCounts.put(number, count + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : numberCounts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        throw new IllegalArgumentException("Expected number with one count");
    }

    public static int identifyXOR(int[] numbers) {
        /**
         * The XOR operation (https://en.wikipedia.org/wiki/Exclusive_or) flips the bits of a number.
         * For numbers that exist twice, the XOR operation "cancels" itself out for two numbers that are the same.
         * Thus, the only number that should exist after the XOR operations should be the single number in the array.
         */
        int value = 0;
        for (int number : numbers) {
            value = value ^ number;
        }
        return value;
    }
}
