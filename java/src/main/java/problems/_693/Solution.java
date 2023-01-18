package problems._693;

public class Solution {
    public boolean hasAlternatingBits(int n) {
        int lastBit = n & 0x00000001;
        while (0 != n) {
            n = n >>> 1;
            final int nextBit = n & 0x00000001;
            if (lastBit == nextBit) {
                return false;
            }
            lastBit = nextBit;
        }

        return true;
    }
}
