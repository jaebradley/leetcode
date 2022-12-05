// https://leetcode.com/problems/jump-game-ii/

use std::collections::{HashSet, VecDeque};

struct Solution {}

/**
BFS-based approach, treating each next index as a potential node
 **/
impl Solution {
    pub fn jump(nums: Vec<i32>) -> i32 {
        let mut queue: VecDeque<usize> = VecDeque::new();
        queue.push_back(0);
        let mut count = 0;
        let mut seen_nums: HashSet<usize> = HashSet::new();

        while 0 < queue.len() {
            let length = queue.len();
            for _ in 0..length {
                let current_index = queue.pop_front().unwrap();
                if nums.len() - 1 == current_index {
                    return count;
                }

                if seen_nums.insert(current_index) {
                    let max_length: i32 = *nums.get(current_index).unwrap();
                    for increment in 1..max_length + 1 {
                        let next_index = current_index + increment as usize;
                        if !seen_nums.contains(&next_index) {
                            queue.push_back(next_index);
                        }
                    }
                }
            }

            count += 1;
        }


        panic!("Should have found last element");
    }
}

mod tests {
    use crate::solutions::_45::Solution;

    #[test]
    fn test() {
        assert_eq!(2, Solution::jump(vec![2, 3, 1, 1, 4]));
        assert_eq!(2, Solution::jump(vec![2, 3, 0, 1, 4]));
    }
}
