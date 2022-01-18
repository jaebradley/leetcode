package problems._1641;

public class Solution {
    public int countVowelStrings(int n) {
        final int[] dp = new int[]{0, 1, 1, 1, 1, 1};
        for (int count = 1; count <= n; count += 1) {
            for (int k = 1; k <= 5; k += 1) {
                dp[k] += dp[k - 1];
            }
        }

        return dp[5];
    }

}
