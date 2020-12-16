/*
 * @lc app=leetcode id=472 lang=java
 *
 * [472] Concatenated Words
 *
 * https://leetcode.com/problems/concatenated-words/description/
 *
 * algorithms
 * Hard (45.05%)
 * Total Accepted:    80.1K
 * Total Submissions: 177.8K
 * Testcase Example:  '["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]'
 *
 * Given a list of words (without duplicates), please write a program that
 * returns all concatenated words in the given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at
 * least two shorter words in the given array.
 * 
 * Example:
 * 
 * Input:
 * ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * 
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; "ratcatdogcat"
 * can be concatenated by "rat", "cat", "dog" and "cat".
 * 
 * 
 * 
 * Note:
 * 
 * The number of elements of the given array will not exceed 10,000 
 * The length sum of elements in the given array will not exceed 600,000. 
 * All the input string will only include lower case letters.
 * The returned elements order does not matter. 
 * 
 * 
 */
class Solution {
    static class Trie {
        Trie[] child = new Trie[32];
        boolean end;
    };
    Trie root = new Trie();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for (String s : words)
            add(root, s.toCharArray(), 0);
        List<String> ans = new ArrayList<>();
        for (String s : words)
            if (check(root, root, s.toCharArray(), 0))
                ans.add(s);
        return ans;
    }
    
    void add(Trie cur, char[] chs, int id) {
        if (id == chs.length) {
            cur.end = true;
            return;
        }
        if (cur.child[chs[id]-'a'] == null)
            cur.child[chs[id]-'a'] = new Trie();
        add(cur.child[chs[id]-'a'], chs, id+1);
    }
    
    boolean check(Trie first, Trie sec, char[] chs, int id) {
        if (sec == null)
            return false;
        if (id == chs.length)
            return first.end && sec.end && first != sec;
        first = first.child[chs[id]-'a'];
        if (sec.end) {
            if (check(first, root.child[chs[id]-'a'], chs, id+1))
                return true;
        }
        sec = sec.child[chs[id]-'a'];
        return check(first, sec, chs, id+1);
    }
}
