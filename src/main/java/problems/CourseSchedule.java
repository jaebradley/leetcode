package problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule/description/

 * algorithms
 * Medium (33.67%)
 * Total Accepted:    123K
 * Total Submissions: 363.6K
 * Testcase Example:  '2\n[[1,0]]'


 There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]


 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?


 For example:
 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 Note:

 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 You may assume that there are no duplicate edges in the input prerequisites.



 click to show more hints.

 Hints:

 This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
 Topological sort could also be done via BFS.
 */

public class CourseSchedule {
    public static boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        int[] coursePrerequisitesCount = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            coursePrerequisitesCount[prerequisite[0]]++;
        }

        Queue<Integer> completedCourses = new LinkedList<>();
        for (int i = 0; i < coursePrerequisitesCount.length; i++) {
            if (coursePrerequisitesCount[i] == 0) {
                completedCourses.add(i);
            }
        }

        int completedCount = completedCourses.size();
        while (!completedCourses.isEmpty()) {
            int completedCourse = completedCourses.remove();

            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == completedCourse) {
                    coursePrerequisitesCount[prerequisite[0]]--;
                    if (coursePrerequisitesCount[prerequisite[0]] == 0) {
                        completedCourses.add(prerequisite[0]);
                        completedCount++;
                    }
                }
            }
        }

        return completedCount == numCourses;
    }
}
