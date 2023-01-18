package problems;

import data.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectionOfTwoLinkedListsTest {
    private final ListNode<Integer> independentA2 = new ListNode<>(2, null);
    private final ListNode<Integer> independentA1 = new ListNode<>(1, independentA2);
    private final ListNode<Integer> independentA = new ListNode<>(0, independentA1);

    private final ListNode<Integer> independentB2 = new ListNode<>(2, null);
    private final ListNode<Integer> independentB1 = new ListNode<>(1, independentB2);
    private final ListNode<Integer> independentB = new ListNode<>(0, independentB1);

    private final ListNode<Integer> A1 = new ListNode<>(1, independentA);
    private final ListNode<Integer> A = new ListNode<>(0, A1);

    private final ListNode<Integer> B2 = new ListNode<>(2, independentA);
    private final ListNode<Integer> B1 = new ListNode<>(1, B2);
    private final ListNode<Integer> B = new ListNode<>(0, B1);

    @Test
    public void itShouldReturnNullForNonIntersectingLists() {
        assertNull(IntersectionOfTwoLinkedLists.getIntersectionNode(independentA, independentB));
    }

    @Test
    public void itShouldReturnIntersectionNode() {
        assertEquals(independentA, IntersectionOfTwoLinkedLists.getIntersectionNode(A, B));
    }
}