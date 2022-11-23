// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

// Definition for singly-linked list.
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    fn new(val: i32) -> Self {
        ListNode {
            next: None,
            val,
        }
    }
}

struct Solution {}

impl Solution {
    pub fn remove_nth_from_end(head: Option<Box<ListNode>>, n: i32) -> Option<Box<ListNode>> {
        // Two pointers - lead pointer progresses through list n times
        // Second pointer starts at head, and both pointers progress one node at a time until
        // the lead pointer reaches the end of the list

        let mut dummy = Box::new(ListNode{ val: -1, next: head });
        let mut lead_pointer = dummy.clone();

        for _ in 0..n {
            lead_pointer = lead_pointer.next.unwrap();
        }

        let mut following_pointer = dummy.as_mut();

        while let Some(node) = lead_pointer.next {
            lead_pointer = node;
            following_pointer = following_pointer.next.as_mut().unwrap();
        }

        following_pointer.next = following_pointer.next.as_mut().unwrap().next.clone();

        return dummy.next;
    }
}

mod tests {
    use crate::solutions::_19::{ListNode, Solution};

    #[test]
    fn test_single_value() {
        assert_eq!(Option::None, Solution::remove_nth_from_end(Option::Some(Box::new(ListNode{ val: 1, next: Option::None })), 1));
    }

    #[test]
    fn test_two_values_removing_last_entry() {
        assert_eq!(Option::Some(Box::new(ListNode{ val: 1, next: Option::None })), Solution::remove_nth_from_end(Option::Some(Box::new(ListNode{ val: 1, next: Option::Some(Box::new(ListNode{ val: 2, next: Option::None }))})), 1));
    }

    #[test]
    fn test_two_values_removing_first_entry() {
        assert_eq!(Option::Some(Box::new(ListNode{ val: 2, next: Option::None })), Solution::remove_nth_from_end(Option::Some(Box::new(ListNode{ val: 1, next: Option::Some(Box::new(ListNode{ val: 2, next: Option::None }))})), 2));
    }
}