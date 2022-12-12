/**
https://leetcode.com/problems/unique-paths/description/

Can think of each row of unique path calculation as dependent on previous row's unique path calculation.

Can think of the unique paths to a particular cell as the paths to the cell above + the paths to the cell to the right.

If iterating over the cell from left to right, for a row, the unique paths to the cell above is the current value at that index,
and the unique paths to the cell to the right, is the previous index's value.

Summing those two values should produce the count of unique paths to a particular cell.
 **/

struct Solution {}

impl Solution {
    pub fn unique_paths(m: i32, n: i32) -> i32 {
        let mut counts: Vec<i32> = vec![1;n as usize];
        for _ in 1..m as usize {
            for current_width_index in 1..n as usize {
                counts[current_width_index] += counts[current_width_index - 1];
            }
        }
        return counts[n as usize - 1];
    }
}

mod tests {
    use crate::solutions::_62::Solution;

    #[test]
    fn test() {
        assert_eq!(28, Solution::unique_paths(3, 7));
        assert_eq!(3, Solution::unique_paths(3, 2));
        assert_eq!(1, Solution::unique_paths(1, 100));
        assert_eq!(1, Solution::unique_paths(100, 1));
    }
}
