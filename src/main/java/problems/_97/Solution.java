package problems._97;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != (s1.length() + s2.length())) {
            return false;
        }
        final boolean[][] isInterleaving = new boolean[s1.length() + 1][s2.length() + 1];
        isInterleaving[0][0] = true;

        for (int firstStringIndex = 0; firstStringIndex < s1.length() + 1; firstStringIndex += 1) {
            for (int secondStringIndex = 0; secondStringIndex < s2.length() + 1; secondStringIndex += 1) {
                if (0 != firstStringIndex && 0 != secondStringIndex) {
                    isInterleaving[firstStringIndex][secondStringIndex] = (isInterleaving[firstStringIndex][secondStringIndex - 1] && s3.charAt(firstStringIndex + secondStringIndex - 1) == s2.charAt(secondStringIndex - 1))
                            || (isInterleaving[firstStringIndex - 1][secondStringIndex] && s3.charAt(firstStringIndex + secondStringIndex - 1) == s1.charAt(firstStringIndex - 1));
                } else if (0 == firstStringIndex && 0 != secondStringIndex) {
                    isInterleaving[firstStringIndex][secondStringIndex] = isInterleaving[0][secondStringIndex - 1] && (s3.charAt(firstStringIndex + secondStringIndex - 1) == s2.charAt(secondStringIndex - 1));
                } else if (0 != firstStringIndex) {
                    isInterleaving[firstStringIndex][secondStringIndex] = isInterleaving[firstStringIndex - 1][0] && s3.charAt(firstStringIndex + secondStringIndex - 1) == s1.charAt(firstStringIndex - 1);
                }
            }
        }
        return isInterleaving[s1.length()][s2.length()];
    }

}
