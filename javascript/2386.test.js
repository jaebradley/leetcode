import test from "node:test";
import assert from "node:assert/strict";
import kSum from './2386.js';

test('kSum', () => {
    [
        [
            [
                [2, 4, -2],
                5,
            ],
            2
        ],
        [
            [
                [1, -2, 3, 4, -10, 12],
                16,
            ],
            10
        ],
    ].forEach((testCase) => {
        assert.equal(kSum(...testCase[0]), testCase[1]);
    });
});

