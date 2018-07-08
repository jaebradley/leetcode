package problems;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            List<String> anagrams = anagramGroups.get(sortedWord);
            if (anagrams == null) {
                anagrams = new ArrayList<>();
            }
            anagrams.add(s);
            anagramGroups.put(sortedWord, anagrams);
        }
        return new ArrayList<>(anagramGroups.values());
    }
}
