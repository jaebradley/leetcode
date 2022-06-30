package problems._191;

public class Solution {
    private static final int LAST_BIT_BITMASK = 0x00000001;
    private static final int IDENTITY_BITMASK = 0xFFFFFFFF;

    public int hammingWeight(int n) {
        int weight = 0;

        while (0 != (n & IDENTITY_BITMASK)) {
            if (1 == (n & LAST_BIT_BITMASK)) {
                weight++;
            }

            n = (n >>> 1);
        }

        return weight;
    }
}
