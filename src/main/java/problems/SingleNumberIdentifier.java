package problems;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberIdentifier {
    public static int identify(int[] numbers) {
        Map<Integer, Integer> numberCounts = new HashMap<>();
        for (Integer number : numbers) {
            Integer count = numberCounts.get(number);
            if (count == null) {
                numberCounts.put(number, 1);
            } else {
                numberCounts.put(number, count + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : numberCounts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        throw new IllegalArgumentException("Unknown");
    }

    public static int identifyXOR(int[] numbers) {
        int value = 0;
        for (int number : numbers) {
            value = value ^ number;
        }
        return value;
    }
}
