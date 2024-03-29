package data;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class TreeNodeTest {
    private final int value = 1;
    private final TreeNode node = new TreeNode(value, null, null);

    @Test
    public void itShouldReturnValuesViaGetters() {
        assertEquals(1, node.getVal());
        assertEquals(null, node.getLeft());
        assertEquals(null, node.getRight());
    }

    @Test
    public void identicalNodesShouldBeEqual() {
        assertEquals(new TreeNode(value, null, null), node);
    }

    @Test
    public void nonIdenticalNodesShouldNotBeEqual() {
        assertNotEquals(new TreeNode(2, null, null), node);
    }

    @Test
    public void identicalNodesShouldHaveSameHashCode() {
        assertEquals(new TreeNode(value, null, null).hashCode(), node.hashCode());
    }

    @Test
    public void shouldNotEqualNull() {
        assertNotEquals(node, null);
    }

    @Test
    public void shouldNotEqualOtherClass() {
        assertNotEquals(1, node);
    }

    @Test
    public void testHashCodeValue() {
        assertEquals(Objects.hash(node.getVal(), node.getLeft(), node.getRight()), node.hashCode());
    }
}