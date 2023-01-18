package problems;

import org.junit.Test;
import problems.SymmetricTree.TreeNode;

import static org.junit.Assert.*;

public class SymmetricTreeTest {

    @Test
    public void emptyTreeIsSymmetric() {
        assertTrue(SymmetricTree.isSymmetric(null));
    }

    @Test
    public void singleNodeTreeIsSymmetric() {
        assertTrue(SymmetricTree.isSymmetric(new TreeNode(1)));
    }

    @Test
    public void rootWithSingleChildIsNotSymmetric() {
        TreeNode leftChild = new TreeNode(1);
        TreeNode root = new TreeNode(0);
        root.left = leftChild;

        assertFalse(SymmetricTree.isSymmetric(root));
    }

    @Test
    public void rootWithIdenticalChildren() {
        TreeNode two0 = new TreeNode(3);
        TreeNode two1 = new TreeNode(4);
        TreeNode two2 = new TreeNode(4);
        TreeNode two3 = new TreeNode(3);
        TreeNode one0 = new TreeNode(2);
        TreeNode one1 = new TreeNode(2);
        TreeNode root = new TreeNode(1);

        root.left = one0;
        root.right = one1;
        one0.left = two0;
        one0.right = two1;
        one1.left = two2;
        one1.right = two3;

        assertTrue(SymmetricTree.isSymmetric(root));
    }
}