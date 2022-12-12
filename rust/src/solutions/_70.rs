/**
https://leetcode.com/problems/climbing-stairs/description/

Array of length n represents the number of unique ways to get to step i.
For each step i > 0, the number of unique ways to get to that step is step[i -1] + step[i - 2].
step[0] and step[1] are hard-coded to 1.
**/

struct Solution {}

impl Solution {
    pub fn climb_stairs(n: i32) -> i32 {
        let size = (n + 1) as usize;
        let mut counts: Vec<i32> = vec![0; size];
        counts[0] = 1;
        counts[1] = 1;

        for current_step in 2..size {
            counts[current_step] += counts[current_step - 1] + counts[current_step - 2];
        }

        return counts[size - 1];
    }
}

mod tests {
    use crate::solutions::_70::Solution;

    #[test]
    fn test() {
        assert_eq!(2, Solution::climb_stairs(2));
        assert_eq!(3, Solution::climb_stairs(3));
    }
}