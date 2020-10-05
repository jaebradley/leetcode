package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-the-town-judge/
 *
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 *
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 *
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 *
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * Example 4:
 *
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * Example 5:
 *
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= N <= 1000
 * 0 <= trust.length <= 10^4
 * trust[i].length == 2
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 *
 * Approach:
 * 1. Graph where single value has N - 1 directed edges that point towards it
 * 2. When processing arrays [person who trusts, person they trust], add the first element to the adjacency matrix for the second element
 * 3. Iterate through adjacency matrix and return if Set of people has a size that is N - 1
 * 4. If cannot identify person in adjacency matrix, return -1
 *
 * Approach:
 *
 * 1. Graph is directed so find where in-degree - out-degree = N - 1
 * 2. in-degree is calculated in an array the size of N where each entry is the count of the number of times that person
 *    is trusted
 * 3. out-degree is calculated in an array the size of N where each entry is the count of the number of times a person
 *    trusts another person
 */

public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        Map<Integer, Set<Integer>> personToTrustees = new HashMap<>();
        Set<Integer> trustingPeople = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            personToTrustees.put(i, new HashSet<>());
        }

        for (int[] trustRelationship : trust) {
            trustingPeople.add(trustRelationship[0]);
            if (personToTrustees.containsKey(trustRelationship[1])) {
                personToTrustees.get(trustRelationship[1]).add(trustRelationship[0]);
            } else {
                Set<Integer> distinctTrustees = new HashSet<>();
                distinctTrustees.add(trustRelationship[0]);
                personToTrustees.put(trustRelationship[1], distinctTrustees);
            }
        }
        Set<Integer> potentialJudges = new HashSet<>();
        for (Map.Entry<Integer, Set<Integer>> entry : personToTrustees.entrySet()) {
           if (!trustingPeople.contains(entry.getKey()) && entry.getValue().size() == N - 1) {
               potentialJudges.add(entry.getKey());
           }
        }

        if (potentialJudges.size() == 1) {
            return potentialJudges.iterator().next();
        }

        return -1;
    }

    public int findJudgeInDegreeOutDegree(int N, int[][] trust) {
        int[] inDegrees = new int[N + 1];
        int[] outDegrees = new int[N + 1];

        for (int[] trustRelationship : trust) {
            outDegrees[trustRelationship[0]]++;
            inDegrees[trustRelationship[1]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (inDegrees[i] - outDegrees[i] == N - 1) {
                return i;
            }
        }

        return -1;
    }
}
