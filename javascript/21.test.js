import test from "node:test";
import assert from "node:assert/strict";
import mergeTwoLists, {ListNode} from "./21.js";

test('mergeTwoLists', () => {
    [
        [
            [
                new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4)))
            ],
            new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4))))))
        ],
        [
            [
                null,
                null
            ],
            null
        ],
        [
            [
                null,
                new ListNode(0)
            ],
            new ListNode(0)
        ],
    ].forEach((testCase) => {
        let mergedList = mergeTwoLists(...testCase[0]);
        let expectedList = testCase[1];
        while (mergedList && expectedList) {
            assert.equal(mergedList.val, expectedList.val);
            mergedList = mergedList.next;
            expectedList = expectedList.next;
        }

        assert.equal(mergedList, expectedList);
    });
});

