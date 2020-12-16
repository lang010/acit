/*
 * @lc app=leetcode id=269 lang=java
 *
 * [269] Alien Dictionary
 *
 * https://leetcode.com/problems/alien-dictionary/description/
 *
 * algorithms
 * Hard (33.53%)
 * Total Accepted:    177.7K
 * Total Submissions: 529.9K
 * Testcase Example:  '["wrt","wrf","er","ett","rftt"]'
 *
 * There is a new alien language that uses the English alphabet. However, the
 * order among letters are unknown to you.
 * 
 * You are given a list of strings words from the dictionary, where words are
 * sorted lexicographically by the rules of this new language.
 * 
 * Derive the order of letters in this language, and return it. If the given
 * input is invalid, return "". If there are multiple valid solutions, return
 * any of them.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: words = ["z","x"]
 * Output: "zx"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: words = ["z","x","z"]
 * Output: ""
 * Explanation: The order is invalid, so return "".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of only lowercase English letters.
 * 
 * 
 */
class Solution {
    Map<Character, Set<Character>> pre = new HashMap<>();
    Map<Character, Set<Character>> sufix = new HashMap<>();
    public String alienOrder(String[] words) {
        for (String s : words)
            for (char c : s.toCharArray()) {
                pre.put(c, new HashSet<>());
                sufix.put(c, new HashSet<>());
            }
        for (int i = 1; i < words.length; i++)
            helper(words[i-1], words[i]);
        StringBuilder sb = new StringBuilder();
        Map<Character, Set<Character>> p = pre;
        Map<Character, Set<Character>> s = sufix;
        while (!pre.isEmpty()) {
            Character cur = null;
            for (Character c : pre.keySet())
                if (pre.get(c).size() == 0) {
                    cur = c;
                    break;
                }
            if (cur == null)
                return "";
            sb.append(cur);
            pre.remove(cur);
            for (Character c : sufix.get(cur)) {
                pre.get(c).remove(cur);
            }
            sufix.remove(cur);
        }
        return sb.toString();
    }
    
    void helper(String x, String y) {
        int n = x.length();
        int m = y.length();
        int i = 0;
        while (i < n && i < m) {
            char c1 = x.charAt(i);
            char c2 = y.charAt(i);
            if (c1 != c2) {
                pre.get(c2).add(c1);
                sufix.get(c1).add(c2);
                return;
            }
            i++;
        }
        if (i < n) {
            char c = x.charAt(i);
            pre.get(c).add(c);
            sufix.get(c).add(c);
        }
    }
}
