package problems._802;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    enum State {
        UNVISITED,
        CONTAINS_CYCLE,
        DOES_NOT_CONTAIN_CYCLE,
        ;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        final List<Integer> results = new ArrayList<>();
        final List<State> nodeStates = new ArrayList<>();
        for (int node = 0; node < graph.length; node += 1) {
            nodeStates.add(State.UNVISITED);
        }
        for (int node = 0; node < graph.length; node += 1) {
            if (State.DOES_NOT_CONTAIN_CYCLE.equals(dfs(node, nodeStates, graph))) {
                results.add(node);
            }
        }
        return results;
    }

    private static State dfs(final int node, final List<State> nodeStates, final int[][] graph) {
        final State nodeState = nodeStates.get(node);
        if (!nodeState.equals(State.UNVISITED)) {
            return nodeState;
        }

        nodeStates.set(node, State.CONTAINS_CYCLE);
        final int[] adjacentNodes = graph[node];
        for (final int adjacentNode : adjacentNodes) {
            if (dfs(adjacentNode, nodeStates, graph).equals(State.CONTAINS_CYCLE)) {
                return State.CONTAINS_CYCLE;
            }
        }
        nodeStates.set(node, State.DOES_NOT_CONTAIN_CYCLE);
        return State.DOES_NOT_CONTAIN_CYCLE;
    }

}
