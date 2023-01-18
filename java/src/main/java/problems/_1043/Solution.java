package problems._1043;

public class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        final int[] maximumSums = new int[arr.length + 1];
        for (int currentValueIndex = 1; currentValueIndex <= arr.length; currentValueIndex += 1) {
            int maximumLookbackValue = 0;
            int maximumLookbackSum = 0;
            for (int lookbackStep = 1; lookbackStep <= k && currentValueIndex - lookbackStep >= 0; lookbackStep += 1) {
                maximumLookbackValue = Math.max(maximumLookbackValue, arr[currentValueIndex - lookbackStep]);
                maximumLookbackSum = Math.max(
                        maximumLookbackSum,
                        maximumSums[currentValueIndex - lookbackStep] + (maximumLookbackValue * lookbackStep)
                );
            }
            maximumSums[currentValueIndex] = maximumLookbackSum;
        }

        return maximumSums[arr.length];
    }

}
