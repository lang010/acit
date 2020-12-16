/*
 * @lc app=leetcode id=718 lang=java
 *
 * [718] Maximum Length of Repeated Subarray
 *
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 *
 * algorithms
 * Medium (49.90%)
 * Total Accepted:    77.1K
 * Total Submissions: 154.5K
 * Testcase Example:  '[1,2,3,2,1]\n[3,2,1,4,7]'
 *
 * Given two integer arrays A and B, return the maximum length of an subarray
 * that appears in both arrays.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation: 
 * The repeated subarray with maximum length is [3, 2, 1].
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * 
 * 
 * 
 * 
 */
class Solution {
    public int findLength(int[] A, int[] B) {
        int max = 0;
        int n = A.length+1;
        int m = B.length+1;
        int[] dp = new int[m];
        for (int i = 1; i < n; i++)
            for (int j = m-1; j > 0; j--)
                if (A[i-1] == B[j-1]) {
                    dp[j] = dp[j-1] + 1;
                    max = Math.max(max, dp[j]);
                } else
                    dp[j] = 0;
        return max;
    }
}
