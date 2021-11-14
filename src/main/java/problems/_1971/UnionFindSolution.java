package problems._1971;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UnionFindSolution {
    public static class DisjointSet {
        private final Map<Integer, Integer> childrenByParent;

        public DisjointSet(final int n) {
            this.childrenByParent = IntStream.rangeClosed(0, n)
                    .boxed()
                    .collect(
                            Collectors.toMap(
                                    Function.identity(),
                                    Function.identity()
                            )
                    );
        }

        private int findRoot(final int value) {
            final Integer parent = childrenByParent.get(value);
            if (value == parent) {
                return value;
            }

            final int root = findRoot(parent);
            childrenByParent.put(value, root);
            return root;
        }


        private void union(final int value1, final int value2) {
            final int root1 = findRoot(value1);
            final int root2 = findRoot(value2);

            if (root1 == root2) {
                return;
            }

            childrenByParent.put(root2, root1);
        }
    }

    public boolean validPath(int n, int[][] edges, int start, int end) {
        final DisjointSet disjointSet = new DisjointSet(n);
        for (final int[] edge : edges) {
            disjointSet.union(edge[0], edge[1]);
        }
        return disjointSet.findRoot(start) == disjointSet.findRoot(end);
    }
}
