/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (61.52%)
 * Total Accepted:    228.6K
 * Total Submissions: 371.6K
 * Testcase Example:  '"abc"'
 *
 * Given a string, your task is to count how many palindromic substrings in
 * this string.
 * 
 * The substrings with different start indexes or end indexes are counted as
 * different substrings even they consist of same characters.
 * 
 * Example 1:
 * 
 * 
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The input string length won't exceed 1000.
 * 
 * 
 * 
 */
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = n;
        for (int i = 0; i < n; i++) {
            ans += count(s, i, i+1);
            ans += count(s, i-1, i+1);
        }
        return ans;
    }
    
    int count(String s, int l, int r) {
        int ans = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            ans++;
        }
        return ans;
    }
}
