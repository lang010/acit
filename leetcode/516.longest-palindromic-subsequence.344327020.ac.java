/*
 * @lc app=leetcode id=516 lang=java
 *
 * [516] Longest Palindromic Subsequence
 *
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 *
 * algorithms
 * Medium (54.64%)
 * Total Accepted:    144.4K
 * Total Submissions: 264.4K
 * Testcase Example:  '"bbbab"'
 *
 * Given a string s, find the longest palindromic subsequence's length in s.
 * You may assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * Input:
 * 
 * 
 * "bbbab"
 * 
 * Output:
 * 
 * 
 * 4
 * 
 * One possible longest palindromic subsequence is "bbbb".
 * 
 * 
 * 
 * Example 2:
 * Input:
 * 
 * 
 * "cbbd"
 * 
 * Output:
 * 
 * 
 * 2
 * 
 * One possible longest palindromic subsequence is "bb".
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s consists only of lowercase English letters.
 * 
 * 
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i ++)
            for (int l = 0; l + i < n; l++) {
                int r = l+i;
                if (l == r) {
                    dp[l][r] = 1;
                    continue;
                }
                if (chs[l] == chs[r])
                    dp[l][r] = 2 + dp[l+1][r-1];
                else
                    dp[l][r] = Math.max(dp[l][r-1], dp[l+1][r]);
            }
        return dp[0][n-1];
    }
}
