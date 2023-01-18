package problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class GroupAnagramsTest {

    @Test
    public void groupAnagrams() {
        String[] anagrams = new String[] { "eat", "tea" };
        List<String> anagramGroup = new ArrayList<>(Arrays.asList("eat", "tea"));
        List<List<String>> anagramGroups = new ArrayList<>(Collections.singletonList(anagramGroup));
        assertEquals(anagramGroups, GroupAnagrams.groupAnagrams(anagrams));
    }

    @Test
    public void doNotGroupNotAnagrams() {
        String[] notAnagrams = new String[] { "jae", "bae" };
        List<String> anagramGroup1 = new ArrayList<>(Collections.singletonList("bae"));
        List<String> anagramGroup2 = new ArrayList<>(Collections.singletonList("jae"));
        List<List<String>> anagramGroups = new ArrayList<>(Arrays.asList(anagramGroup1, anagramGroup2));
        assertEquals(anagramGroups, GroupAnagrams.groupAnagrams(notAnagrams));
    }

    @Test
    public void twoAnagramGroups() {
        String[] anagrams = new String[] { "eat", "tea", "jae" };
        List<String> anagramGroup1 = new ArrayList<>(Arrays.asList("eat", "tea"));
        List<String> anagramGroup2 = new ArrayList<>(Collections.singletonList("jae"));
        List<List<String>> anagramGroups = new ArrayList<>(Arrays.asList(anagramGroup1, anagramGroup2));
        assertEquals(anagramGroups, GroupAnagrams.groupAnagrams(anagrams));
    }

    @Test
    public void twoAnagramGroupingsAndTwoNonAnagramGroups() {
        String[] values = new String[] { "eat", "tea", "car", "arc", "jae", "bae" };
        List<String> anagramGroup1 = new ArrayList<>(Arrays.asList("eat", "tea"));
        List<String> anagramGroup2 = new ArrayList<>(Arrays.asList("car", "arc"));
        List<String> anagramGroup3 = new ArrayList<>(Collections.singletonList("bae"));
        List<String> anagramGroup4 = new ArrayList<>(Collections.singletonList("jae"));
        List<List<String>> anagramGroups = new ArrayList<>(Arrays.asList(anagramGroup1, anagramGroup2, anagramGroup3, anagramGroup4));
        assertEquals(anagramGroups, GroupAnagrams.groupAnagrams(values));
    }
}