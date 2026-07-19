package datastructures;

import java.util.ArrayList;

public class Trie {

    private TrieNode root;

    // Constructor
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a filename into the Trie.
     */
    public void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            current.children.putIfAbsent(ch, new TrieNode());

            current = current.children.get(ch);
        }

        current.isEndOfWord = true;
    }

    /**
     * Searches for all filenames that start with the given prefix.
     */
    public ArrayList<String> searchPrefix(String prefix) {

        ArrayList<String> results = new ArrayList<>();

        TrieNode current = root;

        // Traverse to the end of the prefix
        for (char ch : prefix.toCharArray()) {

            if (!current.children.containsKey(ch)) {
                return results;
            }

            current = current.children.get(ch);
        }

        // Collect all matching words
        collectWords(current, prefix, results);

        return results;
    }

    /**
     * Recursive helper method to collect all words
     * starting from the current Trie node.
     */
    private void collectWords(TrieNode node,
                              String currentWord,
                              ArrayList<String> results) {

        if (node.isEndOfWord) {
            results.add(currentWord);
        }

        for (char ch : node.children.keySet()) {

            collectWords(
                    node.children.get(ch),
                    currentWord + ch,
                    results
            );
        }
    }

    /**
     * Checks if a complete word exists in the Trie.
     */
    public boolean search(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            if (!current.children.containsKey(ch)) {
                return false;
            }

            current = current.children.get(ch);
        }

        return current.isEndOfWord;
    }
}