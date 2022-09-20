package problems._1697;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/
 * <p>
 * An undirected graph of n nodes is defined by edgeList, where edgeList[i] = [ui, vi, disi] denotes an edge between nodes ui and vi with distance disi. Note that there may be multiple edges between two nodes.
 * <p>
 * Given an array queries, where queries[j] = [pj, qj, limitj], your task is to determine for each queries[j] whether there is a path between pj and qj such that each edge on the path has a distance strictly less than limitj .
 * <p>
 * Return a boolean array answer, where answer.length == queries.length and the jth value of answer is true if there is a path for queries[j] is true, and false otherwise.
 * <p>
 * Approach:
 * Order queries by weight from low to high
 * Order edges by weight from low to high
 * Start processing queries
 * Add all edges with a weight that is strictly less than the query limit
 * Using Union Find, check if query can be processed as query's start and end nodes should share a parent
 */

public class Solution {
    private static class Query {
        private final int startingNode;
        private final int endingNode;
        private final int limit;
        private final int originalIndex;

        public Query(int startingNode, int endingNode, int limit, int originalIndex) {
            this.startingNode = startingNode;
            this.endingNode = endingNode;
            this.limit = limit;
            this.originalIndex = originalIndex;
        }

        public int getStartingNode() {
            return startingNode;
        }

        public int getEndingNode() {
            return endingNode;
        }

        public int getLimit() {
            return limit;
        }

        public int getOriginalIndex() {
            return originalIndex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Query query = (Query) o;
            return startingNode == query.startingNode && endingNode == query.endingNode && limit == query.limit && originalIndex == query.originalIndex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(startingNode, endingNode, limit, originalIndex);
        }
    }

    private static class UnionFind {
        private final Map<Integer, Integer> parentsByNode;

        public UnionFind(final int nodeCount) {
            this.parentsByNode = IntStream.range(0, nodeCount)
                    .boxed()
                    .collect(Collectors.toMap(Function.identity(), Function.identity()));
        }

        public int find(final int node) {
            final int parent = parentsByNode.get(node);
            if (parent == node) {
                return parent;
            }

            final int updatedParent = find(parent);
            parentsByNode.put(node, updatedParent);
            return updatedParent;
        }

        public void union(final int firstNode, final int secondNode) {
            final int firstNodeParent = find(firstNode);
            final int secondNodeParent = find(secondNode);

            if (firstNodeParent != secondNodeParent) {
                parentsByNode.put(firstNodeParent, secondNodeParent);
            }
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        final UnionFind unionFind = new UnionFind(n);
        final List<Query> sortedQueries = IntStream.range(0, queries.length)
                .boxed()
                .map(index -> Map.entry(index, queries[index]))
                .map(e -> new Query(e.getValue()[0], e.getValue()[1], e.getValue()[2], e.getKey()))
                .sorted(Comparator.comparingInt(Query::getLimit))
                .collect(Collectors.toList());
        Arrays.sort(edgeList, Comparator.comparingInt(o -> o[2]));

        final boolean[] answer = new boolean[queries.length];
        int edgeIndex = 0;
        for (final Query query : sortedQueries) {
            while (edgeIndex < edgeList.length && edgeList[edgeIndex][2] < query.getLimit()) {
                final int[] currentEdge = edgeList[edgeIndex];
                unionFind.union(currentEdge[0], currentEdge[1]);
                edgeIndex += 1;
            }

            answer[query.getOriginalIndex()] = unionFind.find(query.getStartingNode()) == unionFind.find(query.getEndingNode());
        }
        return answer;
    }
}
