package problems;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/

 * algorithms
 * Medium (49.60%)
 * Total Accepted:    100.6K
 * Total Submissions: 202.8K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'


 Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].


 Note:

 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

public class TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> elementCounts = new HashMap<>();
        for (int num : nums) {
            elementCounts.merge(num, 1, (a, b) -> a + b);
        }

        LinkedList[] elementFrequencies = new LinkedList[nums.length + 1];
        for (Map.Entry<Integer, Integer> elementCount : elementCounts.entrySet()) {
            LinkedList elements = elementFrequencies[elementCount.getValue()];
            if (elements == null) {
                elements = new LinkedList<>();
                elements.add(elementCount.getKey());
                elementFrequencies[elementCount.getValue()] = elements;
            } else {
                elements.add(elementCount.getKey());
            }
        }

        List<Integer> frequentElements = new ArrayList<>();
        for (int i = elementFrequencies.length - 1; i > 0 && frequentElements.size() <= k; i--) {
            LinkedList elements = elementFrequencies[i];
            if (elements != null) {
                frequentElements.addAll(elements);
            }
        }

        return frequentElements.subList(0, k);
    }
}
