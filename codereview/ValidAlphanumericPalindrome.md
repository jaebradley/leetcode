# [Valid Alphanumeric Palindrome](https://leetcode.com/problems/valid-palindrome/description/)

## Problem ([from Leetcode](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/))
> Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
> For example, `A man, a plan, a canal: Panama` is a palindrome but `race a car` is not a palindrome.

## Discussion

My approach was the following:
1. Start with first and last characters of the input string (keeping track of their respective indices).
2. While the index of the first character is less than the index of it's "opposite" character...
   a. For both characters, increment / decrement their index if they're not alphanumeric (and first character index is
      less than it's opposite character index
   b. The invalid case occurs when
      1. The first character index is less than it's opposite
      2. Both characters are not alphabetic or not numeric
      3. Both characters are alphabetic and their lower case (or upper case) values are not equal
      4. Both characters are numeric but their values are not equal
   c. Increment the first character index and decrement the opposite character index
3. If able to exit the `while` loop, return `true`

* I could probably make the helper methods (like `isAlphanumeric`) `private`
* Open to other (better) names
* My `if` statement is pretty inelegant / hard to read - move to a helper method perhaps?
* Convert the `while`s to `for`s with conditionals?

## Implementation

<!-- language: lang-java -->
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
