package problems;

/**
 * https://leetcode.com/problems/coin-change/
 * <p>
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 * <p>
 * Input: coins = [1], amount = 0
 * Output: 0
 * Example 4:
 * <p>
 * Input: coins = [1], amount = 1
 * Output: 1
 * Example 5:
 * <p>
 * Input: coins = [1], amount = 2
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * <p>
 * Approach:
 * <p>
 * 1. Subproblem is something like "after taking a coin, what is the exact change from the current amount minus the coin's value"?
 * 2. Create an array where the array has a length of the amount to calculate
 * 3. A cell in the array represents the minimum amount of coins necessary to calculate the amount represented by the index of the cell
 * 4. To calculate the value at a given cell, iterate through all possible coins and see if the current amount minus any coin value
 * has a previous count - if not then it cannot be constructed from the current set of coins.
 * * If multiple coins combinations are possible, use the one that is the minimum number of coins
 * 5. The count at the end of the array should indicate the minimum number of coins needed to construct the amount
 */

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        final int[] counts = new int[amount + 1];

        for (int currentAmount = 1; currentAmount < counts.length; currentAmount++) {
            counts[currentAmount] = Integer.MAX_VALUE;
        }

        for (int currentAmount = 1; currentAmount < counts.length; currentAmount++) {
            for (final int coin : coins) {
                final int previousValue = currentAmount - coin;
                if (0 <= previousValue) {
                    if (counts[previousValue] < Integer.MAX_VALUE) {
                        counts[currentAmount] = Math.min(
                                counts[previousValue] + 1,
                                counts[currentAmount]
                        );
                    }
                }
            }
        }

        if (Integer.MAX_VALUE == counts[counts.length - 1]) {
            return -1;
        }

        return counts[counts.length - 1];
    }
}
