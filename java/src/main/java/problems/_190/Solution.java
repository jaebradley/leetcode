package problems._190;

public class Solution {
    public int reverseBits(int n) {
        int reversed = 0;
        for (int i = 0; i < 32; i += 1) {
            reversed = (reversed << 1);

            if (1 == (n & 0x00000001)) {
                reversed = (reversed | 0x00000001);
            }

            n = (n >>> 1);
        }
        return reversed;
    }
}
