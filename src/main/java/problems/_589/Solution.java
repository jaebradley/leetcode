package problems._589;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        final List<Integer> results = new ArrayList<>();
        if (null == root) {
            return results;
        }

        final Stack<Node> nodes = new Stack<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            final Node currentNode = nodes.pop();
            results.add(currentNode.val);
            for (int i = currentNode.children.size() - 1; i >= 0; i -= 1) {
                nodes.add(currentNode.children.get(i));
            }
        }

        return results;

    }
}
