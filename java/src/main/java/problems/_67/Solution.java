package problems._67;

/**
 * Start from right to left
 * If 0 + 1, no carry, then 1
 * If 1 + 1, no carry, then 0, then carry is 1
 * If 1 + 1, and carry, then 1, and carry is 1
 */

public class Solution {
    public String addBinary(String a, String b) {
        int firstStringIndex = a.length() - 1;
        int secondStringIndex = b.length() - 1;
        final StringBuilder sb = new StringBuilder();
        boolean hasCarry = false;

        while (firstStringIndex >= 0 || secondStringIndex >= 0) {
            final char firstStringCharacter;
            if (firstStringIndex < 0) {
                firstStringCharacter = '0';
            } else {
                firstStringCharacter = a.charAt(firstStringIndex);
            }
            final char secondStringCharacter;
            if (secondStringIndex < 0) {
                secondStringCharacter = '0';
            } else {
                secondStringCharacter = b.charAt(secondStringIndex);
            }

            if (firstStringCharacter != secondStringCharacter) {
                if (hasCarry) {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            } else {
                if ('0' == firstStringCharacter) {
                    if (hasCarry) {
                        sb.append("1");
                        hasCarry = false;
                    } else {
                        sb.append("0");
                    }
                } else {
                    if (!hasCarry) {
                        hasCarry = true;
                        sb.append("0");
                    } else {
                        sb.append("1");
                    }

                }
            }


            firstStringIndex--;
            secondStringIndex--;
        }

        if (hasCarry) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}
