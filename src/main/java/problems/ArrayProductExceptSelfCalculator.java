package problems;

public class ArrayProductExceptSelfCalculator {
    public static int[] calculate(int[] values) {
        if (values.length <= 1) {
            return new int[] {};
        }

        int[] products = new int[values.length];
        int[] leftProducts = new int[values.length];
        int[] rightProducts = new int[values.length];
        leftProducts[0] = 1;
        rightProducts[values.length - 1] = 1;
        int leftProduct = 1;
        int rightProduct = 1;
        for (int i = 0; i < values.length - 1; i++) {
            int j = values.length - 1 - i;
            int leftValue = values[i];
            int rightValue = values[j];
            leftProduct *= leftValue;
            rightProduct *= rightValue;
            leftProducts[i + 1] = leftProduct;
            rightProducts[j - 1] = rightProduct;
        }

        for (int i = 0; i < values.length; i++) {
            products[i] = leftProducts[i] * rightProducts[i];
        }

        return products;
    }
}
