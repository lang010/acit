/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (55.61%)
 * Total Accepted:    483.7K
 * Total Submissions: 869.8K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right, which minimizes the sum of all numbers along its
 * path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * 
 * 
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++)
            dp[i] = dp[i-1] + grid[0][i];
        for (int i = 1; i < grid.length; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < grid[0].length; j++)
                dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
        }
        return dp[grid[0].length-1];
    }
}
