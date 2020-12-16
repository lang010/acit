/*
 * @lc app=leetcode id=583 lang=java
 *
 * [583] Delete Operation for Two Strings
 *
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 *
 * algorithms
 * Medium (49.52%)
 * Total Accepted:    57.4K
 * Total Submissions: 115.9K
 * Testcase Example:  '"sea"\n"eat"'
 *
 * 
 * Given two words word1 and word2, find the minimum number of steps required
 * to make word1 and word2 the same, where in each step you can delete one
 * character in either string.
 * 
 * 
 * Example 1:
 * 
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to
 * make "eat" to "ea".
 * 
 * 
 * 
 * Note:
 * 
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 * 
 * 
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length()+1;
        int m = word2.length()+1;
        int[] pre = new int[m];
        int[] dp = new int[m];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[j] = pre[j-1] + 1;
                } else {
                    dp[j] = Math.max(pre[j], dp[j-1]);
                }
            }
            int[] tmp = pre;
            pre = dp;
            dp = tmp;
        }
        n--;
        m--;
        return n+m-2 * pre[m];
    }
}
