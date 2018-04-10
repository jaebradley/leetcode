package problems;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

 * algorithms
 * Easy (42.85%)
 * Total Accepted:    284.4K
 * Total Submissions: 662.7K
 * Testcase Example:  '[7,1,5,3,6,4]'

 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Example 1:

 Input: [7, 1, 5, 3, 6, 4]
 Output: 5

 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)



 Example 2:

 Input: [7, 6, 4, 3, 1]
 Output: 0

 In this case, no transaction is done, i.e. max profit = 0.
 */

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int[] priceDifferences = new int[prices.length - 1];

        for (int i = 0; i < prices.length - 1; i++) {
            priceDifferences[i] = prices[i + 1] - prices[i];
        }

        int maxProfit = 0;
        int[] maxPriceDifferences = new int[prices.length];
        maxPriceDifferences[0] = 0;
        for (int i = 0; i < priceDifferences.length; i++) {
            int currentMaxPriceDifferences = (maxPriceDifferences[i] > 0 ? maxPriceDifferences[i] : 0) + priceDifferences[i];
            maxPriceDifferences[i + 1] = currentMaxPriceDifferences;
            maxProfit = Math.max(maxProfit, currentMaxPriceDifferences);
        }

        return maxProfit;
    }
}
