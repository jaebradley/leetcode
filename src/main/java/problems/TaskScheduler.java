package problems;

/**
 * https://leetcode.com/problems/task-scheduler/description/

 * algorithms
 * Medium (42.52%)
 * Total Accepted:    31.7K
 * Total Submissions: 74.7K
 * Testcase Example:  '["A","A","A","B","B","B"]\n2'

 Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

 However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

 You need to return the least number of intervals the CPU will take to finish all the given tasks.

 Example 1:

 Input: tasks = ["A","A","A","B","B","B"], n = 2
 Output: 8
 Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.



 Note:

 The number of tasks is in the range [1, 10000].
 The integer n is in the range [0, 100].
 */

public class TaskScheduler {
    /**
     * The idea, and I'm not sure I even quite get it after reading various solution explanations is that everything is
     * based off the most frequent task(s).
     *
     * The most frequent task(s) represent the "boundaries" like "A ? ? A ? ? A".
     *
     * You can see how the number of "empty" slots can be calculated by taking the count of, in this case, "A", subtracting
     * one, and multiplying it by n.
     *
     * So empty slots = (mostFrequentTask(s)Count - 1) * n.
     *
     * We will fill these empty slots with available tasks, or "idles".
     *
     * The number of available tasks is the total number of tasks minus the most frequent tasks:
     * available tasks = totalTaskCount - mostFrequentTaskCount.
     *
     * "idles" are then the maximum of zero and the difference between empty slots and available tasks:
     *
     * idles = max(0, empty slots - available tasks)
     *
     * Total length is then length of tasks + length of idles
     */

    public static int leastInterval(char[] tasks, int n) {
        int[] characterCounts = new int[26];
        int mostFrequentTasks = 0;
        int maximumFrequency = 0;

        for (char task : tasks) {
            int index = task - 'A';
            characterCounts[index]++;
            int characterCount = characterCounts[index];

            if (characterCount == maximumFrequency) {
                mostFrequentTasks++;
            } else if (characterCount > maximumFrequency) {
                mostFrequentTasks = 1;
                maximumFrequency = characterCount;
            }
        }

        int partsCount = maximumFrequency - 1;
        int partLength = n - (mostFrequentTasks - 1);
        int emptySlotsCount = partsCount * partLength;
        int availableTasks = tasks.length - (maximumFrequency * mostFrequentTasks);
        int idlesCount = Math.max(0, emptySlotsCount - availableTasks);
        return tasks.length + idlesCount;
    }
}
