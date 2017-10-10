package data;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeNodeTest {
    private final int value = 1;
    private final TreeNode node = new TreeNode(value, null, null);

    @Test
    public void itShouldReturnValuesViaGetters() {
        assertEquals(1, node.getValue());
        assertEquals(null, node.getLeft());
        assertEquals(null, node.getRight());
    }

    @Test
    public void identicalNodesShouldBeEqual() {
        assertEquals(new TreeNode(value, null, null), node);
    }
}