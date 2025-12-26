/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 * Constraints:
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */

/**
 * Definition for singly-linked list.
 */
function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
}

/**
 * Create a sentinel node and keep a reference to this sentinel node.
 * For the current node of each list (starting with their respective head nodes), check to see which is bigger.
 * Whichever one is bigger, add it to the current node of the current merged list and assign the newly-created node as
 * the new current node.
 * Then for the bigger list, set the current node to the (now previous) current node's next value.
 * Do this while head references of both lists are defined.
 * Once one list is exhausted (i.e. it's current node is not defined), iterate over the other list's nodes until they
 * are added to the merged list.
 * Return the sentinel node's next parameter.
 * Runtime: O(# of nodes in the first list + # of nodes in the second list)
 * Space: O(# of nodes in the first list + # of nodes in the second list)
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
const mergeTwoLists = function (list1, list2) {
    const sentinel = new ListNode();
    let currentMergedNode = sentinel;

    while (!!list1 && !!list2) {
        if (list1.val < list2.val) {
            currentMergedNode.next = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            currentMergedNode.next = new ListNode(list2.val);
            list2 = list2.next;
        }
        currentMergedNode = currentMergedNode.next;
    }

    let definedNode = list1 || list2;
    while (!!definedNode) {
        currentMergedNode.next = new ListNode(definedNode.val);
        definedNode = definedNode.next;
        currentMergedNode = currentMergedNode.next;
    }

    return sentinel.next;
};

export default mergeTwoLists;
export {ListNode};