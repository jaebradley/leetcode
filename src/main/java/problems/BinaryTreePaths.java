package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/description/

 * algorithms
 * Easy (41.14%)
 * Total Accepted:    154.7K
 * Total Submissions: 375.5K
 * Testcase Example:  '[1,2,3,null,5]'


 Given a binary tree, return all root-to-leaf paths.


 For example, given the following binary tree:



 1
 /   \
 2     3
 \
 5



 All root-to-leaf paths are:
 ["1->2->5", "1->3"]


 Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */

public class BinaryTreePaths {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static boolean isLeafNode(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    private static List<String> buildPaths(TreeNode node, String currentPath) {
        if (node == null) {
            return new ArrayList<>();
        }

        List<String> paths = new ArrayList<>();

        String newPath;
        if (currentPath.isEmpty()) {
            newPath = String.valueOf(node.val);
        } else {
            newPath = currentPath + "->" + node.val;
        }

        if (isLeafNode(node)) {
            paths.add(newPath);
        } else {
            paths.addAll(buildPaths(node.left, newPath));
            paths.addAll(buildPaths(node.right, newPath));
        }

        return paths;
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        return buildPaths(root, "");
    }
}
