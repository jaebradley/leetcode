package problems._743;

import java.util.*;

/**
 * https://leetcode.com/problems/network-delay-time/
 * <p>
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * <p>
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 * <p>
 * Djikstra Approach:
 * Keep track of visited nodes
 * Keep priority queue of all potential neighboring nodes, where the ordering is based off the node time cost value from initial node (k), ordered from lowest cost to greatest cost
 * For current node, identify neighbors, calculate time cost to go to neighboring nodes, and add to priority queue
 */

public class DijkstraSolution {
    public static class NodeTravelCost {
        private final int cost;
        private final int node;

        public NodeTravelCost(int cost, int node) {
            this.cost = cost;
            this.node = node;
        }

        public int getCost() {
            return cost;
        }

        public int getNode() {
            return node;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NodeTravelCost nodeTravelCost = (NodeTravelCost) o;
            return getCost() == nodeTravelCost.getCost() && getNode() == nodeTravelCost.getNode();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getCost(), getNode());
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        final Map<Integer, Map<Integer, Integer>> costAndEndNodesByStartingNode = new HashMap<>();
        for (final int[] time : times) {
            costAndEndNodesByStartingNode.putIfAbsent(time[0], new HashMap<>());
            costAndEndNodesByStartingNode.get(time[0]).put(time[1], time[2]);
        }
        final Set<Integer> visitedStartingNodes = new HashSet<>();
        int iterationCount = 0;
        int currentNetworkDelayTime = 0;

        // This priority queue will always guarantee that the smallest cost node is processed next, regardless if it has been processed previously
        final PriorityQueue<NodeTravelCost> nodeTravelCosts = new PriorityQueue<>(Comparator.comparingInt(NodeTravelCost::getCost));
        nodeTravelCosts.add(new NodeTravelCost(0, k));

        while (!nodeTravelCosts.isEmpty()) {
            final NodeTravelCost currentNodeTravelCost = nodeTravelCosts.poll();
            currentNetworkDelayTime = currentNodeTravelCost.getCost();

            // Even if a node has been seen previously, we don't process it
            // Since the priority queue guarantees the smallest cost node is processed at any given time, even if there
            // are multiple cost / node pairs in the priority queue that are for the same node, the lowest cost node
            // will be processed first.
            if (visitedStartingNodes.add(currentNodeTravelCost.getNode())) {
                iterationCount += 1;
                for (final Map.Entry<Integer, Integer> neighboringNodeCost : costAndEndNodesByStartingNode.getOrDefault(currentNodeTravelCost.getNode(), Collections.emptyMap()).entrySet()) {
                    nodeTravelCosts.add(new NodeTravelCost(currentNetworkDelayTime + neighboringNodeCost.getValue(), neighboringNodeCost.getKey()));
                }

                if (n == iterationCount) {
                    return currentNetworkDelayTime;
                }
            }
        }

        if (n == iterationCount) {
            return currentNetworkDelayTime;
        }

        return -1;

    }
}
