/**
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 * If the town judge exists, then:
 * 1. The town judge trusts nobody.
 * 2. Everybody (except for the town judge) trusts the town judge.
 * 3. There is exactly one person that satisfies properties 1 and 2.
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 *
 * Example 1:
 * Input: n = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 * Input: n = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 *
 * Constraints:
 * 1 <= n <= 1000
 * 0 <= trust.length <= 104
 * trust[i].length == 2
 * All the pairs of trust are unique.
 * ai != bi
 * 1 <= ai, bi <= n
 */

/**
 * Approach:
 * Use a hashmap to keep track of trust counts per person.
 * For each trust relationship, increment the count for the person being trusted and decrement the count for the person
 * who trusts someone else.
 * The judge should have a trust count of n-1 (trusted by everyone else and trusts no one).
 * Iterate through the trust counts to find the judge.
 * Runtime: O(# of trust relationships + n). Each trust relationship is processed once, and then we iterate through
 * the (at most) n people in the trust relationship map.
 * Space: O(n)
 * @param {number} n
 * @param {number[][]} trust
 * @return {number}
 */
const findJudge = function(n, trust) {
    const trustCountsByPerson = new Map();

    for (let person = 1; person <= n; person += 1) {
        trustCountsByPerson.set(person, 0);
    }

    for (const [truster, trustee] of trust) {
        trustCountsByPerson.set(trustee, trustCountsByPerson.get(trustee) + 1);
        trustCountsByPerson.set(truster, trustCountsByPerson.get(truster) - 1);
    }

    for (const [person, trustCount] of trustCountsByPerson) {
        if (trustCount === n - 1) {
            return person;
        }
    }

    return -1;
};

export default findJudge;