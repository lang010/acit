/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 *
 * https://leetcode.com/problems/edit-distance/description/
 *
 * algorithms
 * Hard (46.11%)
 * Total Accepted:    320.9K
 * Total Submissions: 695.9K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * Given two strings word1 and word2, return the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following three operations permitted on a word:
 * 
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation: 
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation: 
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 * 
 * 
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length() + 1;
        int m = word2.length() + 1;
        int[] pre = new int[m];
        int[] dp = new int[m];
        for (int i = 1; i < m; i++)
            pre[i] = i;
        for (int i = 1; i < n; i++) {
            dp[0] = i;
            for (int j = 1; j < m; j++)
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[j] = pre[j-1];
                else {
                    dp[j] = Math.min(Math.min(dp[j-1], pre[j]), pre[j-1]) + 1;
                }
            int[] tmp = pre;
            pre = dp;
            dp = tmp;
        }
        return pre[m-1];
    }
}
