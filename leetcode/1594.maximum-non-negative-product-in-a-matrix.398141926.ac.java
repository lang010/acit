/*
 * @lc app=leetcode id=1594 lang=java
 *
 * [1594] Maximum Non Negative Product in a Matrix
 *
 * https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/description/
 *
 * algorithms
 * Medium (31.92%)
 * Total Accepted:    9.2K
 * Total Submissions: 28.8K
 * Testcase Example:  '[[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]'
 *
 * You are given a rows x cols matrix grid. Initially, you are located at the
 * top-left corner (0, 0), and in each step, you can only move right or down in
 * the matrix.
 * 
 * Among all possible paths starting from the top-left corner (0, 0) and ending
 * in the bottom-right corner (rows - 1, cols - 1), find the path with the
 * maximum non-negative product. The product of a path is the product of all
 * integers in the grid cells visited along the path.
 * 
 * Return the maximum non-negative product modulo 10^9 + 7. If the maximum
 * product is negative return -1.
 * 
 * Notice that the modulo is performed after getting the maximum product.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[-1,-2,-3],
 * [-2,-3,-3],
 * [-3,-3,-2]]
 * Output: -1
 * Explanation: It's not possible to get non-negative product in the path from
 * (0, 0) to (2, 2), so return -1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [[1,-2,1],
 * [1,-2,1],
 * [3,-4,1]]
 * Output: 8
 * Explanation: Maximum non-negative product is in bold (1 * 1 * -2 * -4 * 1 =
 * 8).
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: grid = [[1, 3],
 * [0,-4]]
 * Output: 0
 * Explanation: Maximum non-negative product is in bold (1 * 0 * -4 = 0).
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: grid = [[ 1, 4,4,0],
 * [-2, 0,0,1],
 * [ 1,-1,1,1]]
 * Output: 2
 * Explanation: Maximum non-negative product is in bold (1 * -2 * 1 * -1 * 1 *
 * 1 = 2).
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= rows, cols <= 15
 * -4 <= grid[i][j] <= 4
 * 
 * 
 */
class Solution {
    long mod = 1000000007l;
    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[][] pos = new long[n][m];
        long[][] neg = new long[n][m];
        boolean hasZero = grid[0][0] == 0;
        if (grid[0][0] > 0)
            pos[0][0] = grid[0][0];
        else
            neg[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            long x = grid[i][0];
            if (x > 0) {
                pos[i][0] = pos[i-1][0] * x;
                neg[i][0] = neg[i-1][0] * x;
            } else {
                pos[i][0] = neg[i-1][0] * x;
                neg[i][0] = pos[i-1][0] * x;
            }
            if (x == 0)
                hasZero = true;
        }
        for (int i = 1; i < m; i++) {
            long x = grid[0][i];
            if (x > 0) {
                pos[0][i] = pos[0][i-1] * x;
                neg[0][i] = neg[0][i-1] * x;
            } else {
                pos[0][i] = neg[0][i-1] * x;
                neg[0][i] = pos[0][i-1] * x;
            }
            if (x == 0)
                hasZero = true;
        }
        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++) {
                long x = grid[i][j];
                if (x > 0) {
                    pos[i][j] = Math.max(pos[i-1][j]*x, pos[i][j-1]*x);
                    neg[i][j] = Math.min(neg[i-1][j]*x, neg[i][j-1]*x);
                } else {
                    pos[i][j] = Math.max(neg[i-1][j]*x, neg[i][j-1]*x);
                    neg[i][j] = Math.min(pos[i-1][j]*x, pos[i][j-1]*x);
                }
                if (x == 0)
                    hasZero = true;
            }
        if (pos[n-1][m-1] > 0)
            return (int)(pos[n-1][m-1] % mod);
        return hasZero ? 0 : -1;
    }
}
