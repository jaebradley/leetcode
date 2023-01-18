package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/

 * algorithms
 * Medium (56.42%)
 * Total Accepted:    43.6K
 * Total Submissions: 77.3K
 * Testcase Example:  '[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]'

 Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.


 Note:
 The number of people is less than 1,100.




 Example

 Input:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 Output:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */

public class QueueReconstructionByHeight {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? -o1[0] + o2[0] : o1[1] - o2[1]);

        LinkedList<int[]> results = new LinkedList<>();

        for (int[] person : people) {
            results.add(person[1], person);
        }

        return results.toArray(new int[people.length][]);
    }
}
