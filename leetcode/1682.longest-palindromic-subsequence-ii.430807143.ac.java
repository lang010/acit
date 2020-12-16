/*
 * @lc app=leetcode id=1682 lang=java
 *
 * [1682] Longest Palindromic Subsequence II
 *
 * https://leetcode.com/problems/longest-palindromic-subsequence-ii/description/
 *
 * algorithms
 * Medium (50.37%)
 * Total Accepted:    438
 * Total Submissions: 856
 * Testcase Example:  '"bbabab"'
 *
 * A subsequence of a string s is considered a good palindromic subsequence
 * if:
 * 
 * 
 * It is a subsequence of s.
 * It is a palindrome (has the same value if reversed).
 * It has an even length.
 * No two consecutive characters are equal, except the two middle ones.
 * 
 * 
 * For example, if s = "abcabcabb", then "abba" is considered a good
 * palindromic subsequence, while "bcb" (not even length) and "bbbb" (has equal
 * consecutive characters) are not.
 * 
 * Given a string s, return the length of the longest good palindromic
 * subsequence in s.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "bbabab"
 * Output: 4
 * Explanation: The longest good palindromic subsequence of s is "baab".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "dcbccacdb"
 * Output: 4
 * Explanation: The longest good palindromic subsequence of s is "dccd".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 250
 * s consists of lowercase English letters.
 * 
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][][] dp = new int[n][n][26];
        for (int j = 1; j < n; j++)
            for (int i = 0; i+j < n; i++) {
                for (int k = 0; k < 26; k++)
                    dp[i][i+j][k] = Math.max(dp[i][i+j-1][k], dp[i+1][i+j][k]);
                char c = s.charAt(i);
                if (c == s.charAt(i+j)) {
                    int max = 0;
                    for (int k = 0; k < 26; k++)
                        if (c-'a' != k)
                            max = Math.max(max, dp[i+1][i+j-1][k]);
                    dp[i][i+j][c-'a'] = Math.max(dp[i][i+j][c-'a'], max+2);
                }
            }
        int ans = 0;
        for (int i = 0; i < 26; i++)
            ans = Math.max(ans, dp[0][n-1][i]);
        return ans;
    }
}
