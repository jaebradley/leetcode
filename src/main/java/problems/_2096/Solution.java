package problems._2096;

import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        final TreeNode lca = getLeastCommonAncestor(root, startValue, destValue);
        final LinkedList<Character> traversalToStartValue = new LinkedList<>();
        canTraverseFromStartToTarget(lca, startValue, traversalToStartValue);

        final LinkedList<Character> traversalToDestValue = new LinkedList<>();
        canTraverseFromStartToTarget(lca, destValue, traversalToDestValue);

        return String.
                valueOf('U')
                .repeat(traversalToStartValue.size()) +
                traversalToDestValue
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(""));
    }

    private static TreeNode getLeastCommonAncestor(final TreeNode root, final int firstChild, final int secondChild) {
        if (null == root || root.val == firstChild || root.val == secondChild) {
            return root;
        }

        final TreeNode leftLeastCommonAncestor = getLeastCommonAncestor(root.left, firstChild, secondChild);
        final TreeNode rightLeastCommonAncestor = getLeastCommonAncestor(root.right, firstChild, secondChild);

        if (null != leftLeastCommonAncestor && null != rightLeastCommonAncestor) {
            return root;
        }

        if (null != leftLeastCommonAncestor) {
            return leftLeastCommonAncestor;
        }

        return rightLeastCommonAncestor;

    }

    private static boolean canTraverseFromStartToTarget(final TreeNode start, final int target, final LinkedList<Character> previousSteps) {
        if (null != start) {
            if (start.val == target) {
                return true;
            }

            previousSteps.addLast('L');
            if (canTraverseFromStartToTarget(start.left, target, previousSteps)) {
                return true;
            }
            previousSteps.removeLast();

            previousSteps.addLast('R');
            if (canTraverseFromStartToTarget(start.right, target, previousSteps)) {
                return true;
            }
            previousSteps.removeLast();
        }

        return false;
    }

}
