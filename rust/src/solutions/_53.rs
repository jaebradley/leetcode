// https://leetcode.com/problems/maximum-subarray/

/**
If you calculate the sub-problem of "maximum sub array that ends at index i", then iterating over
the input array in order (calculating this problem for each index), you could "stitch" the results
together in such a way where the using the value calculated for index i, could calculate the value
for index i + 1.

If the maximum "value" for index i is greater than 0 then it will increase the
overall maximum possible value - but if it's not, then can just use the value at index i + 1 in the
input array.
**/

use std::cmp::max;

struct Solution {}

impl Solution {
    pub fn max_sub_array(nums: Vec<i32>) -> i32 {
        let mut maximum_sum = *nums.get(0).unwrap();
        let mut previous_index_maximum_sum = maximum_sum;
        for (index, _value) in nums.iter().enumerate() {
            if 1 <= index {
                let maximum_sub_array_ending_at_current_index = nums.get(index).unwrap() + max(0, previous_index_maximum_sum);
                previous_index_maximum_sum = maximum_sub_array_ending_at_current_index;
                maximum_sum = max(maximum_sum, maximum_sub_array_ending_at_current_index);
            }
        }

        return maximum_sum;
    }
}

mod tests {
    use crate::solutions::_53::Solution;

    #[test]
    fn test() {
        assert_eq!(1, Solution::max_sub_array(vec![1, -8, -6, -2, -5, -4, -8, -3, -7]));
    }

    #[test]
    fn test_outer_values() {
        assert_eq!(10, Solution::max_sub_array(vec![-10, -9, -8, -7, -8, -9, 10]));
    }

    #[test]
    fn test_inner_values() {
        assert_eq!(20, Solution::max_sub_array(vec![0, 0, 0, 10, 10, 0, 0, 0]));
    }
}