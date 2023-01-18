package problems._1342;

public class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;
        while (0 != num) {
            if (1 != (num & 0x01)) {
                num >>= 1;
            } else {
                num ^= 1;
            }
            steps += 1;
        }
        return steps;
    }

}
