/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted linked list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 * Input: lists = []
 * Output: []
 * Example 3:
 * Input: lists = [[]]
 * Output: []
 *
 *
 * Constraints:
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 */

/**
 * Definition for singly-linked list.
 */
function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
}

/**
 * Heap property: every child node satisfies the specified comparator relative to its parent node. In other words,
 * the child node is less than (or greater than) its parent node. Thus, the root node is always the minimum (or maximum)
 * element in the heap.
 * Complete binary tree: Each level must be filled before moving to the next level, and if a level is not filled, the
 * leaves must be positioned as far left as possible.
 */
class Heap {
    constructor(comparator) {
        this.comparator = comparator;
        this.values = [];
    }

    #getParentIndex(index) {
        return Math.floor((index - 1) / 2);
    }

    #getLeftChildIndex(index) {
        return (index * 2) + 1;
    }

    #getRightChildIndex(index) {
        return (index * 2) + 2;
    }

    #swapValues(fromIndex, toIndex) {
        const fromValue = this.values[fromIndex];
        this.values[fromIndex] = this.values[toIndex];
        this.values[toIndex] = fromValue;
    }

    #isLeaf(index) {
        return index >= Math.floor(this.values.length / 2) && index <= (this.values.length - 1);
    }

    add(value) {
        this.values.push(value);
        let currentIndex = this.values.length - 1;
        let parentIndex = this.#getParentIndex(currentIndex);

        while (currentIndex > 0 && this.comparator(value, this.values[parentIndex]) < 0) {
            this.#swapValues(parentIndex, currentIndex);
            currentIndex = parentIndex;
            parentIndex = this.#getParentIndex(currentIndex);
        }
    }

    #heapifyDown(index) {
        if (!this.#isLeaf(index)) {
            const leftChildIndex = this.#getLeftChildIndex(index);
            const rightChildIndex = this.#getRightChildIndex(index);

            const largerIndex = rightChildIndex > this.values.length - 1 ? leftChildIndex : (this.comparator(this.values[leftChildIndex], this.values[rightChildIndex]) > 0 ? leftChildIndex : rightChildIndex);
            if (this.comparator(this.values[index], this.values[largerIndex]) < 0) {
                this.#swapValues(largerIndex, index);
                this.#heapifyDown(largerIndex);
            }
        }
    }

    pop() {
        if (this.values.length > 0) {
            const topValue = this.values[0];
            const lastValue = this.values.pop();

            if (this.values.length > 1) {
                this.values[0] = lastValue;
                this.#heapifyDown(0);
            }

            return topValue;
        }
    }

    isEmpty() {
        return this.values.length <= 0;
    }
}

/**
 * Approach:
 * Create a sentinel "head" for the combined linked list.
 * Initialize a min-heap.
 * Add the first element from each of the k linked lists to the heap. As part of the element, keep track of which heap
 * the element value was from.
 * If the heap is non-empty, create a next node and make the "current node" pointer reference the newly-created noe.
 * Pop off the heap and add the popped value to the merged linked list by assigning it to the value of the
 * referenced current node.
 * For the popped value, add the next value in the linked list where the value originated from.
 * If the originating list is empty add a value from the next non-empty list.
 * Continue with this process until the heap is empty.
 * Return sentinel.next
 *
 * Runtime: O(# of total combined list elements x log (# of total combined list elements))
 * Will need to add each list element to heap and pop each list element off the heap. Both operations are log n. Will
 * need to execute each operation n times.
 * Space: At any given time during program execution, there will be a fixed number of pointers. This is considered O(1).
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
const mergeKLists = function (lists) {
    const heap = new Heap(
        (a, b) => (a[0] - b[0])
    );
    const listsByCurrentNode = new Map(lists.filter(list => !!list).map((list, index) => ([index, list])));

    listsByCurrentNode.forEach((value, index) => {
        heap.add([value.val, index]);
        listsByCurrentNode.set(index, value.next);
    });
    let currentMergedListNode = new ListNode();
    const sentinel = currentMergedListNode;
    while (!heap.isEmpty()) {
        const [value, index] = heap.pop();
        currentMergedListNode.next = new ListNode(value);
        currentMergedListNode = currentMergedListNode.next;

        const originatingListNode = listsByCurrentNode.get(index);
        if (originatingListNode) {
            heap.add([originatingListNode.val, index]);
            listsByCurrentNode.set(index, originatingListNode.next);
        }
    }

    return sentinel.next;

};

export {ListNode};
export default mergeKLists;