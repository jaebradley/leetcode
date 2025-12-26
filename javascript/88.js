/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * Example 3:
 *
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 *
 *
 * Constraints:
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */

/**
 * Approach:
 * Start from the back of the nums1 array and the back of the nums2 array.
 * Since they are ordered in non-decreasing order, the ends of nums2 and nums1 (starting at index n) should have the
 * greatest values in both arrays.
 * Until nums2 is exhausted execute the following loop:
 * Given the index of the current nums1 array or the index of the nums2 array - whichever is greater, insert that value
 * into the current pointer for the ends of the nums1 array.
 * Decrement the pointer for the combined end of the nums1 array.
 * If the number is from the nums2 array, decrement the nums2 array pointer.
 * If the number is from the nums1 array, decrement the nums1 pointer.
 * If the nums1 pointer was 0, insert the nums2 value and decrement.
 * Runtime: O(size of nums1 + size of nums2)
 * Space: O(1)
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
const merge = function (nums1, m, nums2, n) {
    let currentNums1Index = m - 1;
    let currentNums2Index = n - 1;
    let combinedEndIndex = n + m - 1;

    while (currentNums2Index >= 0) {
        const currentNums2 = nums2[currentNums2Index];
        if (currentNums1Index >= 0 && nums1[currentNums1Index] >= currentNums2) {
            nums1[combinedEndIndex] = nums1[currentNums1Index];
            currentNums1Index -= 1;
        } else {
            nums1[combinedEndIndex] = currentNums2;
            currentNums2Index -= 1;
        }
        combinedEndIndex -= 1;
    }
};

export default merge;