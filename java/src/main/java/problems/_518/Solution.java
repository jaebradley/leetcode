package problems._518;

public class Solution {
    public int change(int amount, int[] coins) {
        final int[] coinCombinationsForValue = new int[amount + 1];
        coinCombinationsForValue[0] = 1;
        for (final int coinValue : coins) {
            for (int i = 1; i <= amount; i += 1) {
                if ((i - coinValue) >= 0) {
                    coinCombinationsForValue[i] += coinCombinationsForValue[i - coinValue];
                }
            }
        }

        return coinCombinationsForValue[amount];
    }
}
