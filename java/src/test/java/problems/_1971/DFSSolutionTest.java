package problems._1971;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/find-if-path-exists-in-graph/
 * <p>
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 * <p>
 * You want to determine if there is a valid path that exists from vertex start to vertex end.
 * <p>
 * Given edges and the integers n, start, and end, return true if there is a valid path from start to end, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], start = 0, end = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 * - 0 → 1 → 2
 * - 0 → 2
 * Example 2:
 * <p>
 * <p>
 * Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], start = 0, end = 5
 * Output: false
 * Explanation: There is no path from vertex 0 to vertex 5.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 2 * 105
 * 0 <= edges.length <= 2 * 105
 * edges[i].length == 2
 * 0 <= ui, vi <= n - 1
 * ui != vi
 * 0 <= start, end <= n - 1
 * There are no duplicate edges.
 * There are no self edges.
 */

public class DFSSolutionTest {

    @Test
    public void test() {
        assertTrue(new DFSSolution().validPath(
                        3,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{1, 2},
                                new int[]{2, 0},
                        },
                        0,
                        2
                )
        );

        assertFalse(
                new DFSSolution().validPath(
                        6,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{0, 2},
                                new int[]{3, 5},
                                new int[]{5, 4},
                                new int[]{4, 3}
                        },
                        0,
                        5
                )
        );

        assertTrue(
                new DFSSolution().validPath(
                        10,
                        new int[][]{
                                new int[]{0, 7},
                                new int[]{0, 8},
                                new int[]{6, 1},
                                new int[]{2, 0},
                                new int[]{0, 4},
                                new int[]{5, 8},
                                new int[]{4, 7},
                                new int[]{1, 3},
                                new int[]{3, 5},
                                new int[]{6, 5}
                        },
                        7,
                        5
                )
        );
    }
}