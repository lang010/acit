/*
 * @lc app=leetcode id=1065 lang=java
 *
 * [1065] Index Pairs of a String
 *
 * https://leetcode.com/problems/index-pairs-of-a-string/description/
 *
 * algorithms
 * Easy (61.14%)
 * Total Accepted:    9.2K
 * Total Submissions: 15.1K
 * Testcase Example:  '"thestoryofleetcodeandme"\n["story","fleet","leetcode"]'
 *
 * Given a text string and words (a list of strings), return all index pairs
 * [i, j] so that the substring text[i]...text[j] is in the list of words.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: text = "thestoryofleetcodeandme", words =
 * ["story","fleet","leetcode"]
 * Output: [[3,7],[9,13],[10,17]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: text = "ababa", words = ["aba","ab"]
 * Output: [[0,1],[0,2],[2,3],[2,4]]
 * Explanation: 
 * Notice that matches can overlap, see "aba" is found in [0,2] and [2,4].
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All strings contains only lowercase English letters.
 * It's guaranteed that all strings in words are different.
 * 1 <= text.length <= 100
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 50
 * Return the pairs [i,j] in sorted order (i.e. sort them by their first
 * coordinate in case of ties sort them by their second coordinate).
 * 
 */
class Solution {
    static class Node {
        boolean end;
        Node[] next = new Node[26];
    }
    
    List<int[]> ans = new ArrayList<int[]>();
    
    public int[][] indexPairs(String text, String[] words) {
        Node head = new Node();
        for (String s : words)
            add(head, s);
        for (int i = 0; i < text.length(); i++)
            subs(text, i, head);
        return ans.toArray(new int[0][0]);
    }
    
    void add(Node head, String s) {
        for (char c : s.toCharArray()) {
            int id = c - 'a';
            if (head.next[id] == null)
                head.next[id] = new Node();
            head = head.next[id];
        }
        head.end = true;
    }
    
    void subs(String s, int st, Node head) {
        int i = st;
        while (head != null && i < s.length()) {
            char c = s.charAt(i);
            head = head.next[c-'a'];
            if (head != null && head.end) {
                ans.add(new int[] {st, i});
            }
            i++;
        }
    }
}
