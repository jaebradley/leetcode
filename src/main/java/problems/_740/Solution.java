package problems._740;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        final int[] buckets = new int[10001];
        for (final int value : nums) {
            buckets[value] += value;
        }
        int skip = 0;
        int take = 0;
        for (int bucket : buckets) {
            final int skipBucket = Math.max(skip, take);
            take = skip + bucket;
            skip = skipBucket;
        }
        return Math.max(skip, take);
    }
}
