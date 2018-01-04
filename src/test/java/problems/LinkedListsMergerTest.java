package problems;

import data.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListsMergerTest {

    private final ListNode<Integer> firstList2 = new ListNode<>(4, null);
    private final ListNode<Integer> firstList1 = new ListNode<>(2, firstList2);
    private final ListNode<Integer> firstList0 = new ListNode<>(1, firstList1);

    private final ListNode<Integer> secondList2 = new ListNode<>(5, null);
    private final ListNode<Integer> secondList1 = new ListNode<>(3, secondList2);
    private final ListNode<Integer> secondList0 = new ListNode<>(1, secondList1);

    @Test
    public void itShouldReturnMergedListsSameLength() {
        ListNode<Integer> mergedLists = LinkedListsMerger.merge(firstList0, secondList0);
        assertEquals(mergedLists.getValue(), Integer.valueOf(1));
        assertEquals(mergedLists.getNext().getValue(), Integer.valueOf(1));
        assertEquals(mergedLists.getNext().getNext().getValue(), Integer.valueOf(2));
        assertEquals(mergedLists.getNext().getNext().getNext().getValue(), Integer.valueOf(3));
        assertEquals(mergedLists.getNext().getNext().getNext().getNext().getValue(), Integer.valueOf(4));
        assertEquals(mergedLists.getNext().getNext().getNext().getNext().getNext().getValue(), Integer.valueOf(5));
        assertEquals(mergedLists.getNext().getNext().getNext().getNext().getNext().getNext(), null);
    }

    @Test
    public void itShouldReturnNullForTwoNullLists() {
        assertNull(LinkedListsMerger.merge(null, null));
    }

    @Test
    public void itShouldReturnSecondListForNullFirstList() {
        assertEquals(secondList0, LinkedListsMerger.merge(null, secondList0));
    }

    @Test
    public void itShouldReturnFirstListForNullSecondList() {
        assertEquals(firstList0, LinkedListsMerger.merge(firstList0, null));
    }
}