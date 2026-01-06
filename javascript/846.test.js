import test from "node:test";
import assert from "node:assert/strict";
import isNStraightHand from "./846.js";

test('isNStraightHand', () => {
    [
        [
            [[1,2,3,6,2,3,4,7,8], 3],
            true
        ],
        [
            [[1,2,3,4,5], 4],
            false
        ],
    ].forEach((testCase) => {
        assert.equal(isNStraightHand(...testCase[0]), testCase[1]);
    });
});

