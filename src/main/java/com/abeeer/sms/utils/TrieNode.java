package com.abeeer.sms.utils;

import java.util.*;

/**
 * A simple node structure used inside the Trie.
 * Each node keeps a map of children characters and a list of matching words.
 */

public class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    public List<String> words = new ArrayList<>();
    public boolean isEnd = false;
}
