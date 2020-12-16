/*
 * @lc app=leetcode id=1230 lang=java
 *
 * [1230] Toss Strange Coins
 *
 * https://leetcode.com/problems/toss-strange-coins/description/
 *
 * algorithms
 * Medium (49.58%)
 * Total Accepted:    5.2K
 * Total Submissions: 10.4K
 * Testcase Example:  '[0.4]\n1'
 *
 * You have some coins.  The i-th coin has a probability prob[i] of facing
 * heads when tossed.
 * 
 * Return the probability that the number of coins facing heads equals target
 * if you toss every coin exactly once.
 * 
 * 
 * Example 1:
 * Input: prob = [0.4], target = 1
 * Output: 0.40000
 * Example 2:
 * Input: prob = [0.5,0.5,0.5,0.5,0.5], target = 0
 * Output: 0.03125
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= prob.length <= 1000
 * 0 <= prob[i] <= 1
 * 0 <= target <= prob.length
 * Answers will be accepted as correct if they are within 10^-5 of the correct
 * answer.
 * 
 * 
 */
class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        double[] dp = new double[target+1];
        dp[0] = 1;
        for (int i = 0; i < prob.length; i++)
            for (int j = Math.min(i+1, target); j >= 0; j--)
                dp[j] = (j > 0 ? dp[j-1] : 0) * prob[i] + dp[j] * (1-prob[i]);
        
        return dp[target];
    }
}
