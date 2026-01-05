import test from "node:test";
import assert from "node:assert/strict";
import findMinArrowShots from "./452.js";

test('findMinArrowShots', () => {
    [
        [
            [[10, 16], [2, 8], [1, 6], [7, 12]],
            2
        ],
        [
            [[1, 2], [3, 4], [5, 6], [7, 8]],
            4
        ],
        [
            [[1, 2], [2, 3], [3, 4], [4, 5]],
            2
        ],
    ].forEach((testCase) => {
        assert.equal(findMinArrowShots(testCase[0]), testCase[1]);
    });
});

