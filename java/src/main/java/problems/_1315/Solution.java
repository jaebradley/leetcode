package problems._1315;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

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

    public int sumEvenGrandparent(TreeNode root) {
        final AtomicInteger sum = new AtomicInteger(0);
        helper(root, sum);
        return sum.get();
    }

    private static void helper(final TreeNode currentNode, final AtomicInteger sum) {
        if (null != currentNode) {
            if (0 == (currentNode.val % 2)) {
                Stream.of(
                        Optional.ofNullable(currentNode.left),
                        Optional.ofNullable(currentNode.right)
                )
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .flatMap(parent -> Stream.of(
                                Optional.ofNullable(parent.left),
                                Optional.ofNullable(parent.right)))
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .map(grandchild -> grandchild.val)
                        .reduce(Integer::sum)
                        .ifPresent(sum::addAndGet);
            }

            helper(currentNode.left, sum);
            helper(currentNode.right, sum);
        }
    }
}
