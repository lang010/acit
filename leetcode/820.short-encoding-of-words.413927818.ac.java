/*
 * @lc app=leetcode id=820 lang=java
 *
 * [820] Short Encoding of Words
 *
 * https://leetcode.com/problems/short-encoding-of-words/description/
 *
 * algorithms
 * Medium (51.30%)
 * Total Accepted:    15.2K
 * Total Submissions: 29.6K
 * Testcase Example:  '["time", "me", "bell"]'
 *
 * Given a list of words, we may encode it by writing a reference string s and
 * a list of indexes a.
 * 
 * For example, if the list of words is ["time", "me", "bell"], we can write it
 * as s = "time#bell#" and indexes = [0, 2, 5].
 * 
 * Then for each index, we will recover the word by reading from the reference
 * string from that index until we reach a "#" character.
 * 
 * Return the length of the shortest reference string s possible that encodes
 * the given words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: words = ["time", "me", "bell"]
 * Output: 10
 * Explanation: s = "time#bell#" and indexes = [0, 2, 5].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: words = ["t"]
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * words[i] consists of only lowercase letters.
 * 
 * 
 */
class Solution {
    static class Trie {
        Map<Character, Trie> child = new HashMap<>();
    };
    int ans = 0;
    public int minimumLengthEncoding(String[] words) {
        Trie root = new Trie();
        for (String s : words) {
            Trie cur = root;
            for (int i = s.length()-1; i >= 0; i--) {
                char c = s.charAt(i);
                if (!cur.child.containsKey(c))
                    cur.child.put(c, new Trie());
                cur = cur.child.get(c);
            }
        }
        dfs(root, 1);
        return ans;
    }
    
    void dfs(Trie root, int d) {
        if (root.child.size() == 0) {
            ans += d;
            return;
        }
        for (Trie t : root.child.values())
            dfs(t, d+1);
    }
}
