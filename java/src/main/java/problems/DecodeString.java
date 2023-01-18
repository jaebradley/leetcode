package problems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/description/

 * algorithms
 * Medium (42.04%)
 * Total Accepted:    51.9K
 * Total Submissions: 123.4K
 * Testcase Example:  '"3[a]2[bc]"'


 Given an encoded string, return it's decoded string.


 The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.


 You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

 Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].


 Examples:

 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

public class DecodeString {
    public static String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> results = new Stack<>();
        int currentCount = 1;
        int index = 0;

        while (index < s.length()) {
            char c = s.charAt(index);

            if (Character.isDigit(c)) {
                counts.push(currentCount);
                results.push(result);

                StringBuilder countSb = new StringBuilder();
                while (Character.isDigit(c)) {
                    countSb.append(c);
                    index++;
                    c = s.charAt(index);

                }

                result = new StringBuilder();
                currentCount = Integer.valueOf(countSb.toString());
            } else if (Character.isLetter(c)) {
                result.append(c);
            } else if (c == ']') {
                StringBuilder lastResult = results.pop();
                for (int j = 0; j < currentCount; j++) {
                    lastResult.append(result);
                }
                result = lastResult;
                currentCount = counts.pop();
            }

            index++;
        }

        return result.toString();
    }
}
