package problems._752;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/open-the-lock/
 * <p>
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 * <p>
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * <p>
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
 * <p>
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 * Example 2:
 * <p>
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation:
 * We can turn the last wheel in reverse to move from "0000" -> "0009".
 * Example 3:
 * <p>
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * Output: -1
 * Explanation:
 * We can't reach the target without getting stuck.
 * Example 4:
 * <p>
 * Input: deadends = ["0000"], target = "8888"
 * Output: -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target will not be in the list deadends.
 * target and deadends[i] consist of digits only.
 */

public class Solution {
    private static class Lock {
        public final List<Integer> values;

        public Lock(final List<Integer> values) {
            this.values = values;
        }

        public static Lock fromString(final String value) {
            return new Lock(
                    value.chars()
                            .map(Character::getNumericValue)
                            .boxed()
                            .collect(Collectors.toList())
            );
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Lock lock = (Lock) o;
            return Objects.equals(values, lock.values);
        }

        @Override
        public int hashCode() {
            return Objects.hash(values);
        }
    }

    private static Set<Lock> calculateNextLocks(final Lock lock) {
        return IntStream.range(0, lock.values.size())
                .boxed()
                .flatMap(index -> Stream.of(-1, 1)
                        .map(v -> {
                            final List<Integer> nextValues = new ArrayList<>(lock.values);
                            nextValues.set(index, (10 + nextValues.get(index) + v) % 10);
                            return nextValues;
                        })
                        .map(Lock::new))
                .collect(Collectors.toSet());
    }

    public int openLock(String[] deadends, String target) {
        final Lock targetLock = Lock.fromString(target);
        final Set<Lock> unacceptableLocks = Arrays.stream(deadends)
                .map(Lock::fromString)
                .collect(Collectors.toSet());
        int counter = 0;
        final Set<Lock> visitedLocks = new HashSet<>();
        final Queue<Lock> candidateLocks = new LinkedList<>();
        candidateLocks.add(new Lock(List.of(0, 0, 0, 0)));

        while (!candidateLocks.isEmpty()) {
            final int size = candidateLocks.size();
            for (int i = 0; i < size; i += 1) {
                final Lock currentLock = candidateLocks.remove();
                if (visitedLocks.add(currentLock)) {
                    if (currentLock.equals(targetLock)) {
                        return counter;
                    }

                    if (!unacceptableLocks.contains(currentLock)) {
                        candidateLocks.addAll(calculateNextLocks(currentLock));
                    }
                }
            }
            counter += 1;
        }
        return -1;
    }

}
