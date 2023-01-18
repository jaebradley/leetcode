package problems;

/**
 * https://leetcode.com/problems/sort-colors/description/

 * algorithms
 * Medium (38.87%)
 * Total Accepted:    219.3K
 * Total Submissions: 563.1K
 * Testcase Example:  '[2,0,2,1,1,0]'

 Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note: You are not suppose to use the library's sort function for this problem.

 Example:


 Input: [2,0,2,1,1,0]
 Output: [0,0,1,1,2,2]

 Follow up:


 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 Could you come up with a one-pass algorithm using only constant space?
 */

public class SortColors {
    public static void sortColorsTwoPasses(int[] nums) {
        int redObjectsCount = 0;
        int whiteObjectsCount = 0;
        int blueObjectsCount = 0;

        for (int num : nums) {
            if (num == 0) {
                redObjectsCount++;
            } else if (num == 1) {
                whiteObjectsCount++;
            } else if (num == 2) {
                blueObjectsCount++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (redObjectsCount >= 1) {
                nums[i] = 0;
                redObjectsCount--;
            } else if (whiteObjectsCount >= 1) {
                nums[i] = 1;
                whiteObjectsCount--;
            } else if (blueObjectsCount >= 1) {
                nums[i] = 2;
                blueObjectsCount--;
            }
        }
    }

    public static void sortColorsOnePass(int[] nums) {
        int index = 0;
        int twosIndex = nums.length - 1;
        int zerosIndex = 0;

        while (index <= twosIndex) {
            int currentNumber = nums[index];

            if (currentNumber == 0) {
                int numberToSwap = nums[zerosIndex];
                nums[zerosIndex] = currentNumber;
                nums[index] = numberToSwap;
                zerosIndex++;
            } else if (currentNumber == 2) {
                int numberToSwap = nums[twosIndex];
                nums[twosIndex] = currentNumber;
                nums[index] = numberToSwap;
                twosIndex--;
                index--;
            }

            index++;
        }
    }
}
