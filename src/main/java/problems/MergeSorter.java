package problems;

import java.util.Arrays;

public class MergeSorter {
    public static void sort(int[] values) {
        if (values == null || values.length <= 1) {
            return;
        }

        int middleIndex = values.length / 2;
        int[] left = Arrays.copyOfRange(values, 0, middleIndex);
        int[] right = Arrays.copyOfRange(values, middleIndex, values.length);

        sort(left);
        sort(right);

        merge(left, right, values);
    }

    private static int[] merge(int[] left, int[] right, int[] values) {
        int valuesIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            int leftValue = left[leftIndex];
            int rightValue = right[rightIndex];

            if (leftValue < rightValue) {
                values[valuesIndex] = leftValue;
                leftIndex++;
            } else {
                values[valuesIndex] = rightValue;
                rightIndex++;
            }

            valuesIndex++;
        }

        while (leftIndex < left.length) {
            values[valuesIndex] = left[leftIndex];
            valuesIndex++;
            leftIndex++;
        }

        while (rightIndex < right.length) {
            values[valuesIndex] = right[rightIndex];
            valuesIndex++;
            rightIndex++;
        }

        return values;
    }
}
