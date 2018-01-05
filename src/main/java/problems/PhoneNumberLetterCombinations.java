package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneNumberLetterCombinations {
    private static char[][] PHONE_NUMBER_LETER_COMBINATIONS = new char[][] {
            new char[] {},
            new char[] {},
            new char[] { 'a', 'b', 'c' },
            new char[] { 'd', 'e', 'f' },
            new char[] { 'g', 'h', 'i' },
            new char[] { 'j', 'k', 'l' },
            new char[] { 'm', 'n', 'o' },
            new char[] { 'p', 'q', 'r', 's' },
            new char[] { 't', 'u', 'v' },
            new char[] { 'w', 'x', 'y', 'z' },
    };

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        LinkedList<StringBuilder> combinations = new LinkedList<>();
        combinations.add(new StringBuilder());

        for (int i = 0; i < digits.length(); i++) {
            int digit = Character.getNumericValue(digits.charAt(i));
            while (combinations.peek().length() == i) {
                StringBuilder combination = combinations.pop();
                for (char c : PHONE_NUMBER_LETER_COMBINATIONS[digit]) {
                    combinations.add(new StringBuilder(combination).append(c));
                }
            }
        }

        return combinations.stream().map(StringBuilder::toString).collect(Collectors.toList());
    }
}
