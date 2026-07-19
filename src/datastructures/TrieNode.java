package datastructures;

import java.util.HashMap;

public class TrieNode {

    // Children of this node
    HashMap<Character, TrieNode> children;

    // Is this the end of a word?
    boolean isEndOfWord;

    public TrieNode() {

        children = new HashMap<>();

        isEndOfWord = false;

    }

}
