package problems._93;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 * <p>
 * Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.
 * <p>
 * A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * Example 2:
 * <p>
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * Example 3:
 * <p>
 * Input: s = "1111"
 * Output: ["1.1.1.1"]
 * Example 4:
 * <p>
 * Input: s = "010010"
 * Output: ["0.10.0.10","0.100.1.0"]
 * Example 5:
 * <p>
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 20
 * s consists of digits only.
 */

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        final List<String> ipAddresses = new ArrayList<>();
        extractIpAddresses(ipAddresses, new LinkedList<>(), 0, s);
        return ipAddresses;
    }

    private static void extractIpAddresses(final List<String> ipAddresses, final LinkedList<String> currentIpAddressCandidate, final int currentIndex, final String value) {
        if (currentIndex > value.length()) {
            return;
        }

        if (4 == currentIpAddressCandidate.size() && currentIndex == value.length()) {
            ipAddresses.add(String.join(".", currentIpAddressCandidate));
            return;
        }

        for (int index = (1 + currentIndex); index <= value.length(); index += 1) {
            final String candidateSegment = value.substring(currentIndex, index);
            if (isValidIpAddressSegment(candidateSegment)) {
                currentIpAddressCandidate.addLast(candidateSegment);
                extractIpAddresses(ipAddresses, currentIpAddressCandidate, index, value);
                currentIpAddressCandidate.removeLast();
            }
        }
    }

    private static boolean isValidIpAddressSegment(final String candidate) {
        if (candidate.isEmpty()) {
            return false;
        }

        if (1 < candidate.length() && '0' == candidate.charAt(0)) {
            return false;
        }

        if (3 < candidate.length()) {
            return false;
        }

        final int segment;
        try {
            segment = Integer.parseInt(candidate);
        } catch (NumberFormatException e) {
            return false;
        }
        return 0 <= segment && 255 >= segment;
    }
}
