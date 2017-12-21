package problems;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of
 * all the elements of nums except nums[i].
 *
 * Solve it without division and in O(n).
 *
 * For example, given [1,2,3,4], return [24,12,8,6].
 */

public class ArrayProductExceptSelfCalculator {
    /**
     * Given the input array, you can construct two arrays - one is the product of all values to the left of the index
     * and the other is the product of all values to the right of the index. Calculating the product of these two values
     * returns the product of all elements from the input array except the element at the given index.
     *
     * Example: [2, 3, 4, 5]
     * Expected Output: [60, 40, 30, 24]
     *
     * leftProducts = [1]
     * rightProducts = [1]
     * leftProduct = 1
     * rightProduct = 1
     *
     * index = 0
     * leftValue = 2
     * rightValue = 5
     *
     * leftProduct = 2 (previous leftProduct (1) * current left value (2))
     * rightProduct = 5
     *
     * leftProducts = [1, 2]
     * rightProducts = [5, 1]
     *
     * index = 1
     * leftValue = 3
     * rightValue = 4
     *
     * leftProduct = 6
     * rightProduct = 20
     *
     * leftProducts = [1, 2, 6]
     * rightProducts = [20, 5, 1]
     *
     * index = 2
     * leftValue = 4
     * rightValue = 3
     *
     * leftProduct = 24
     * rightProduct = 60
     *
     * leftProducts = [1, 2, 6, 24]
     * rightProducts = [60, 20, 5, 1]
     *
     * Note how the product of the arrays at their respective indices is now the expected output:
     * [1 * 60, 2 * 20, 6 * 5, 24 * 1] = [60, 40, 30, 24]
     *
     *
     * @param values array of integers to calculate products from
     * @return array of integers where the value at each index is the product of all integers in the input array,
     *         except for the integer at that index
     */
    public static int[] calculate(int[] values) {
        if (values.length <= 1) {
            return new int[] {};
        }

        int[] products = new int[values.length];
        int[] leftProducts = new int[values.length];
        int[] rightProducts = new int[values.length];
        leftProducts[0] = 1;
        rightProducts[values.length - 1] = 1;
        int leftProduct = 1;
        int rightProduct = 1;
        for (int i = 0; i < values.length - 1; i++) {
            int j = values.length - 1 - i;
            int leftValue = values[i];
            int rightValue = values[j];
            leftProduct *= leftValue;
            rightProduct *= rightValue;
            leftProducts[i + 1] = leftProduct;
            rightProducts[j - 1] = rightProduct;
        }

        for (int i = 0; i < values.length; i++) {
            products[i] = leftProducts[i] * rightProducts[i];
        }

        return products;
    }
}
