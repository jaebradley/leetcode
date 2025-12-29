import test from "node:test";
import assert from "node:assert/strict";
import minMeetingRooms from './253.js';

test('minMeetingRooms', () => {
    [
        [
            [[0, 30], [5, 10], [15, 20]],
            2
        ],
        [
            [[0, 30], [5, 10], [6, 100], [15, 20]],
            3
        ],
        [
            [[0, 30], [30, 100]],
            1
        ],
        [
            [[7, 10], [2, 4]],
            1
        ],
    ].forEach((testCase) => {
        assert.deepEqual(minMeetingRooms(testCase[0]), testCase[1]);
    });
});

