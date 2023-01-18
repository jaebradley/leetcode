package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/

 * algorithms
 * Medium (42.45%)
 * Total Accepted:    235.4K
 * Total Submissions: 551.9K
 * Testcase Example:  '[3,9,20,null,null,15,7]'

 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).


 For example:
 Given binary tree [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7



 return its level order traversal as:

 [
 [3],
 [9,20],
 [15,7]
 ]

 */

public class BinaryTreeLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelValues = new ArrayList<>();

        helper(root, levelValues, 0);

        return levelValues;
    }

    private static void helper(TreeNode node, List<List<Integer>> levelValues, int level) {
        if (node != null) {
            if (level >= levelValues.size()) {
                levelValues.add(new ArrayList<>());
            }

            levelValues.get(level).add(node.val);

            helper(node.left, levelValues, level + 1);
            helper(node.right, levelValues, level + 1);
        }
    }
}
