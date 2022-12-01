// https://leetcode.com/problems/container-with-most-water/
// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//
// Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
// Return the maximum amount of water a container can store.
//
// Notice that you may not slant the container.

use std::cmp::{max, min};

struct Solution {}

impl Solution {
    pub fn max_area(height: Vec<i32>) -> i32 {
        let mut max_volume = 0;
        let mut left_index = 0;
        let mut right_index = height.len() - 1;
        while left_index < right_index {
            let left_height = height.get(left_index).unwrap();
            let right_height = height.get(right_index).unwrap();
            let current_volume = min(left_height, right_height) * (right_index - left_index) as i32;
            max_volume = max(max_volume, current_volume);

            if left_height > right_height {
                right_index -= 1;
            } else {
                left_index += 1;
            }
        }

        return max_volume;
    }
}

mod tests {
    use crate::solutions::_11::Solution;

    #[test]
    fn test() {
        assert_eq!(49, Solution::max_area(vec![1,8,6,2,5,4,8,3,7]));
    }

    #[test]
    fn test_outer_values() {
        assert_eq!(60, Solution::max_area(vec![10, 9, 8, 7, 8, 9, 10]));
    }

    #[test]
    fn test_inner_values() {
        assert_eq!(10, Solution::max_area(vec![0, 0, 0, 10, 10, 0, 0, 0]));
    }
}