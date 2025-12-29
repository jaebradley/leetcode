import test from "node:test";
import assert from "node:assert/strict";
import minMeetingRooms from './253.js';

test('minMeetingRooms', () => {
    [
        [
            [[0,30],[5,10],[15,20]],
            2
        ],
        [
            [[7,10],[2,4]],
            1
        ],
    ].forEach((testCase) => {
        assert.deepEqual(minMeetingRooms(testCase[0]), testCase[1]);
    });
});

