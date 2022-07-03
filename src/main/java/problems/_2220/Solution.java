package problems._2220;

public class Solution {
    public int minBitFlips(int start, int goal) {
        int flips = 0;
        for (int i = 0; i < 32; i += 1) {
            if ((start & 0x00000001) != (goal & 0x00000001)) {
                flips += 1;
            }
            start = start >>> 1;
            goal = goal >>> 1;
        }
        return flips;
    }
}
