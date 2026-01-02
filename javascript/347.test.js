import test from "node:test";
import assert from "node:assert/strict";
import topKFrequent from "./347.js";

test('topKFrequent', () => {
    [
        [
            [
                [1, 1, 1, 2, 2, 3],
                2
            ],
            [1, 2]
        ],
        [
            [
                [1],
                1
            ],
            [1]
        ],
        [
            [
                [1, 2, 1, 2, 1, 2, 3, 1, 3, 2],
                2
            ],
            [1, 2]
        ],
    ].forEach((testCase) => {
        assert.deepEqual(topKFrequent(...testCase[0]), testCase[1]);
    });
});

