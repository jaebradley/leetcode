package problems;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have direct prerequisites, for example, to take course 0 you have first to take course 1, which is expressed as a pair: [1,0]
 *
 * Given the total number of courses n, a list of direct prerequisite pairs and a list of queries pairs.
 *
 * You should answer for each queries[i] whether the course queries[i][0] is a prerequisite of the course queries[i][1] or not.
 *
 * Return a list of boolean, the answers to the given queries.
 *
 * Please note that if course a is a prerequisite of course b and course b is a prerequisite of course c, then, course a is a prerequisite of course c.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
 * Output: [false,true]
 * Explanation: course 0 is not a prerequisite of course 1 but the opposite is true.
 * Example 2:
 *
 * Input: n = 2, prerequisites = [], queries = [[1,0],[0,1]]
 * Output: [false,false]
 * Explanation: There are no prerequisites and each course is independent.
 * Example 3:
 *
 *
 * Input: n = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
 * Output: [true,true]
 * Example 4:
 *
 * Input: n = 3, prerequisites = [[1,0],[2,0]], queries = [[0,1],[2,0]]
 * Output: [false,true]
 * Example 5:
 *
 * Input: n = 5, prerequisites = [[0,1],[1,2],[2,3],[3,4]], queries = [[0,4],[4,0],[1,3],[3,0]]
 * Output: [true,false,true,false]
 *
 *
 * Constraints:
 *
 * 2 <= n <= 100
 * 0 <= prerequisite.length <= (n * (n - 1) / 2)
 * 0 <= prerequisite[i][0], prerequisite[i][1] < n
 * prerequisite[i][0] != prerequisite[i][1]
 * The prerequisites graph has no cycles.
 * The prerequisites graph has no repeated edges.
 * 1 <= queries.length <= 10^4
 * queries[i][0] != queries[i][1]
 *
 * Approach:
 *
 * 1. Create adjacency list
 * 2. Create Map of a Tuple of each query's prerequisite course and its final course and a boolean indicating if the relationship
 *    exists.
 * 3. Traverse the adjacency list starting at the first element in the adjacency list
 * 4. For each element, traverse the entire portion of the graph that starts at that element
 * 5. Keep track of visited tuples to avoid cycles
 * 6. Keep track of any queries that are identified along the way
 * 7. For each query, see if the result is a boolean or not
 */

import java.util.*;
import java.util.stream.Collectors;

public class CourseSchedule4 {
    public static class Query {
        private final int prerequisiteCourse;
        private final int currentCourse;

        public Query(int prerequisiteCourse, int currentCourse) {
            this.prerequisiteCourse = prerequisiteCourse;
            this.currentCourse = currentCourse;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Query query = (Query) o;
            return prerequisiteCourse == query.prerequisiteCourse && currentCourse == query.currentCourse;
        }

        @Override
        public int hashCode() {
            return Objects.hash(prerequisiteCourse, currentCourse);
        }
    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        final Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        for (final int[] prereqs : prerequisites) {
            adjacencyList.putIfAbsent(prereqs[0], new HashSet<>());
            adjacencyList.get(prereqs[0]).add(prereqs[1]);
        }

        final Map<Query, Boolean> queryResults = new HashMap<>();
        for (final int[] query : queries) {
            queryResults.putIfAbsent(
                    new Query(query[0], query[1]),
                    Boolean.FALSE
            );
        }

        for (int currentStartingCourse = 0; currentStartingCourse < n; currentStartingCourse++) {
            final Set<Integer> visitedCourses = new HashSet<>();
            final Queue<Integer> nextCourses = new LinkedList<>();
            if (null != adjacencyList.get(currentStartingCourse)) {
                nextCourses.addAll(adjacencyList.get(currentStartingCourse));
            }

            while (!nextCourses.isEmpty()) {
                final int nextCourse = nextCourses.poll();
                if (!visitedCourses.contains(nextCourse)) {
                    visitedCourses.add(nextCourse);
                    final Query query = new Query(currentStartingCourse, nextCourse);
                    if (queryResults.containsKey(query)) {
                        queryResults.put(query, Boolean.TRUE);
                    }
                    if (null != adjacencyList.get(nextCourse)) {
                        nextCourses.addAll(adjacencyList.get(nextCourse));
                    }
                }
            }
        }

        return Arrays.stream(queries)
                .map(query -> new Query(query[0], query[1]))
                .map(query -> null != queryResults.get(query) && Boolean.TRUE == queryResults.get(query))
                .collect(Collectors.toList());
    }
}
