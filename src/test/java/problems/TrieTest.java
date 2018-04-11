package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.ImplementTrie.*;

public class TrieTest {

    @Test
    public void insertFuck() {
        Trie trie = new Trie();
        trie.insert("fuck");
        assertNotNull(trie.root.children[5]);
        assertNull(trie.root.children[5].word);
        assertNotNull(trie.root.children[5].children[20]);
        assertNull(trie.root.children[5].children[20].word);
        assertNotNull(trie.root.children[5].children[20].children[2]);
        assertNull(trie.root.children[5].children[20].children[2].word);
        assertNotNull(trie.root.children[5].children[20].children[2].children[10]);
        assertEquals("fuck", trie.root.children[5].children[20].children[2].children[10].word);
    }

    @Test
    public void searchFuck() {
        Trie trie = new Trie();
        trie.insert("fuck");
        assertTrue(trie.search("fuck"));
    }

    @Test
    public void falseWhenSearchingForWordThatDoesntExist() {
        Trie trie = new Trie();
        trie.insert("fuck");
        assertFalse(trie.search("foo"));
    }

    @Test
    public void falseWhenSearchingForWordGreaterThanExistingWord() {
        Trie trie = new Trie();
        trie.insert("fuck");
        assertFalse(trie.search("fuckyou"));
    }

    @Test
    public void startsWith() {
        Trie trie = new Trie();
        trie.insert("fuck");
        assertTrue(trie.startsWith("fu"));
    }

    @Test
    public void startsWithEntireWord() {
        Trie trie = new Trie();
        trie.insert("fuck");
        assertTrue(trie.startsWith("fuck"));
    }

    @Test
    public void doesNotStartWith() {
        Trie trie = new Trie();
        trie.insert("fuck");
        assertFalse(trie.startsWith("bar"));
    }
}