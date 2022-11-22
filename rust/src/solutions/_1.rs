use std::alloc::System;
use std::collections::HashMap;

struct Solution {}

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut indices_by_complement: HashMap<i32, i32> = HashMap::new();

        for (index, num) in nums.iter().enumerate() {
            let index_by_complement = indices_by_complement.get(num);
            match index_by_complement {
                Some(v) => {
                    return vec![*v, index as i32];
                }
                None => {
                    indices_by_complement.insert(target - num, index as i32);
                }
            };
        }

        panic!("Unexpected");
    }
}

mod tests {
    use crate::solutions::_1::Solution;

    #[test]
    fn test_two_values_matching_target() {
        assert_eq!(vec![0, 1], Solution::two_sum(vec![1, 1], 2));
    }

    #[test]
    fn test_three_values_first_and_last_matching_target() {
        assert_eq!(vec![0, 2], Solution::two_sum(vec![1, 0, 1], 2));
    }

    #[test]
    fn test_first_two_values_matching_target() {
        assert_eq!(vec![0, 1], Solution::two_sum(vec![2, 7, 11, 15], 9));
    }
}