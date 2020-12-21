package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteOperationForTwoStringsTest {
    @Test
    public void testIdenticalStringsReturnZero() {
        assertEquals(0, new DeleteOperationForTwoStrings().minDistance("jaebaebae", "jaebaebae"));
    }

    @Test
    public void testDifferentSuffixReturnsSharedPrefixLength() {
        assertEquals(2, new DeleteOperationForTwoStrings().minDistance("jaebaebaea", "jaebaebaeb"));
    }

    @Test
    public void testDifferentPrefixReturnsSharedSuffixLength() {
        assertEquals(2, new DeleteOperationForTwoStrings().minDistance("ajaebaebae", "bjaebaebae"));
    }

    @Test
    public void testSharedInnerCommonSubsequenceWithDifferingPrefixAndSuffix() {
        assertEquals(12, new DeleteOperationForTwoStrings().minDistance("abcjjjjjjjjjdef", "ghijjjjjjjjjzyx"));
    }

    @Test
    public void testTwoSharedSubstrings() {
        assertEquals(4, new DeleteOperationForTwoStrings().minDistance("babjword1", "babkword2"));
    }

    @Test
    public void testSeaAndEat() {
        assertEquals(2, new DeleteOperationForTwoStrings().minDistance("sea", "eat"));
    }
}