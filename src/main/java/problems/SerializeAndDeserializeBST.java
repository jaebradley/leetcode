package problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 *
 * Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [2,1,3]
 * Output: [2,1,3]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * 0 <= Node.val <= 104
 * The input tree is guaranteed to be a binary search tree.
 *
 * Approach:
 *
 * 1. In-order traverse the BST using comma as the separator
 * 2. When deserializing, read each element in the in-order traversal serialization at a time
 * 3. Use the existing bounds to determine whether or not to process the current value - the initial upper / lower bounds
 *    and max and min integer (respectively). If the current value is not within the specified range, then don't consider it.
 * 4. When evaluating a node, the left and right subtrees will have bounds of current lower, current node value and
 *    current node value, current upper, respectively
 * 5. This way, can use the information that this is a BST to know if it's a valid left or right subtree (based on parent
 *    node's value)
 */

public class SerializeAndDeserializeBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static class Codec {
        private static final String SEPARATOR = ",";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder stringBuilder = new StringBuilder();
            serializeTree(root, stringBuilder);
            return stringBuilder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }

            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(SEPARATOR)));
            return this.deserializeTree(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private void serializeTree(TreeNode node, StringBuilder stringBuilder) {
            if (node != null) {
                stringBuilder.append(node.val).append(SEPARATOR);
                this.serializeTree(node.left, stringBuilder);
                this.serializeTree(node.right, stringBuilder);
            }
        }

        private TreeNode deserializeTree(Queue<String> queue, int floor, int ceiling) {
            if (queue.isEmpty()) {
                return null;
            }
            int value = Integer.parseInt(queue.peek());
            if (value < floor || value > ceiling) {
                return null;
            }
            queue.poll();

            TreeNode node = new TreeNode(value);

            node.left = this.deserializeTree(queue, floor, value);
            node.right = this.deserializeTree(queue, value, ceiling);

            return node;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // String tree = ser.serialize(root);
    // TreeNode ans = deser.deserialize(tree);
    // return ans;
}
