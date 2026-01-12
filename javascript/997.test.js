import test from "node:test";
import assert from "node:assert/strict";
import findJudge from "./997.js";

test('findJudge', () => {
    [
        [
            [2, [[1, 2]]],
            2
        ],
        [
            [3, [[1, 3], [2, 3]]],
            3
        ],
        [
            [3, [[1, 3], [2, 3], [3, 1]]],
            -1
        ],
    ].forEach((testCase) => {
        assert.equal(findJudge(...testCase[0]), testCase[1]);
    });
});

