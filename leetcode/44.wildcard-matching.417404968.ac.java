/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 *
 * https://leetcode.com/problems/wildcard-matching/description/
 *
 * algorithms
 * Hard (25.18%)
 * Total Accepted:    275.4K
 * Total Submissions: 1.1M
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern
 * matching with support for '?' and '*' where:
 * 
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "cb", p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not
 * match 'b'.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "adceb", p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*'
 * matches the substring "dce".
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: s = "acdcb", p = "a*c?b"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length, p.length <= 2000
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '?' or '*'.
 * 
 * 
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length()+1;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (char c : p.toCharArray()) {
            if (c == '*') {
                for (int i = 1; i < n; i++)
                    dp[i] |= dp[i-1];
            } else if (c == '?') {
                for (int i = n-1; i > 0 ; i--)
                    dp[i] = dp[i-1];
                dp[0] = false;
            } else {
                for (int i = n-1; i > 0; i--)
                    if (s.charAt(i-1) == c)
                        dp[i] = dp[i-1];
                    else
                        dp[i] = false;
                dp[0] = false;
            }
        }
        return dp[n-1];
    }
}
