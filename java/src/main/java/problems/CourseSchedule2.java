package problems;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule-ii/description/

 * algorithms
 * Medium (30.15%)
 * Total Accepted:    88.5K
 * Total Submissions: 293K
 * Testcase Example:  '2\n[[1,0]]'

 There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 For example:


 2, [[1,0]]

 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]


 4, [[1,0],[2,0],[3,1],[3,2]]

 There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 shouldbe taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

 Note:


 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 You may assume that there are no duplicate edges in the input prerequisites.




 click to show more hints.

 Hints:


 This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological orderingexists and therefore it will be impossible to take all courses.
 Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
 Topological sort could also be done via BFS.

 */

public class CourseSchedule2 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, LinkedList<Integer>> coursePrerequisites = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            coursePrerequisites.put(i, new LinkedList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int courseIndex = prerequisite[0];
            int coursePrerequisiteIndex = prerequisite[1];
            LinkedList<Integer> coursePrerequisite = coursePrerequisites.get(courseIndex);
            coursePrerequisite.add(coursePrerequisiteIndex);
            coursePrerequisites.put(courseIndex, coursePrerequisite);
        }

        Set<Integer> visitedCourses = new HashSet<>();
        Set<Integer> coursesInPath = new HashSet<>();
        Stack<Integer> courses = new Stack<>();
        List<Integer> orderedCourses = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            boolean hasCycle = processCourseIndex(i, visitedCourses, coursePrerequisites, courses, orderedCourses, coursesInPath);
            if (hasCycle) {
                return new int[]{};
            }
        }

        int[] orderedCoursesArray = new int[numCourses];
        for (int i = 0; i < orderedCourses.size(); i++) {
            orderedCoursesArray[i] = orderedCourses.get(i);
        }
        return orderedCoursesArray;
    }

    private static boolean processCourseIndex(int courseIndex, Set<Integer> visitedCourses, Map<Integer, LinkedList<Integer>> coursePrerequisites, Stack<Integer> courses, List<Integer> orderedCourses, Set<Integer> coursesInPath) {
        if (coursesInPath.contains(courseIndex)) {
            return true;
        }

        coursesInPath.add(courseIndex);

        if (!visitedCourses.contains(courseIndex)) {
            courses.push(courseIndex);
            LinkedList<Integer> coursePrerequisiteIndices = coursePrerequisites.get(courseIndex);
            if (coursePrerequisiteIndices == null) {
                visitedCourses.add(courseIndex);
                orderedCourses.add(courseIndex);
                courses.pop();
            } else {
                for (Integer coursePrerequisiteIndex : coursePrerequisiteIndices) {
                    boolean hasCycle = processCourseIndex(coursePrerequisiteIndex, visitedCourses, coursePrerequisites, courses, orderedCourses, coursesInPath);
                    if (hasCycle) {
                        return true;
                    }
                }

                visitedCourses.add(courseIndex);
                orderedCourses.add(courseIndex);
                courses.pop();
            }
        }

        coursesInPath.remove(courseIndex);
        return false;
    }
}
