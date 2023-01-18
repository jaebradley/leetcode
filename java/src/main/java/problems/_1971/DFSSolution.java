package problems._1971;

import java.util.*;

public class DFSSolution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        final Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        for (final int[] edge : edges) {
            final int firstValue = edge[0];
            final int secondValue = edge[1];

            final Set<Integer> firstValueRelatedNodes = adjacencyList.getOrDefault(firstValue, new HashSet<>());
            firstValueRelatedNodes.add(secondValue);
            adjacencyList.put(firstValue, firstValueRelatedNodes);
            final Set<Integer> secondValueRelatedNodes = adjacencyList.getOrDefault(secondValue, new HashSet<>());
            secondValueRelatedNodes.add(firstValue);
            adjacencyList.put(secondValue, secondValueRelatedNodes);
        }
        final Set<Integer> startingVisitedNodes = new HashSet<>();
        final Stack<Integer> nodesToVisit = new Stack<>();
        nodesToVisit.push(start);
        while (!nodesToVisit.isEmpty()) {
            final Integer currentNode = nodesToVisit.pop();
            if (currentNode == end) {
                return true;
            }

            startingVisitedNodes.add(currentNode);

            adjacencyList.getOrDefault(currentNode, new HashSet<>())
                    .stream()
                    .filter(node -> !startingVisitedNodes.contains(node))
                    .forEach(nodesToVisit::push);
        }


        return false;
    }
}
