package problems._1361;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Need to identify the root.
 * There should be one node that does not have a parent.
 * If there are multiple nodes without a parent, there are multiple roots, return false.
 * To identify the node without a parent, iterate over all indices, keeping track of all the child indices
 * Iterate over 0 to n-1 again, and identify all the integers that are not children - there should be exactly 1
 * Once the root is identified, iterate over the tree (starting with the root).
 * Each node should be encountered exactly once - if not, return false
 * If entire tree is traversed and every node is encountered exactly once, return true
 */

public class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        final Set<Integer> children = Stream.concat(
                        Arrays.stream(leftChild).boxed(),
                        Arrays.stream(rightChild).boxed()
                )
                .filter(v -> -1 != v)
                .collect(Collectors.toSet());
        final Set<Integer> allNodeValues = IntStream.range(0, n)
                .boxed()
                .collect(Collectors.toSet());

        allNodeValues.removeAll(children);

        if (1 != allNodeValues.size()) {
            return false;
        }

        final int rootValue = allNodeValues.stream().findFirst().get();

        final boolean[] visitedNodes = new boolean[n + 1];

        final Queue<Integer> queue = new LinkedList<>();
        queue.add(rootValue);
        visitedNodes[rootValue] = true;

        while (!queue.isEmpty()) {
            final Integer currentNode = queue.remove();
            final int leftChildValue = leftChild[currentNode];
            if (-1 != leftChildValue) {
                if (visitedNodes[leftChildValue]) {
                    return false;
                }
                visitedNodes[leftChildValue] = true;
                queue.add(leftChildValue);
            }

            final int rightChildValue = rightChild[currentNode];
            if (-1 != rightChildValue) {
                if (visitedNodes[rightChildValue]) {
                    return false;
                }
                visitedNodes[rightChildValue] = true;
                queue.add(rightChildValue);
            }
        }

        for (int i = 0; i < n; i += 1) {
            if (!visitedNodes[i]) {
                return false;
            }
        }

        return true;
    }
}
