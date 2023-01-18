package problems._399;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 * <p>
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 * <p>
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 * <p>
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * Example 2:
 * <p>
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 * <p>
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */

public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        final Map<String, String> parentsByNode = new HashMap<>();
        final Map<String, Double> factorByNode = new HashMap<>();
        for (int index = 0; index < equations.size(); index += 1) {
            final double value = values[index];
            final List<String> equation = equations.get(index);

            final String identifier1 = equation.get(0);
            final String identifier2 = equation.get(1);

            parentsByNode.putIfAbsent(identifier1, identifier1);
            parentsByNode.putIfAbsent(identifier2, identifier2);

            factorByNode.putIfAbsent(identifier1, 1.0);
            factorByNode.putIfAbsent(identifier2, 1.0);

            final String root1 = findRoot(identifier1, parentsByNode, factorByNode);
            final String root2 = findRoot(identifier2, parentsByNode, factorByNode);

            parentsByNode.put(root1, root2);
            factorByNode.put(root1, factorByNode.get(identifier2) * value / factorByNode.get(identifier1));
        }

        final double[] results = new double[queries.size()];

        for (int index = 0; index < queries.size(); index += 1) {
            final List<String> query = queries.get(index);
            final String identifier1 = query.get(0);
            final String identifier2 = query.get(1);

            if (parentsByNode.containsKey(identifier1) && parentsByNode.containsKey(identifier2)) {
                final String root1 = findRoot(identifier1, parentsByNode, factorByNode);
                final String root2 = findRoot(identifier2, parentsByNode, factorByNode);

                if (root1.equals(root2)) {
                    results[index] = factorByNode.get(identifier1) / factorByNode.get(identifier2);
                    continue;
                }
            }
            results[index] = -1;
        }

        return results;
    }

    private static String findRoot(final String value, final Map<String, String> parentsByNode, final Map<String, Double> factorsByNode) {
        final String parent = parentsByNode.get(value);
        if (parent.equals(value)) {
            return value;
        }

        final String root = findRoot(parent, parentsByNode, factorsByNode);
        factorsByNode.put(value, factorsByNode.get(value) * factorsByNode.get(parent));
        parentsByNode.put(value, root);
        return root;
    }
}
