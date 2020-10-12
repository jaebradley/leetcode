package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 *
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 *
 * Approach:
 *
 * 1. Create an array of size n - this will represent the set of the ugly numbers we are trying to capture
 * 2. One way to think about ugly numbers is that they can be constructed by multiplying some previous ugly number by 2, 3, or 5
 * 3. So by keeping track of the last ugly number that 2, 3, or 5 was multiplied by, we can generate the minimum next ugly
 *    number.
 * 4. Need to keep track of ugly numbers that satisfy multiple prime factors (e.g. 6, which satisfies 2 and 3 as prime factors)
 * 5. When the minimum ugly number matches the value of multiplying the prime factor of 2, 3, 5, increment the ugly number index
 *    associated with that prime factor - this means that the next ugly number times that prime factor is the next
 *    smallest ugly number for that prime factor
 */

public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;

        int primeFactor2UglyNumberIndex = 0;
        int primeFactor3UglyNumberIndex = 0;
        int primeFactor5UglyNumberIndex = 0;

        int lastPrimeFactor2UglyNumber = 2;
        int lastPrimeFactor3UglyNumber = 3;
        int lastPrimeFactor5UglyNumber = 5;

        for (int uglyNumberIndex = 1; uglyNumberIndex < n; uglyNumberIndex++) {
            int nextPrimeFactor2UglyNumber = lastPrimeFactor2UglyNumber * uglyNumbers[primeFactor2UglyNumberIndex];
            int nextPrimeFactor3UglyNumber = lastPrimeFactor3UglyNumber * uglyNumbers[primeFactor3UglyNumberIndex];
            int nextPrimeFactor5UglyNumber = lastPrimeFactor5UglyNumber * uglyNumbers[primeFactor5UglyNumberIndex];
            int minimumNextUglyNumber = Math.min(nextPrimeFactor2UglyNumber, Math.min( nextPrimeFactor3UglyNumber, nextPrimeFactor5UglyNumber));

            uglyNumbers[uglyNumberIndex] = minimumNextUglyNumber;

            if (nextPrimeFactor2UglyNumber == minimumNextUglyNumber) {
                primeFactor2UglyNumberIndex++;
            }

            if (nextPrimeFactor3UglyNumber == minimumNextUglyNumber) {
                primeFactor3UglyNumberIndex++;
            }

            if (nextPrimeFactor5UglyNumber == minimumNextUglyNumber) {
                primeFactor5UglyNumberIndex++;
            }
        }

        return uglyNumbers[n - 1];
    }
}
