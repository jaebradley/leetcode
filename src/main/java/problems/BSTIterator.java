package problems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 *
 *
 * Example:
 *
 *
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 *
 *
 * Note:
 *
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
 *
 * Approach:
 *
 * 1. Add all left-most nodes to the stack - this stack will serve as the basis of the iterator
 * 2. Since all smallest values are in the stack on initialization, when getting the next value, pop off the existing
 *    value on the stack, which should be the smallest value.
 * 3. Need to process the right tree of the current node since that tree will contain the next smallest values (theoretically)
 * 4. So push all of the left-most nodes on the right tree of the current node to the stack
 */

public class BSTIterator {
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

    private final TreeNode root;
    private final Stack<TreeNode> seenNodes;

    public BSTIterator(TreeNode root) {
        this.root = root;
        this.seenNodes = new Stack<>();

        TreeNode currentLeftMostNode = this.root;
        while (currentLeftMostNode != null) {
            this.seenNodes.push(currentLeftMostNode);
            currentLeftMostNode = currentLeftMostNode.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode currentNode = this.seenNodes.pop();
        TreeNode smallestNodeInRightTree = currentNode.right;
        while (smallestNodeInRightTree != null) {
            this.seenNodes.push(smallestNodeInRightTree);
            smallestNodeInRightTree = smallestNodeInRightTree.left;
        }
        return currentNode.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.seenNodes.isEmpty();
    }
}
