/*
 * @lc app=leetcode id=741 lang=java
 *
 * [741] Cherry Pickup
 *
 * https://leetcode.com/problems/cherry-pickup/description/
 *
 * algorithms
 * Hard (34.72%)
 * Total Accepted:    32.4K
 * Total Submissions: 93.2K
 * Testcase Example:  '[[0,1,-1],[1,0,-1],[1,1,1]]'
 *
 * You are given an n x n grid representing a field of cherries, each cell is
 * one of three possible integers.
 * 
 * 
 * 0 means the cell is empty, so you can pass through,
 * 1 means the cell contains a cherry that you can pick up and pass through,
 * or
 * -1 means the cell contains a thorn that blocks your way.
 * 
 * 
 * Return the maximum number of cherries you can collect by following the rules
 * below:
 * 
 * 
 * Starting at the position (0, 0) and reaching (n - 1, n - 1) by moving right
 * or down through valid path cells (cells with value 0 or 1).
 * After reaching (n - 1, n - 1), returning to (0, 0) by moving left or up
 * through valid path cells.
 * When passing through a path cell containing a cherry, you pick it up, and
 * the cell becomes an empty cell 0.
 * If there is no valid path between (0, 0) and (n - 1, n - 1), then no
 * cherries can be collected.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[0,1,-1],[1,0,-1],[1,1,1]]
 * Output: 5
 * Explanation: The player started at (0, 0) and went down, down, right right
 * to reach (2, 2).
 * 4 cherries were picked up during this single trip, and the matrix becomes
 * [[0,1,-1],[0,0,-1],[0,0,0]].
 * Then, the player went left, up, up, left to return home, picking up one more
 * cherry.
 * The total number of cherries picked up is 5, and this is the maximum
 * possible.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [[1,1,-1],[1,-1,1],[-1,1,1]]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 50
 * grid[i][j] is -1, 0, or 1.
 * grid[0][0] != -1
 * grid[n - 1][n - 1] != -1
 * 
 * 
 */
class Solution {
    int N;
    int[][][] memo;
    int[][] grid;
    
    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        N = grid.length;
        memo = new int[N][N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                Arrays.fill(memo[i][j], -10000);
        int ans = dp(N-1, N-1, N-1);
        return ans > 0 ? ans : 0;
    }
    
    int dp(int a, int b, int c) {
        int d = a+b-c;
        if (a < 0 || b < 0 || c < 0 || d < 0
           || a >= N || b >= N || c >= N || d >= N
           || grid[a][b] < 0 || grid[c][d] < 0)
            return -10000;
        if (memo[a][b][c] > -10000)
            return memo[a][b][c];
        if (a == 0 && b == 0 && c == 0)
            return memo[a][b][c] = grid[0][0];
        int val = grid[a][b] + grid[c][d];
        if (a == c && b == d)
            val /= 2;
        return memo[a][b][c] = Math.max(
            Math.max(dp(a-1, b, c), dp(a-1, b, c-1)),
            Math.max(dp(a, b-1, c), dp(a, b-1, c-1))) + val;
    }
}
