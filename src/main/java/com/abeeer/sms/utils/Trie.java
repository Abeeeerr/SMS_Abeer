package com.abeeer.sms.utils;

import java.util.*;

/**
 * This class uses the TrieNode class
 */

public class Trie {
    private final TrieNode root = new TrieNode();

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toLowerCase().toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
            node.words.add(word);
        }
        node.isEnd = true;
    }

    // Search all words that start with the given prefix

    public List<String> searchByPrefix(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toLowerCase().toCharArray()) {
            node = node.children.get(ch);
            if (node == null) return new ArrayList<>();
        }
        return new ArrayList<>(new HashSet<>(node.words)); // return unique names
    }
}
