import test from "node:test";
import assert from "node:assert/strict";
import mergeKLists, {ListNode} from './23.js';

test('mergeKLists', () => {
    [
        [
            [
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
            ],
            new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5, new ListNode(6))))))))
        ],
        [
            [],
            null
        ],
    ].forEach((testCase) => {
        let mergedList = mergeKLists(testCase[0])
        let expectedList = testCase[1];
        while (mergedList && expectedList) {
            assert.equal(mergedList.val, expectedList.val);
            mergedList = mergedList.next;
            expectedList = expectedList.next;
        }

        assert.equal(mergedList, expectedList);
    });
});

