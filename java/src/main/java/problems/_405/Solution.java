package problems._405;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 26 => 0001 (1) 1010 (a)
 */

public class Solution {
    private static final Map<Integer, Character> HEX_CHARACTERS_BY_BINARY = Stream.of(
            Map.entry(0, '0'),
            Map.entry(1, '1'),
            Map.entry(2, '2'),
            Map.entry(3, '3'),
            Map.entry(4, '4'),
            Map.entry(5, '5'),
            Map.entry(6, '6'),
            Map.entry(7, '7'),
            Map.entry(8, '8'),
            Map.entry(9, '9'),
            Map.entry(10, 'a'),
            Map.entry(11, 'b'),
            Map.entry(12, 'c'),
            Map.entry(13, 'd'),
            Map.entry(14, 'e'),
            Map.entry(15, 'f')
    ).collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));

    public String toHex(int num) {
        final StringBuilder sb = new StringBuilder();
        if (0 == num) {
            return "0";
        }
        while (0 != num) {
            final int lastFourBits = num & 0x0000000F;
            sb.append(HEX_CHARACTERS_BY_BINARY.get(lastFourBits));
            num = num >>> 4;
        }

        return sb.reverse().toString();
    }
}
