package problems;

public class SubtreeOfAnotherTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean haveEqualValues(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }

        return s.val == t.val
                && haveEqualValues(s.left, t.left)
                && haveEqualValues(s.right, t.right);
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else if (haveEqualValues(s, t)) {
            return true;
        } else if (isSubtree(s.left, t)) {
            return true;
        } else if (isSubtree(s.right, t)) {
            return true;
        }

        return false;

    }
}
