package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsomorphicStringsTest {

    @Test
    public void stringsOfDifferentSizesAreNotIsomorphic() {
        assertFalse(IsomorphicStrings.isIsomorphic("foo", "no"));
    }

    @Test
    public void isIsomorphic() {
        assertTrue(IsomorphicStrings.isIsomorphic("egg", "add"));
    }

    @Test
    public void isNotIsomorphic() {
        assertFalse(IsomorphicStrings.isIsomorphic("foo", "bar"));
    }

    @Test
    public void duplicateCharacterIsIsomorphic() {
        assertFalse(IsomorphicStrings.isIsomorphic("ab", "aa"));
    }

    @Test
    public void alternatingCharacterIsIsomorphic() {
        assertFalse(IsomorphicStrings.isIsomorphic("aba", "baa"));
    }
}