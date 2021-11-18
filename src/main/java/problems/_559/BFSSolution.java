package problems._559;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSSolution {
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

    ;

    public int maxDepth(Node root) {
        int depth = 0;
        if (null != root) {
            final Queue<Node> nodes = new LinkedList<>();
            nodes.add(root);
            while (!nodes.isEmpty()) {
                final int currentNodesCount = nodes.size();
                for (int counter = 0; counter < currentNodesCount; counter += 1) {
                    final Node currentNode = nodes.remove();
                    if (null != currentNode.children) {
                        nodes.addAll(currentNode.children);
                    }
                }

                depth += 1;
            }
        }

        return depth;
    }
}
