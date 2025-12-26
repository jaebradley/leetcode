import test from "node:test";
import assert from "node:assert/strict";
import merge from './56.js';

test('merge', () => {
    assert.deepEqual(merge([[1, 3], [2, 6], [8, 10], [15, 18]]), [[1, 6], [8, 10], [15, 18]]);
    assert.deepEqual(merge([[1, 4], [4, 5]]), [[1, 5]]);
});

