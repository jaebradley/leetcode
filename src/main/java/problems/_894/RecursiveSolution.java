package problems._894;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class RecursiveSolution {
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

    public List<TreeNode> allPossibleFBT(int n) {
        final List<TreeNode> results = new ArrayList<>();
        if (1 == n) {
            results.add(new TreeNode(0));
        } else if (0 != (n % 2)) {
            for (int nodes = 2; nodes <= n; nodes += 2) {
                final List<TreeNode> leftResults = allPossibleFBT(nodes - 1);
                final List<TreeNode> rightResults = allPossibleFBT(n - nodes);

                for (final Iterator<TreeNode> leftResultsIterator = leftResults.iterator(); leftResultsIterator.hasNext(); ) {
                    final TreeNode left = leftResultsIterator.next();

                    for (final Iterator<TreeNode> rightResultsIterator = rightResults.iterator(); rightResultsIterator.hasNext(); ) {
                        final TreeNode right = rightResultsIterator.next();

                        final TreeNode tree = new TreeNode(0);

                        if (rightResultsIterator.hasNext()) {
                            tree.left = clone(left);
                        } else {
                            tree.left = left;
                        }

                        if (leftResultsIterator.hasNext()) {
                            tree.right = clone(right);
                        } else {
                            tree.right = right;
                        }

                        results.add(tree);
                    }
                }
            }
        }

        return results;
    }

    private static TreeNode clone(final TreeNode tree) {
        if (null == tree) {
            return null;
        }

        final TreeNode copy = new TreeNode(0);
        copy.left = clone(tree.left);
        copy.right = clone(tree.right);

        return copy;
    }
}
