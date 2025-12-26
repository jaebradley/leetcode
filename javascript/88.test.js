import test from "node:test";
import assert from "node:assert/strict";
import merge from './88.js';

test('merge', () => {
    [
        [
            [
                [1, 2, 3, 0, 0, 0],
                3,
                [2, 5, 6],
                3
            ],
            [1, 2, 2, 3, 5, 6]
        ],
        [
            [
                [1],
                1,
                [],
                0
            ],
            [1]
        ],
        [
            [
                [0],
                0,
                [1],
                1,
            ],
            [1]
        ],
    ].forEach((testCase) => {
        merge(...testCase[0])
        assert.deepEqual(testCase[0][0], testCase[1]);
    });
});

