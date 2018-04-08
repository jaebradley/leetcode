package problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static problems.InorderTraversal.*;

public class InorderTraversalTest {

    @Test
    public void traverseRecursively() {
        TreeNode root = new TreeNode(1);
        TreeNode one1 = new TreeNode(2);
        TreeNode two2 = new TreeNode(3);

        root.right = one1;
        one1.left = two2;

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(3);
        expected.add(2);

        assertEquals(expected, InorderTraversal.inorderTraversalRecursive(root));
    }
}