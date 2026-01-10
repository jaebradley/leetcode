import test from "node:test";
import assert from "node:assert/strict";
import maxRepeating from "./1668.js";

test('maxRepeating', () => {
    [
        [
            ["ababd", "ab"],
            2
        ],
        [
            ["ababc", "ba"],
            1
        ],
        [
            ["ababc", "ac"],
            0
        ],
        [
            ["aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"],
            5
        ],
    ].forEach((testCase) => {
        assert.equal(maxRepeating(...testCase[0]), testCase[1]);
    });
});

