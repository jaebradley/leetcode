/**
https://leetcode.com/problems/sort-colors/description/

red < white < blue
1 pointer for each color

with all pointers starting from 0, except blue pointer starting at end
while the white pointer value is <= blue pointer value
if the white pointer value is 0, swap with red pointer, increment white pointer value and red pointer value
if the white pointer value is 1, increment white pointer value
if the white pointer value is 2, swap with blue pointer value, decrement blue pointer value and white pointer value
**/

struct Solution {}

impl Solution {
    pub fn sort_colors(nums: &mut Vec<i32>) {
        let mut red_index = 0;
        let mut white_index = 0;
        let mut blue_index = nums.len() - 1;

        while white_index <= blue_index && blue_index > 0 {
            if 0 == nums[white_index] {
                nums[white_index] = nums[red_index];
                nums[red_index] = 0;
                white_index += 1;
                red_index += 1;
            } else if 1 == nums[white_index] {
                white_index += 1;
            } else if 2 == nums[white_index] {
                nums[white_index] = nums[blue_index];
                nums[blue_index] = 2;
                blue_index -= 1;
            }
        }
    }
}

mod tests {
    use crate::solutions::_75::Solution;

    #[test]
    fn test() {
        let mut first = vec![2, 0, 2, 1, 1, 0];
        Solution::sort_colors(&mut first);
        assert_eq!(vec![0, 0, 1, 1, 2, 2], first);

        let mut second = vec![2, 0, 1];
        Solution::sort_colors(&mut second);
        assert_eq!(vec![0, 1, 2], second);
    }
}