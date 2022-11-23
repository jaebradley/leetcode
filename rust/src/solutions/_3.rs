// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Given a string s, find the length of the longest substring without repeating characters.

use std::cmp::max;
use std::collections::hash_map::Entry::Occupied;
use std::collections::hash_map::Entry::Vacant;
use std::collections::HashMap;

struct Solution {}

impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        // Two pointers, a leader and a follower
        // Follower iterates over characters until a duplicate is detected
        // On each iteration, if existing length is greater than longest length, update the longest length
        // Duplicates are detected by keeping track of the index that a character has been seen
        // in a 26-element array of Option<usize>
        // If a character is seen again (i.e. the character index does not have a value of Option::None)
        // Iterate the follower pointer to the index after the index value the character was last seen at
        // Continue this pattern until the follower pointer reaches end of string

        let mut longest_length: i32 = 0;

        if !s.is_empty() {
            let characters: Vec<char> = s.chars().collect();
            let mut last_seen_character_indices_by_character: HashMap<char, usize> = HashMap::new();
            let mut follower_pointer: usize = 0;
            let mut leader_pointer: usize = 0;

            while leader_pointer < characters.len() {
                let current_character = *characters.get(leader_pointer).unwrap();
                match last_seen_character_indices_by_character.entry(current_character) {
                    Occupied(entry) => {
                        let last_seen_character_index = *entry.get();
                        while follower_pointer <= last_seen_character_index {
                            last_seen_character_indices_by_character.remove(characters.get(follower_pointer).unwrap());
                            follower_pointer += 1;
                        }
                    }
                    Vacant(_) => {}
                }

                match last_seen_character_indices_by_character.entry(current_character) {
                    Occupied(_) => {}
                    Vacant(ve) => {
                        ve.insert(leader_pointer);
                    }
                }

                leader_pointer += 1;
                longest_length = max(longest_length, (leader_pointer - follower_pointer) as i32);
            }
        }

        return longest_length;
    }
}

mod tests {
    use crate::solutions::_3::Solution;

    #[test]
    fn test_empty_string() {
        assert_eq!(0, Solution::length_of_longest_substring(String::from("")));
    }

    #[test]
    fn test_single_character() {
        assert_eq!(1, Solution::length_of_longest_substring(String::from("j")));
    }

    #[test]
    fn test_two_different_characters() {
        assert_eq!(2, Solution::length_of_longest_substring(String::from("ja")));
    }

    #[test]
    fn test_two_identical_characters() {
        assert_eq!(1, Solution::length_of_longest_substring(String::from("jj")));
    }

    #[test]
    fn test_longest_substring_nested_in_middle() {
        assert_eq!(6, Solution::length_of_longest_substring(String::from("jjjabcdejjj")));
    }
}