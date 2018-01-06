package data;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class AnotherListNodeTest {
    @Test
    public void itShouldCreateNode() {
        AnotherListNode node = new AnotherListNode(1);
        assertEquals(node.val, 1);
        assertEquals(node.next, null);
    }

    @Test
    public void itShouldCreateNodeWithNext() {
        AnotherListNode node1 = new AnotherListNode(2);
        AnotherListNode node = new AnotherListNode(1, node1);
        assertEquals(node.val, 1);
        assertEquals(node.next, node1);
    }

    @Test
    public void nodesShouldBeEqual() {
        AnotherListNode node = new AnotherListNode(1);
        AnotherListNode node1 = new AnotherListNode(1);
        assertEquals(node, node1);
    }

    @Test
    public void itShouldReturnCorrectHashCode() {
        AnotherListNode node = new AnotherListNode(1);
        assertEquals(Objects.hash(1, null), node.hashCode());
    }

    @Test
    public void itShouldNotEqualNonNode() {
        assertNotEquals(new AnotherListNode(1), null);
    }
}