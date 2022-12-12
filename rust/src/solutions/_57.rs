use std::cmp::{max, min};

struct Solution {}

impl Solution {
    pub fn insert(intervals: Vec<Vec<i32>>, new_interval: Vec<i32>) -> Vec<Vec<i32>> {
        let mut result: Vec<Vec<i32>> = Vec::new();
        let mut current_interval_index = 0;

        while current_interval_index < intervals.len() && *intervals.get(current_interval_index).unwrap().get(1).unwrap() < *new_interval.get(0).unwrap() {
            result.push(intervals.get(current_interval_index).unwrap().clone());
            current_interval_index += 1;
        }

        let mut merged_interval: Vec<i32> = new_interval.clone();
        while current_interval_index < intervals.len() && *intervals.get(current_interval_index).unwrap().get(0).unwrap() <= *merged_interval.get(1).unwrap() {
            merged_interval = vec![
                min(*merged_interval.get(0).unwrap(), *intervals.get(current_interval_index).unwrap().get(0).unwrap()),
                max(*merged_interval.get(1).unwrap(), *intervals.get(current_interval_index).unwrap().get(1).unwrap()),
            ];

            current_interval_index += 1;
        }
        result.push(merged_interval);


        while current_interval_index < intervals.len() {
            result.push(intervals.get(current_interval_index).unwrap().clone());
            current_interval_index += 1;
        }

        return result;
    }
}

mod tests {
    use crate::solutions::_57::Solution;

    #[test]
    fn test() {
        assert_eq!(vec![vec![1, 2], vec![3, 4], vec![5, 6], vec![7, 8]],
                   Solution::insert(vec![vec![1, 2], vec![3, 4], vec![5, 6], vec![7, 8]], vec![5, 6]));
        assert_eq!(vec![vec![1, 5]], Solution::insert(vec![vec![1, 4], vec![4, 5]], vec![3, 4]));
        assert_eq!(
            vec![vec![1, 10], vec![15, 18]],
            Solution::insert(vec![vec![1, 6], vec![2, 3], vec![8, 10], vec![15, 18]], vec![4, 9]));
    }
}