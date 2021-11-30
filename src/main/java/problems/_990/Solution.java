package problems._990;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static class UnionFind {
        private final Map<Character, Character> parentsByChildren = IntStream.rangeClosed(97, 122)
                .boxed()
                .map(v -> (char) v.intValue())
                .map(v -> Map.entry(v, v))
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue
                        )
                );

        private Character findParent(final Character c) {
            Character parent = parentsByChildren.get(c);
            if (parent.equals(c)) {
                return parent;
            }

            parent = findParent(parent);
            parentsByChildren.put(c, parent);
            return parent;
        }

        public void union(final Character firstCharacter, final Character secondCharacter) {
            final Character firstParent = findParent(firstCharacter);
            final Character secondParent = findParent(secondCharacter);
            if (!firstParent.equals(secondParent)) {
                parentsByChildren.put(secondParent, firstParent);
            }
        }

        public boolean haveSharedParents(final Character firstCharacter, final Character secondCharacter) {
            return findParent(firstCharacter).equals(findParent(secondCharacter));
        }
    }

    public boolean equationsPossible(String[] equations) {
        final UnionFind unionFind = new UnionFind();
        final Set<Map.Entry<Character, Character>> inequalities = new HashSet<>();
        for (final String equation : equations) {
            final char leftVariable = equation.charAt(0);
            final String operator = equation.substring(1, 3);
            final char rightVariable = equation.charAt(3);
            if (operator.equals("==")) {
                unionFind.union(leftVariable, rightVariable);
            } else {
                inequalities.add(Map.entry(leftVariable, rightVariable));
            }
        }

        for (final Map.Entry<Character, Character> inequality : inequalities) {
            if (unionFind.haveSharedParents(inequality.getKey(), inequality.getValue())) {
                return false;
            }
        }

        return true;
    }

}
