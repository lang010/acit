/*
 * @lc app=leetcode id=813 lang=java
 *
 * [813] Largest Sum of Averages
 *
 * https://leetcode.com/problems/largest-sum-of-averages/description/
 *
 * algorithms
 * Medium (50.64%)
 * Total Accepted:    28K
 * Total Submissions: 55.2K
 * Testcase Example:  '[9,1,2,3,9]\n3'
 *
 * We partition a row of numbers A into at most K adjacent (non-empty) groups,
 * then our score is the sum of the average of each group. What is the largest
 * score we can achieve?
 * 
 * Note that our partition must use every number in A, and that scores are not
 * necessarily integers.
 * 
 * 
 * Example:
 * Input: 
 * A = [9,1,2,3,9]
 * K = 3
 * Output: 20
 * Explanation: 
 * The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9
 * + (1 + 2 + 3) / 3 + 9 = 20.
 * We could have also partitioned A into [9, 1], [2], [3, 9], for example.
 * That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
 * 
 * 
 * 
 * 
 * Note: 
 * 
 * 
 * 1 <= A.length <= 100.
 * 1 <= A[i] <= 10000.
 * 1 <= K <= A.length.
 * Answers within 10^-6 of the correct answer will be accepted as correct.
 * 
 * 
 */
class Solution {
    double[][] dp;
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        dp = new double[n][K+1];
        return helper(A, 0, K);
    }
    
    double helper(int[] A, int l, int K) {
        double[][] dd = dp;
        if (dp[l][K] > 0)
            return dp[l][K];
        int n = A.length;
        if (n-l == K) {
            for (int i = l; i < n; i++)
                dp[l][K] += A[i];
            return dp[l][K];
        }
        if (K == 1) {
            for (int i = l; i < n; i++)
                dp[l][K] += A[i];
            dp[l][K] /= n-l;
            return dp[l][K];
        }
        double sum = 0;
        for (int i = l; n - i >= K; i++) {
            sum += A[i];
            dp[l][K] = Math.max(dp[l][K], sum/(i-l+1) + helper(A, i+1, K-1));
        }
        
        return dp[l][K];
    }
}
