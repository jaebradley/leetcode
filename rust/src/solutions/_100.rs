use std::cell::RefCell;
use std::rc::Rc;

// Definition for a binary tree node.
#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
    pub val: i32,
    pub left: Option<Rc<RefCell<TreeNode>>>,
    pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
    #[inline]
    pub fn new(val: i32) -> Self {
        TreeNode {
            val,
            left: None,
            right: None,
        }
    }
}

struct Solution {}

impl Solution {
    pub fn is_same_tree(p: Option<Rc<RefCell<TreeNode>>>, q: Option<Rc<RefCell<TreeNode>>>) -> bool {
        return match p {
            Some(x) => {
                match q {
                    Some(y) => {
                        let first_node = x.borrow();
                        let second_node = y.borrow();
                        first_node.val == second_node.val && Solution::is_same_tree(first_node.left.clone(), second_node.left.clone()) && Solution::is_same_tree(first_node.right.clone(), second_node.right.clone())
                    }
                    None => {
                        false
                    }
                }
            }
            None => {
                match q {
                    Some(_y) => {
                        false
                    }
                    None => {
                        true
                    }
                }
            }
        };
    }
}

mod tests {
    use std::cell::RefCell;
    use std::rc::Rc;

    use crate::solutions::_100::{Solution, TreeNode};

    #[test]
    fn test_two_empty_trees() {
        assert_eq!(true, Solution::is_same_tree(Option::None, Option::None))
    }

    #[test]
    fn test_one_empty_tree_and_one_non_empty_tree() {
        assert_eq!(false, Solution::is_same_tree(Option::None, Option::Some(Rc::new(RefCell::new(TreeNode::new(1))))));
    }
}