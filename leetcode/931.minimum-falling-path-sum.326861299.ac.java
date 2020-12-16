/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 *
 * https://leetcode.com/problems/minimum-falling-path-sum/description/
 *
 * algorithms
 * Medium (63.11%)
 * Total Accepted:    61.7K
 * Total Submissions: 97.7K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a square array of integers A, we want the minimum sum of a falling
 * path through A.
 * 
 * A falling path starts at any element in the first row, and chooses one
 * element from each row.  The next row's choice must be in a column that is
 * different from the previous row's column by at most one.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 12
 * Explanation: 
 * The possible falling paths are:
 * 
 * 
 * 
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 * 
 * 
 * The falling path with the smallest sum is [1,4,7], so the answer is 12.
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= A.length == A[0].length <= 100
 * -100 <= A[i][j] <= 100
 * 
 * 
 */
class Solution {
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[] dp = new int[m+2];
        int[] pre = new int[m+2];
        dp[0] = dp[m+1] = pre[0] = pre[m+1] = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++)
            pre[i] = A[0][i-1];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[j+1] = Math.min(pre[j], Math.min(pre[j+1], pre[j+2])) + A[i][j];
            }
            int[] tmp = pre;
            pre = dp;
            dp = tmp;
        }
        int min = pre[0];
        for (int x : pre)
            min = Math.min(x, min);
        return min;
    }
}
