package problems;

import org.junit.Test;
import problems.SerializeAndDeserializeBST.Codec;
import problems.SerializeAndDeserializeBST.TreeNode;

import static org.junit.Assert.*;

public class SerializeAndDeserializeBSTTest {
    @Test
    public void testSerializeEmptyTree() {
        assertEquals("", new Codec().serialize(null));
    }

    @Test
    public void testSerializeSingleRootTree() {
        assertEquals("1,", new Codec().serialize(new TreeNode(1)));
    }

    @Test
    public void testSerializeRootAndRightTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        assertEquals("1,2,", new Codec().serialize(root));
    }

    @Test
    public void testSerializeRootAndLeftTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        assertEquals("1,0,", new Codec().serialize(root));
    }

    @Test
    public void testRightSubtreeWithSingleChild() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        assertEquals("1,2,3,", new Codec().serialize(root));
    }

    @Test
    public void testLeftSubtreeWithSingleChild() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);

        assertEquals("3,2,1,", new Codec().serialize(root));
    }

    @Test
    public void testFullTwoLevelTree() {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(20);
        root.right.left = new TreeNode(7);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);

        assertEquals("5,3,2,4,10,7,20,", new Codec().serialize(root));
    }

    @Test
    public void testDeserializeEmptyTree() {
        assertNull(new Codec().deserialize(""));
    }

    @Test
    public void testDeserializeSingleRootTree() {
        TreeNode tree = new Codec().deserialize("1,");
        assertEquals(tree.val, 1);
        assertNull(tree.left);
        assertNull(tree.right);
    }

    @Test
    public void testDeserializeRootAndRightTree() {
        TreeNode tree = new Codec().deserialize("1,2,");
        assertEquals(tree.val, 1);
        assertNull(tree.left);
        assertEquals(2, tree.right.val);
    }

    @Test
    public void testDeserializeRootAndLeftTree() {
        TreeNode tree = new Codec().deserialize("1,0,");
        assertEquals(tree.val, 1);
        assertNull(tree.right);
        assertEquals(0, tree.left.val);
    }

    @Test
    public void testDeserializeRightSubtreeWithSingleChild() {
        TreeNode tree = new Codec().deserialize("1,2,3,");
        assertEquals(tree.val, 1);
        assertNull(tree.left);
        assertEquals(2, tree.right.val);
        assertNull(tree.right.left);
        assertEquals(3, tree.right.right.val);
        assertNull(tree.right.right.left);
    }

    @Test
    public void testDeserializeLeftSubtreeWithSingleChild() {
        TreeNode tree = new Codec().deserialize("3,2,1,");
        assertEquals(3, tree.val);
        assertEquals(2, tree.left.val);
        assertEquals(1, tree.left.left.val);

        assertNull(tree.right);
        assertNull(tree.left.right);
    }

    @Test
    public void testDeserializeFullTwoLevelTree() {
        TreeNode tree = new Codec().deserialize("5,3,2,4,10,7,20,");
        assertEquals(5, tree.val);
        assertEquals(3, tree.left.val);
        assertEquals(2, tree.left.left.val);
        assertEquals(4, tree.left.right.val);

        assertNull(tree.left.left.left);
        assertNull(tree.left.left.right);
        assertNull(tree.left.right.left);
        assertNull(tree.left.right.right);

        assertEquals(10, tree.right.val);
        assertEquals(7, tree.right.left.val);
        assertEquals(20, tree.right.right.val);

        assertNull(tree.right.left.left);
        assertNull(tree.right.left.right);
        assertNull(tree.right.right.left);
        assertNull(tree.right.right.right);
    }
}