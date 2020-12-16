/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (30.01%)
 * Total Accepted:    1.1M
 * Total Submissions: 3.7M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, return the longest palindromic substring in s.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "cbbd"
 * Output: "bb"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "a"
 * Output: "a"
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "ac"
 * Output: "a"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters (lower-case and/or
 * upper-case),
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        int max = 0;
        int pos = 0;
        for (int i = 1; i < s.length(); i++) {
            int len = check(s, i-1, i-1);
            if (len > max) {
                max = len;
                pos = i - len/2 - 1;
            }
            len = check(s, i-1, i);
            if (len > max) {
                max = len;
                pos = i - len/2;
            }
        }
        return s.substring(pos, pos+max);
    }
    
    int check(String s, int l, int r) {
        int len = 0;
        if (l == r) {
            len--;
        }
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                len += 2;
                l--;
                r++;
            } else {
                break;
            }
        }
        return len;
    }
}
