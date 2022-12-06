// https://leetcode.com/problems/merge-intervals/

use std::cmp::{max, min};

/**
Order the intervals by start value first, then end value.

For each interval, if it's start value is in-between the current "merged" interval's start and end
value, then "merge" it into the "merged" interval, increasing the end value if the current interval
has a greater end value.

If the next interval's start value is not in-between the current "merged" interval, add the "merged"
interval to the array of merged intervals and start a new "merged" interval with start / end values
set to the next interval's values.

Runtime should be O(n log n) due to sorting.
 **/

struct Solution {}

impl Solution {
    pub fn merge(mut intervals: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        intervals.sort_by(|first, second| first[0].cmp(&second[0]));

        let mut merged_intervals: Vec<Vec<i32>> = vec![];

        let mut start_of_current_merged_interval = intervals[0][0];
        let mut end_of_current_merged_interval = intervals[0][1];

        for current_interval in intervals {
            if current_interval[0] >= start_of_current_merged_interval && current_interval[0] <= end_of_current_merged_interval {
                start_of_current_merged_interval = min(start_of_current_merged_interval, current_interval[0]);
                end_of_current_merged_interval = max(end_of_current_merged_interval, current_interval[1]);
            } else {
                merged_intervals.push(vec![start_of_current_merged_interval, end_of_current_merged_interval]);

                start_of_current_merged_interval = current_interval[0];
                end_of_current_merged_interval = current_interval[1];
            }
        }

        merged_intervals.push(vec![start_of_current_merged_interval, end_of_current_merged_interval]);

        return merged_intervals;
    }
}

mod tests {
    use crate::solutions::_56::Solution;

    #[test]
    fn test() {
        assert_eq!(vec![vec![1, 5]], Solution::merge(vec![vec![1, 4], vec![4, 5]]));
        assert_eq!(
            vec![vec![1, 6], vec![8, 10], vec![15, 18]],
            Solution::merge(vec![vec![1, 3], vec![2, 6], vec![8, 10], vec![15, 18]]));
    }
}