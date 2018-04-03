package problems;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/description/

 * algorithms
 * Easy (40.19%)
 * Total Accepted:    43.8K
 * Total Submissions: 109K
 * Testcase Example:  '[3,4,5,1,2]\n[4,1,2]'


 Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.


 Example 1:

 Given tree s:

 3
 / \
 4   5
 / \
 1   2

 Given tree t:

 4
 / \
 1   2

 Return true, because t has the same structure and node values with a subtree of s.


 Example 2:

 Given tree s:

 3
 / \
 4   5
 / \
 1   2
 /
 0

 Given tree t:

 4
 / \
 1   2

 Return false.
**/

public class SubtreeOfAnotherTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean haveEqualValues(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }

        return s.val == t.val
                && haveEqualValues(s.left, t.left)
                && haveEqualValues(s.right, t.right);
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else if (haveEqualValues(s, t)) {
            return true;
        } else if (isSubtree(s.left, t)) {
            return true;
        } else if (isSubtree(s.right, t)) {
            return true;
        }

        return false;

    }
}
