/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Example 3:
 * Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
 * Output: [1,2]
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */


/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
const topKFrequent = function(nums, k) {
    const countsByValue = nums.reduce((accumulator, currentValue) => {
        accumulator.set(currentValue, 1 + (accumulator.get(currentValue) || 0));
        return accumulator;
    }, new Map());

    const valuesByFrequency = new Map();
    countsByValue.forEach((frequency, key) => {
        const values = (valuesByFrequency.get(frequency) || []);
        values.push(key);
        valuesByFrequency.set(frequency, values);
    });

    const result = [];

    for (let i = nums.length; i >= 0 && result.length < k; i--) {
        const values = valuesByFrequency.get(i);
        if (values) {
            result.push(...values);
        }
    }

    return result.slice(0, k);
};

export default topKFrequent;