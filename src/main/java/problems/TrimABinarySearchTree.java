package problems;

/**
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 *
 * Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.
 *
 * Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,0,2], low = 1, high = 2
 * Output: [1,null,2]
 * Example 2:
 *
 *
 * Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
 * Output: [3,2,null,1]
 * Example 3:
 *
 * Input: root = [1], low = 1, high = 2
 * Output: [1]
 * Example 4:
 *
 * Input: root = [1,null,2], low = 1, high = 3
 * Output: [1,null,2]
 * Example 5:
 *
 * Input: root = [1,null,2], low = 2, high = 4
 * Output: [2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree in the range [1, 104].
 * 0 <= Node.val <= 104
 * The value of each node in the tree is unique.
 * root is guaranteed to be a valid binary search tree.
 * 0 <= low <= high <= 104
 *
 * Approach:
 *
 * 1. Because BSTs have all values greater than it on the right and all values smaller than it on the left, when trimming,
 * 2. If a node's value is less than the floor, evaluate the right tree (since the left tree will always be smaller)
 * 3. If a node's value is greater than the ceiling, evaluate the left tree
 * 4. If node is in range, return the node after processing left and right subtrees and assigning their respective
 *    returned roots to the right / left subtree references on the current node
 * 5. The implementation can be recursive so that the trimmed tree at a given node is the trimmed right tree and the
 *    trimmed left tree (where the trim function is applied recursively to these subtrees)
 */

public class TrimABinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val > high) {
            return this.trimBST(root.left, low, high);
        } else if (root.val < low) {
            return this.trimBST(root.right, low, high);
        }

        root.right = this.trimBST(root.right, low, high);
        root.left = this.trimBST(root.left, low, high);

        return root;
    }
}
