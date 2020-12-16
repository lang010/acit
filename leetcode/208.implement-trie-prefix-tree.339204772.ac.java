/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (51.15%)
 * Total Accepted:    372.2K
 * Total Submissions: 727.5K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Example:
 * 
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");   
 * trie.search("app");     // returns true
 * 
 * 
 * Note:
 * 
 * 
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 * 
 * 
 */
class Trie {
    
    Node head;

    /** Initialize your data structure here. */
    public Trie() {
        head = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null)
            return;
        Node node = head;
        for (int i = 0; i < word.length(); i++) {
            int id = word.charAt(i) - 'a';
            if (node.next[id] == null) {
                node.next[id] = new Node();
            }
            node = node.next[id];
        }
        node.end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || "".equals(word))
            return false;
        Node node = head;
        for (int i = 0; i < word.length(); i++) {
            int id = word.charAt(i) - 'a';
            if (node.next[id] == null)
                return false;
            node = node.next[id];
        }
        return node.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || "".equals(prefix))
            return false;
        Node node = head;
        for (char c : prefix.toCharArray()) {
            int id = c - 'a';
            if (node.next[id] == null)
                return false;
            node = node.next[id];
        }
        return true;
    }
    
    static class Node {
        boolean end;
        Node[] next = new Node[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
