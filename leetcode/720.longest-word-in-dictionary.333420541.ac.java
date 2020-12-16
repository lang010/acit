/*
 * @lc app=leetcode id=720 lang=java
 *
 * [720] Longest Word in Dictionary
 *
 * https://leetcode.com/problems/longest-word-in-dictionary/description/
 *
 * algorithms
 * Easy (48.92%)
 * Total Accepted:    72.3K
 * Total Submissions: 147.7K
 * Testcase Example:  '["w","wo","wor","worl","world"]'
 *
 * Given a list of strings words representing an English Dictionary, find the
 * longest word in words that can be built one character at a time by other
 * words in words.  If there is more than one possible answer, return the
 * longest word with the smallest lexicographical order.  If there is no
 * answer, return the empty string.
 * 
 * Example 1:
 * 
 * Input: 
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 * Explanation: 
 * The word "world" can be built one character at a time by "w", "wo", "wor",
 * and "worl".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * Output: "apple"
 * Explanation: 
 * Both "apply" and "apple" can be built from other words in the dictionary.
 * However, "apple" is lexicographically smaller than "apply".
 * 
 * 
 * 
 * Note:
 * All the strings in the input will only contain lowercase letters.
 * The length of words will be in the range [1, 1000].
 * The length of words[i] will be in the range [1, 30].
 * 
 */
class Solution {
    static class Node {
        String val;
        Node[] next = new Node[26];
    }
    
    public String longestWord(String[] words) {
        Node root = new Node();
        root.val = "";
        for (String s : words)
            add(root, s);
        return dfs(root);
    }
    
    void add(Node r, String s) {
        for (char c : s.toCharArray()) {
            if (r.next[c-'a'] == null)
                r.next[c-'a'] = new Node();
            r = r.next[c-'a'];
        }
        r.val = s;
    }
    
    String dfs(Node r) {
        if (r == null || r.val == null)
            return "";
        String ans = r.val;
        for (Node n : r.next) {
            String val = dfs(n);
            if (val.length() > ans.length())
                ans = val;
        }
        return ans;
    }
}
