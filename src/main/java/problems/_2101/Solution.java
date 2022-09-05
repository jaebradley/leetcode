package problems._2101;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/detonate-the-maximum-bombs/
 * <p>
 * You are given a list of bombs. The range of a bomb is defined as the area where its effect can be felt. This area is in the shape of a circle with the center as the location of the bomb.
 * <p>
 * The bombs are represented by a 0-indexed 2D integer array bombs where bombs[i] = [xi, yi, ri]. xi and yi denote the X-coordinate and Y-coordinate of the location of the ith bomb, whereas ri denotes the radius of its range.
 * <p>
 * You may choose to detonate a single bomb. When a bomb is detonated, it will detonate all bombs that lie in its range. These bombs will further detonate the bombs that lie in their ranges.
 * <p>
 * Given the list of bombs, return the maximum number of bombs that can be detonated if you are allowed to detonate only one bomb.
 */

public class Solution {
    public static class Bomb {
        private final int xCoordinate;
        private final int yCoordinate;
        private final int radius;
        private final int index;

        public Bomb(final int xCoordinate, final int yCoordinate, final int radius, final int index) {
            this.xCoordinate = xCoordinate;
            this.yCoordinate = yCoordinate;
            this.radius = radius;
            this.index = index;
        }

        public int getxCoordinate() {
            return xCoordinate;
        }

        public int getyCoordinate() {
            return yCoordinate;
        }

        public int getRadius() {
            return radius;
        }

        public int getIndex() {
            return index;
        }

        public boolean willDetonate(final Bomb other) {
            return Math.pow(radius, 2) >= (Math.pow(xCoordinate - other.getxCoordinate(), 2) + Math.pow(yCoordinate - other.getyCoordinate(), 2));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Bomb bomb = (Bomb) o;
            return xCoordinate == bomb.xCoordinate && yCoordinate == bomb.yCoordinate && radius == bomb.radius && index == bomb.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(xCoordinate, yCoordinate, radius, index);
        }
    }

    public int maximumDetonation(int[][] bombs) {
        final Map<Bomb, Set<Bomb>> adjacencyList = new HashMap<>();
        for (int i = 0; i < bombs.length; i += 1) {
            final int[] firstBombDetails = bombs[i];
            final Bomb firstBomb = new Bomb(firstBombDetails[0], firstBombDetails[1], firstBombDetails[2], i);
            adjacencyList.putIfAbsent(firstBomb, new HashSet<>());

            for (int j = 0; j < bombs.length; j += 1) {
                if (i != j) {
                    final int[] secondBombDetails = bombs[j];
                    final Bomb secondBomb = new Bomb(secondBombDetails[0], secondBombDetails[1], secondBombDetails[2], j);

                    if (firstBomb.willDetonate(secondBomb)) {
                        adjacencyList.computeIfPresent(firstBomb, (bomb, bombs1) -> {
                            bombs1.add(secondBomb);
                            return bombs1;
                        });
                    }
                }
            }
        }

        final AtomicInteger maxDetonationCount = new AtomicInteger(0);

        adjacencyList
                .forEach(
                        (bomb, adjacentBombs) -> {
                            final Set<Bomb> visitedBombs = new HashSet<>(Set.of(bomb));
                            dfs(bomb, visitedBombs, adjacencyList);
                            maxDetonationCount.set(Math.max(maxDetonationCount.get(), visitedBombs.size()));
                        }
                );

        return maxDetonationCount.get();
    }

    private static void dfs(final Bomb currentBomb,
                            final Set<Bomb> detonatedBombs,
                            final Map<Bomb, Set<Bomb>> adjacencyList) {

        adjacencyList
                .getOrDefault(currentBomb, Collections.emptySet())
                .stream()
                .filter(detonatedBombs::add)
                .forEach(v -> dfs(v, detonatedBombs, adjacencyList));

    }
}
