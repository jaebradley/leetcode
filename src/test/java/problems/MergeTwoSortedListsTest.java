package problems;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class MergeTwoSortedListsTest {
    @Test
    public void mergeTwoLists() {
        ListNode merged = new MergeTwoSortedLists().mergeTwoLists(
                new ListNode(
                        1,
                        new ListNode(
                                2,
                                new ListNode(4)
                        )
                ),
                new ListNode(
                        1,
                        new ListNode(
                                3,
                                new ListNode(4)
                        )
                )

        );
        assertEquals(merged.val, 1);
        assertEquals(merged.next.val, 1);
        assertEquals(merged.next.next.val, 2);
        assertEquals(merged.next.next.next.val, 3);
        assertEquals(merged.next.next.next.next.val, 4);
        assertEquals(merged.next.next.next.next.next.val, 4);
    }

    @Test
    public void testEmptyLists() {
        ListNode merged = new MergeTwoSortedLists().mergeTwoLists(null, null);
        assertEquals(merged, null);
    }

    @Test
    public void testEmptyList() {
        ListNode merged = new MergeTwoSortedLists().mergeTwoLists(
                new ListNode(
                        1,
                        new ListNode(
                                3,
                                new ListNode(5)
                        )
                ),
                null
        );
        assertEquals(merged.val, 1);
        assertEquals(merged.next.val, 3);
        assertEquals(merged.next.next.val, 5);
    }

    @Test
    public void testListsOfDifferentSize() {
        ListNode merged = new MergeTwoSortedLists().mergeTwoLists(
                new ListNode(
                        1,
                        new ListNode(
                                3,
                                new ListNode(5)
                        )
                ),
                new ListNode(4)
        );
        assertEquals(merged.val, 1);
        assertEquals(merged.next.val, 3);
        assertEquals(merged.next.next.val, 4);
        assertEquals(merged.next.next.next.val, 5);
    }
}
