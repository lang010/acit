/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 *
 * https://leetcode.com/problems/interleaving-string/description/
 *
 * algorithms
 * Hard (32.24%)
 * Total Accepted:    169.3K
 * Total Submissions: 525.3K
 * Testcase Example:  '"aabcc"\n"dbbca"\n"aadbbcbcac"'
 *
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving
 * of s1 and s2.
 * 
 * An interleaving of two strings s and t is a configuration where they are
 * divided into non-empty substrings such that:
 * 
 * 
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 +
 * t3 + s3 + ...
 * 
 * 
 * Note: a + b is the concatenation of strings a and b.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1, s2, and s3 consist of lower-case English letters.
 * 
 * 
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (n+m != s3.length())
            return false;
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++)
            if (s1.charAt(i) == s3.charAt(i))
                dp[i+1][0] = true;
            else
                break;
        for (int i = 0; i < m; i++)
            if (s2.charAt(i) == s3.charAt(i))
                dp[0][i+1] = true;
            else
                break;
        for (int i = 1; i <= n; i++) {
            char c1 = s1.charAt(i-1);
            for (int j = 1; j <= m; j++) {
                char c2 = s2.charAt(j-1);
                char c3 = s3.charAt(i+j-1);
                dp[i][j] = c1 == c3 && dp[i-1][j] || c2 == c3 && dp[i][j-1];
            }
        }
        return dp[n][m];
    }
}
