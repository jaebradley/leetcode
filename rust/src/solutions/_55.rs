// https://leetcode.com/problems/jump-game/description/

/**
Greedy approach that works backwards from end to beginning.

Idea is to use the last index as the initial "target", and to work backwards from that index until
an index is found where the index + value at index >= target (which means that the target can be
reached from that index).

Then update the target to that index, to find preceding index that can make it to that index, etc.

Until target is index 0 (start of the values), or all indices have been iterated over (and the
target is NOT index 0, in which case no way to jump to last index).
**/

struct Solution {}

impl Solution {
    pub fn can_jump(nums: Vec<i32>) -> bool {
        let mut current_index = nums.len() as i32 - 1;
        let mut target_index = nums.len() as i32 - 1;

        while current_index >= 0 {
            if (current_index + nums[current_index as usize]) >= target_index {
                target_index = current_index;
            }

            current_index -= 1;
        }

        return target_index <= 0;
    }
}

mod tests {
    use crate::solutions::_55::Solution;

    #[test]
    fn test() {
        assert_eq!(true, Solution::can_jump(vec![2, 3, 1, 1, 4]));
        assert_eq!(true, Solution::can_jump(vec![2, 3, 0, 1, 4]));
        assert_eq!(false, Solution::can_jump(vec![3, 2, 1, 0,4]));
        assert_eq!(false, Solution::can_jump(vec![0, 1, 2, 3, 4]))
    }
}
