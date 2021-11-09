package problems._652;

import data.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        final List<TreeNode> duplicateNodes = new ArrayList<>();
        serialize(root, new HashMap<>(), duplicateNodes);
        return duplicateNodes;
    }

    private static String serialize(final TreeNode node, final Map<String, Integer> countsBySerialization, final List<TreeNode> duplicateNodes) {
        if (null != node) {
            final String serialization = node.val + "," + serialize(node.left, countsBySerialization, duplicateNodes) + "," + serialize(node.right, countsBySerialization, duplicateNodes);
            countsBySerialization.put(serialization, countsBySerialization.getOrDefault(serialization, 0) + 1);
            if (2 == countsBySerialization.get(serialization)) {
                duplicateNodes.add(node);
            }
            return serialization;
        }

        return "#";
    }
}
