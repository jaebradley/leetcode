package problems;

/**
 * Calculate the Hamming Distance (https://en.wikipedia.org/wiki/Hamming_distance) between two integers.
 * The Hamming Distance is the number of positions at which the corresponding bits between two integers is different.
 *
 * https://leetcode.com/problems/hamming-distance/description/
 *
 */

public class HammingDistanceCalculator {
    /**
     * Use the XOR operation (https://en.wikipedia.org/wiki/Exclusive_or) to flip the bits of two numbers - if they
     * share the same value for a bit the result of the XOR operation is that the corresponding bit is now 0 and 1,
     * otherwise.
     *
     * Then count the number of 1s in the binary representation of the XORed value
     * @param value1
     * @param value2
     * @return
     */
    public static int calculateDistance(int value1, int value2) {
        int distance = 0;
        int hammingDistanceValue = value1 ^ value2;
        while (hammingDistanceValue != 0) {
            // https://prismoskills.appspot.com/lessons/Bitwise_Operators/Count_ones_in_an_integer.jsp
            hammingDistanceValue = hammingDistanceValue & (hammingDistanceValue - 1);
            distance++;
        }

        return distance;
    }
}
