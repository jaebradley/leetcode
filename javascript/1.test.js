import test from "node:test";
import assert from "node:assert/strict";
import twoSum from './1.js';

test('twoSum', () => {
    [
        [
            [
                [2, 7, 11, 15],
                9,
            ],
            [0, 1]
        ],
        [
            [
                [3, 2, 4],
                6,
            ],
            [1, 2]
        ],
        [
            [
                [3, 3],
                6,
            ],
            [0, 1]
        ],
    ].forEach((testCase) => {
        assert.deepEqual(twoSum(...testCase[0]), testCase[1]);
    });
});

