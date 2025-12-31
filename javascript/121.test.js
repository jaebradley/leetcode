import test from "node:test";
import assert from "node:assert/strict";
import maxProfit from './121.js';

test('maxProfit', () => {
    [
        [
            [7, 1, 5, 3, 6, 4],
            5
        ],
        [
            [7, 6, 4, 3, 1],
            0
        ],
    ].forEach((testCase) => {
        assert.equal(maxProfit(testCase[0]), testCase[1]);
    });
});

