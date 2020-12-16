/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 *
 * https://leetcode.com/problems/repeated-substring-pattern/description/
 *
 * algorithms
 * Easy (43.19%)
 * Total Accepted:    176.4K
 * Total Submissions: 408.3K
 * Testcase Example:  '"abab"'
 *
 * Given a non-empty string check if it can be constructed by taking a
 * substring of it and appending multiple copies of the substring together. You
 * may assume the given string consists of lowercase English letters only and
 * its length will not exceed 10000.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "aba"
 * Output: False
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring
 * "abcabc" twice.)
 * 
 * 
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = n/2; i > 0; i--) {
            if (n%i == 0 && check(cs, i))
                return true;
        }
        return false;
    }
    
    boolean check(char[] cs, int m) {
        for (int i = m; i < cs.length; i++) {
            if (cs[i] != cs[i%m])
                return false;
        }
        return true;
    }
}
