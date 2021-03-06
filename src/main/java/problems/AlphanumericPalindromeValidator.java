package problems;

/**
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Approach:
 * Start with first and last characters
 * Keep track of both indices
 * If either is not alphanumeric, increment until find an alphanumeric character
 * Compare
 * If not equal return false
 * Do this until indices are same
 */

public class AlphanumericPalindromeValidator {
    public static boolean isValid(String value) {
        char[] chars = value.toCharArray();
        int i = 0;
        int j = value.length() - 1;
        while (i < j) {
            while (!Character.isLetterOrDigit(chars[i]) && i < j) {
                i++;
            }
            while (!Character.isLetterOrDigit(chars[j]) && i < j) {
                j--;
            }

            if (Character.toLowerCase(chars[i]) != Character.toLowerCase(chars[j])) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static boolean isAPairOfLetters(char c1, char c2) {
        return Character.isLetter(c1) && Character.isLetter(c2);
    }

    public static boolean isAPairOfNumbers(char c1, char c2) {
        return Character.isDigit(c1) && Character.isDigit(c2);
    }
}
