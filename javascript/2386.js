/**
 * You are given an integer array nums and a positive integer k. You can choose any subsequence of the array and sum all of its elements together.
 * We define the K-Sum of the array as the kth largest subsequence sum that can be obtained (not necessarily distinct).
 * Return the K-Sum of the array.
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 * Note that the empty subsequence is considered to have a sum of 0.
 *
 * Example 1:
 * Input: nums = [2,4,-2], k = 5
 * Output: 2
 * Explanation: All the possible subsequence sums that we can obtain are the following sorted in decreasing order:
 * 6, 4, 4, 2, 2, 0, 0, -2.
 * The 5-Sum of the array is 2.
 * Example 2:
 * Input: nums = [1,-2,3,4,-10,12], k = 16
 * Output: 10
 * Explanation: The 16-Sum of the array is 10.
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 105
 * -109 <= nums[i] <= 109
 * 1 <= k <= min(2000, 2n)
 *
 */

import {MinHeap} from "@datastructures-js/heap";

/**
 * Approach: think of negative integers and positive integers contained within the nums array in the same way - they
 * both may potentially need to be subtracted from some value in order to produce the kth sum.
 *
 * Iterate over the array, summing all positive values and replacing negative values with their absolute values.
 * Then sort this array in ascending order.
 * Initialize an array to calculate the kth smallest differences.
 * Do the following loop k times:
 * Pop off the max heap and add the value to the kth-smallest differences array.
 * For the popped element, keep track of the sorted array index value used to generate the element value.
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
const kSum = function (nums, k) {
    let maximumSum = 0;
    nums.forEach((num, index) => {
        if (num > 0) {
            maximumSum += num;
        } else {
            nums[index] = Math.abs(num);
        }
    });
    nums.sort((a, b) => a - b);
    const minimumDifferences = [];
    const minHeap = new MinHeap((value) => value[0], [[nums[0], 0]]);
    for (let i = 0; i < k && !minHeap.isEmpty(); i++) {
        const [difference, index] = minHeap.pop();
        minimumDifferences.push(difference);
        if (index < nums.length - 1) {
            minHeap.push([difference + nums[index + 1], index + 1]);
            minHeap.push([difference - nums[index] + nums[index + 1], index + 1]);
        }
    }
    return ([maximumSum].concat(minimumDifferences.map(v => maximumSum - v)))[k - 1];
};

export default kSum;