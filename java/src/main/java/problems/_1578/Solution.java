package problems._1578;

public class Solution {
    public int minCost(String colors, int[] neededTime) {
        int cost = 0;
        int currentCharacterGroupCost = 0;
        int currentCharacterGroupMax = 0;
        final char[] characters = colors.toCharArray();
        for (int currentCharacterIndex = 0; currentCharacterIndex < characters.length; currentCharacterIndex += 1) {
            if (currentCharacterIndex > 0 && characters[currentCharacterIndex] != characters[currentCharacterIndex - 1]) {
                cost += currentCharacterGroupCost - currentCharacterGroupMax;
                currentCharacterGroupCost = 0;
                currentCharacterGroupMax = 0;
            }
            currentCharacterGroupCost += neededTime[currentCharacterIndex];
            currentCharacterGroupMax = Math.max(currentCharacterGroupMax, neededTime[currentCharacterIndex]);
        }

        return cost + currentCharacterGroupCost - currentCharacterGroupMax;
    }
}
