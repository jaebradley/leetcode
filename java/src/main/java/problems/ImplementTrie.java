package problems;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/

 * algorithms
 * Medium (30.80%)
 * Total Accepted:    109.2K
 * Total Submissions: 353.3K
 * Testcase Example:  '["Trie","search"]\n[[],["a"]]'


 Implement a trie with insert, search, and startsWith methods.



 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 */

public class ImplementTrie {
    public static class TrieNode {
        public String word;
        public TrieNode[] children;

        public TrieNode(String word) {
            this.word = word;
            this.children = new TrieNode[26];
        }
    }

    public static class Trie {
        public TrieNode root;

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode currentNode = root;

            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                TrieNode nextNode = currentNode.children[index];
                if (nextNode == null) {
                    return false;
                }
                currentNode = nextNode;
            }

            return true;
        }

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode(null);
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode currentNode = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';
                TrieNode nextNode = currentNode.children[index];
                if (nextNode == null) {
                    nextNode = new TrieNode(null);
                    currentNode.children[index] = nextNode;
                }
                currentNode = nextNode;
            }

            currentNode.word = word;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode currentNode = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';
                TrieNode nextNode = currentNode.children[index];
                if (nextNode == null) {
                    return false;
                }
                currentNode = nextNode;
            }

            return currentNode.word != null;
        }
    }
}
