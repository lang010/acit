/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (30.97%)
 * Total Accepted:    1.9M
 * Total Submissions: 6M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not
 * a substring.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = ""
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = -1;
        int r = 0;
        int max = 0;
        int[] pos = new int[256];
        Arrays.setAll(pos, p -> -1);
        while (r < s.length()) {
            char c = s.charAt(r);
            if (pos[c] == -1) {
                pos[c] = r;
                if (r-l > max) {
                    max = r - l;
                }
            } else if (l < pos[c]) {
                for (int i = l+1; i < pos[c]; i++) {
                    pos[s.charAt(i)] = -1;
                }
                l = pos[c];
                pos[c] = r;
            }
            r++;
        }
        return max;
    }
}
