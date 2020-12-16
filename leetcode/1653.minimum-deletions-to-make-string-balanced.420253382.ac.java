/*
 * @lc app=leetcode id=1653 lang=java
 *
 * [1653] Minimum Deletions to Make String Balanced
 *
 * https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/description/
 *
 * algorithms
 * Medium (49.07%)
 * Total Accepted:    5K
 * Total Submissions: 10.2K
 * Testcase Example:  '"aababbab"'
 *
 * You are given a string s consisting only of characters 'a' and 'b'​​​​.
 * 
 * You can delete any number of characters in s to make s balanced. s is
 * balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b'
 * and s[j]= 'a'.
 * 
 * Return the minimum number of deletions needed to make s balanced.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "aababbab"
 * Output: 2
 * Explanation: You can either:
 * Delete the characters at 0-indexed positions 2 and 6 ("aababbab" ->
 * "aaabbb"), or
 * Delete the characters at 0-indexed positions 3 and 6 ("aababbab" ->
 * "aabbbb").
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "bbaaaaabb"
 * Output: 2
 * Explanation: The only solution is to delete the first two characters.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s[i] is 'a' or 'b'​​.
 * 
 * 
 */
class Solution {
    public int minimumDeletions(String s) {
        int a = 0, b = 0;
        for (char c : s.toCharArray())
            if (c == 'a')
                a++;
            else
                b++;
        int l = 0, r = s.length() - 1;
        int ans = 0;
        while (l < r) {
            while (l < r && s.charAt(l) == 'a') {
                l++;
                a--;
            }
            while (l < r && s.charAt(r) == 'b') {
                r--;
                b--;
            }
            if (l < r) {
                ans++;
                if (a > b) {
                    l++;
                    b--;
                } else {
                    r--;
                    a--;
                }
            }
        }
        return ans;
    }
}
