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
        int j = value.length() - 1 - i;
        while (i < j) {
            char character = chars[i];
            while (!AlphanumericPalindromeValidator.isAlphanumeric(character) && i < j) {
                i++;
                character = chars[i];
            }
            char oppositeCharacter = chars[j];
            while (!AlphanumericPalindromeValidator.isAlphanumeric(oppositeCharacter) && i < j) {
                j--;
                oppositeCharacter = chars[j];
            }

            if (i < j
                    && !(AlphanumericPalindromeValidator.isAlphabeticCharacterPair(character, oppositeCharacter)
                        && Character.toLowerCase(character) == Character.toLowerCase(oppositeCharacter))
                    && !(AlphanumericPalindromeValidator.isNumericCharacterPair(character, oppositeCharacter)
                        && character == oppositeCharacter)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static boolean isAlphanumeric(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }

    public static boolean isAlphabeticCharacterPair(char c1, char c2) {
        return Character.isAlphabetic(c1) && Character.isAlphabetic(c2);
    }

    public static boolean isNumericCharacterPair(char c1, char c2) {
        return Character.isDigit(c1) && Character.isDigit(c2);
    }
}
