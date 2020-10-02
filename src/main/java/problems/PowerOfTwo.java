package problems;

/**
 * https://leetcode.com/problems/power-of-two/
 *
 * n an integer n, write a function to determine if it is a power of two.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 *
 * Input: n = 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 *
 * Input: n = 3
 * Output: false
 * Example 4:
 *
 * Input: n = 4
 * Output: true
 * Example 5:
 *
 * Input: n = 5
 * Output: false
 *
 *
 * Constraints:
 *
 * -231 <= n <= 231 - 1
 *
 * Approach:
 *
 * 1. The way the AND bitwise operator works is that given two bit representations (like 0101 and 0111), it will return
 *    1 when both values at a bit index are 1 and 0 otherwise (so example numbers would return 0101)
 * 2. Powers of two (1, 2, 4, 8, 16, etc) have a single 1 bit followed by some number of 0 bits. The bit representation
 *    of the number before (1, 3, 7, 15, etc) are only 1 bits (with a "leading" 0 bit).
 * 3. bitwise AND-ing the values would lead to the result being only 0 bits because the "leading" 1 bit in the power of
 *    two case would "cancel" out with the 0 bit from the previous value, and all the 1 bits in the previous value would
 *    "cancel" out the 0 bits in the power of two case. (1000 (8) vs. 0111 (7) for example)
 */

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
