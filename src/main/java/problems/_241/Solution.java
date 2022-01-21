package problems._241;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses/discuss/66333/Java-recursive-(9ms)-and-dp-(4ms)-solution
 *
 * Challenging for me to understand implementation details.
 *
 * Parse the expression into a list of values and a list of operations. The number of values is one more than the number of operations.
 * Create a 2-dimensional array of Lists. The first index refers to the starting value index and the second index refers to the ending value index (inclusive).
 * This 2-dimensional array represents the values calculated by evaluating the expression that starts at index i and ends at index j, inclusive
 * Answer to diffWaysToCompute is then the List of values at dp[0][number of values - 1]
 *
 * To calculate this 2-dimensional array, first initialize all identity cells with their value. So for example, the results for the expression starting at index i and ending at index i is the value at index i.
 * This is effectively populating all expressions where the "length" of the expression is 0 or that the number of operations in the expression is 0.
 * Then start calculating expressions where the number of operations is 1 to number of values - 1.
 * The idea is to combine all results from the "left side" of an operation with the "right side" of an operation.
 * So for 2 - 1 - 1, combine results of 2 with operation 1 - 1, etc.
 *
 * So for each operation count, from 1 onwards, start with the starting values from index 1 to size of values - operation count. This upper limit indicates the stopping point for the "left side" of the expression.
 * The ending value index starts from the starting value index to starting value index + operation count. This represents the "right side" of the expression.
 * Since initial operation count is 1, the 2-dimensional array accumulates tuple expressions (i.e. two values that use a single operation for calculation)
 * This is done for all adjacent tuples.
 * When the initial operation count increases to 2, results can be thought of as tuple on left / right combined with the remaining value. So can reuse tuple calculation from when initial operation count is 1.
 *
 * Time Complexity is N-1th Catalan Number
 */

public class Solution {
    private enum Operation {
        addition,
        subtraction,
        multiplication,
    }

    private static final Map<Character, Operation> operationsByCharacter = Map.of(
            '+', Operation.addition,
            '-', Operation.subtraction,
            '*', Operation.multiplication
    );

    public List<Integer> diffWaysToCompute(String expression) {
        if (null == expression || expression.isEmpty()) {
            return Collections.emptyList();
        }

        final List<Integer> values = new ArrayList<>();
        final List<Operation> operations = new ArrayList<>();
        {
            final StringBuilder value = new StringBuilder();

            for (char c : expression.toCharArray()) {
                if (Character.isDigit(c)) {
                    value.append(c);
                } else {
                    values.add(Integer.valueOf(value.toString()));
                    value.setLength(0);
                    operations.add(operationsByCharacter.get(c));
                }
            }

            values.add(Integer.valueOf(value.toString()));
        }

        final List<Integer>[][] resultsBetweenStartAndEndIndicesInclusive = (List<Integer>[][]) new ArrayList[values.size()][values.size()];

        for (int valueIndex = 0; valueIndex < values.size(); valueIndex += 1) {
            final int value = values.get(valueIndex);
            resultsBetweenStartAndEndIndicesInclusive[valueIndex][valueIndex] = new ArrayList<>();
            resultsBetweenStartAndEndIndicesInclusive[valueIndex][valueIndex].add(value);
        }

        for (int operationCount = 1; operationCount < values.size(); operationCount += 1) {
            for (int startingValueIndex = 0; startingValueIndex < values.size() - operationCount; startingValueIndex += 1) {
                resultsBetweenStartAndEndIndicesInclusive[startingValueIndex][startingValueIndex + operationCount] = new ArrayList<>();

                for (int endingValueIndex = startingValueIndex; endingValueIndex < startingValueIndex + operationCount; endingValueIndex += 1) {
                    final List<Integer> leftValues = resultsBetweenStartAndEndIndicesInclusive[startingValueIndex][endingValueIndex];
                    final List<Integer> rightValues = resultsBetweenStartAndEndIndicesInclusive[endingValueIndex + 1][startingValueIndex + operationCount];
                    final Operation operation = operations.get(endingValueIndex);
                    for (final int leftValue : leftValues) {
                        for (final int rightValue : rightValues) {
                            final int result;
                            {
                                switch (operation) {
                                    case addition -> result = leftValue + rightValue;

                                    case subtraction -> result = leftValue - rightValue;

                                    case multiplication -> result = leftValue * rightValue;

                                    default -> throw new RuntimeException("unexpected");
                                }
                            }
                            resultsBetweenStartAndEndIndicesInclusive[startingValueIndex][startingValueIndex + operationCount].add(result);
                        }
                    }
                }
            }
        }
        return resultsBetweenStartAndEndIndicesInclusive[0][values.size() - 1];
    }

}
