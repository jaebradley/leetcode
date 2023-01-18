package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.LinkedListInBinaryTree.*;

public class LinkedListInBinaryTreeTest {
    @Test
    public void testSingleMemberListThatIsNotContained() {
        assertFalse(
                new LinkedListInBinaryTree()
                        .isSubPath(
                                new ListNode(1),
                                new TreeNode(2)
                        )
        );
    }

    @Test
    public void testSingleMemberListThatIsContained() {
        assertTrue(
                new LinkedListInBinaryTree()
                        .isSubPath(
                                new ListNode(1),
                                new TreeNode(1)
                        )
        );
    }

    @Test
    public void testMultiMemberListThatIsNotContained() {
        final ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        final TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(5);

        assertFalse(
                new LinkedListInBinaryTree()
                        .isSubPath(
                                head,
                                tree
                        )
        );
    }

    @Test
    public void testMultiMemberListThatSharesSomeMembersButNotAll() {
        final ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        final TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(5);

        assertFalse(
                new LinkedListInBinaryTree()
                        .isSubPath(
                                head,
                                tree
                        )
        );
    }

    @Test
    public void testMultiMemberListThatSharesAllMembers() {
        final ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        final TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(5);

        assertTrue(
                new LinkedListInBinaryTree()
                        .isSubPath(
                                head,
                                tree
                        )
        );
    }

    @Test
    public void testMultiMemberListIsContainedInRightChildSubPathToLeaf() {
        final ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        final TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(1);
        tree.right.left = new TreeNode(2);
        tree.right.right = new TreeNode(6);
        tree.right.right.right = new TreeNode(2);

        assertTrue(
                new LinkedListInBinaryTree()
                        .isSubPath(
                                head,
                                tree
                        )
        );
    }

    @Test
    public void testMultiMemberListIsContainedInRightChildSubPathToNonLeaf() {
        final ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        final TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(1);
        tree.right.left = new TreeNode(2);
        tree.right.right = new TreeNode(6);
        tree.right.left.right = new TreeNode(10);
        tree.right.left.left = new TreeNode(11);

        assertTrue(
                new LinkedListInBinaryTree()
                        .isSubPath(
                                head,
                                tree
                        )
        );
    }

    @Test
    public void testMultiMemberListIsNotDirectlyContainedInRightChildSubPath() {
        final ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        final TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(1);
        tree.right.left = new TreeNode(3);
        tree.right.right = new TreeNode(6);
        tree.right.right.right = new TreeNode(2);

        assertFalse(
                new LinkedListInBinaryTree()
                        .isSubPath(
                                head,
                                tree
                        )
        );
    }

    @Test
    public void testLeftSubChildIsContained() {
        final ListNode head = new ListNode(1);
        head.next = new ListNode(10);

        final TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(1);
        tree.right.left = new TreeNode(10);
        tree.right.left.right = new TreeNode(2);
        tree.right.right = new TreeNode(1);

        assertTrue(
                new LinkedListInBinaryTree()
                        .isSubPath(head, tree)
        );
    }
}