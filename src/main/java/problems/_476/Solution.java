package problems._476;

public class Solution {
    public int findComplement(int num) {
        final int originalValue = num;
        int operand = 0;
        while (0 != num) {
            num >>= 1;
            operand <<= 1;
            operand |= 1;
        }

        return originalValue ^ operand;
    }
}
