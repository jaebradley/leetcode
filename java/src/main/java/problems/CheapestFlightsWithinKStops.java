package problems;

import java.util.*;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * <p>
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
 * <p>
 * Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 * <p>
 * Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The graph looks like this:
 * <p>
 * <p>
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 * Example 2:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The graph looks like this:
 * <p>
 * <p>
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
 * The size of flights will be in range [0, n * (n - 1) / 2].
 * The format of each flight will be (src, dst, price).
 * The price of each flight will be in the range [1, 10000].
 * k is in the range of [0, n - 1].
 * There will not be any duplicated flights or self cycles.
 */

public class CheapestFlightsWithinKStops {
    public static class Pair {
        private final int cost;
        private final int currentCity;

        public Pair(int cost, int currentCity) {
            this.cost = cost;
            this.currentCity = currentCity;
        }

        public int getCost() {
            return cost;
        }

        public int getCurrentCity() {
            return currentCity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return getCost() == pair.getCost() && getCurrentCity() == pair.getCurrentCity();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getCost(), getCurrentCity());
        }
    }

    public static class Tuple {
        private final int cost;
        private final int currentCity;
        private final int jumps;

        public Tuple(int cost, int currentCity, int jumps) {
            this.cost = cost;
            this.currentCity = currentCity;
            this.jumps = jumps;
        }

        public int getCost() {
            return cost;
        }

        public int getCurrentCity() {
            return currentCity;
        }

        public int getJumps() {
            return jumps;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return getCost() == tuple.getCost() && getCurrentCity() == tuple.getCurrentCity() && getJumps() == tuple.getJumps();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getCost(), getCurrentCity(), getJumps());
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int cheapestPrice = Integer.MAX_VALUE;
        Map<Integer, Set<Pair>> adjacencyList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new HashSet<>());
        }
        for (int[] flight : flights) {
            adjacencyList.putIfAbsent(flight[0], new HashSet<>());
            adjacencyList.get(flight[0]).add(new Pair(flight[2], flight[1]));
        }
        final Queue<Tuple> queue = new LinkedList<>();

        for (Pair pair : adjacencyList.get(src)) {
            queue.add(new Tuple(pair.getCost(), pair.getCurrentCity(), K));
        }

        while (!queue.isEmpty()) {
            final Tuple flight = queue.poll();
            if (flight.getCurrentCity() == dst && flight.getJumps() >= 0) {
                cheapestPrice = Math.min(flight.getCost(), cheapestPrice);
            } else if (flight.getJumps() > 0 && adjacencyList.containsKey(flight.getCurrentCity())) {
                for (Pair pair : adjacencyList.get(flight.getCurrentCity())) {
                    if (flight.getCost() + pair.getCost() < cheapestPrice) {
                        queue.add(new Tuple(flight.getCost() + pair.getCost(), pair.getCurrentCity(), flight.getJumps() - 1));
                    }
                }
            }
        }

        if (Integer.MAX_VALUE == cheapestPrice) {
            return -1;
        }

        return cheapestPrice;
    }
}
