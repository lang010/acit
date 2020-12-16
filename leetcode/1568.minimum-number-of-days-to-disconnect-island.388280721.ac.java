/*
 * @lc app=leetcode id=1568 lang=java
 *
 * [1568] Minimum Number of Days to Disconnect Island
 *
 * https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/description/
 *
 * algorithms
 * Hard (50.60%)
 * Total Accepted:    5.2K
 * Total Submissions: 10.3K
 * Testcase Example:  '[[0,1,1,0],[0,1,1,0],[0,0,0,0]]'
 *
 * Given a 2D grid consisting of 1s (land) and 0s (water).  An island is a
 * maximal 4-directionally (horizontal or vertical) connected group of 1s.
 * 
 * The grid is said to be connected if we have exactly one island, otherwise is
 * said disconnected.
 * 
 * In one day, we are allowed to change any single land cell (1) into a water
 * cell (0).
 * 
 * Return the minimum number of days to disconnect the grid.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: grid = [[0,1,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 2
 * Explanation: We need at least 2 days to get a disconnected grid.
 * Change land grid[1][1] and grid[0][2] to water and get 2 disconnected
 * island.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [[1,1]]
 * Output: 2
 * Explanation: Grid of full water is also disconnected ([[1,1]] -> [[0,0]]), 0
 * islands.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: grid = [[1,0,1,0]]
 * Output: 0
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: grid = [[1,1,0,1,1],
 * [1,1,1,1,1],
 * [1,1,0,1,1],
 * [1,1,0,1,1]]
 * Output: 1
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: grid = [[1,1,0,1,1],
 * [1,1,1,1,1],
 * [1,1,0,1,1],
 * [1,1,1,1,1]]
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= grid.length, grid[i].length <= 30
 * grid[i][j] is 0 or 1.
 * 
 * 
 */
class Solution {
    int n;
    int m;
    int[][] next = { { 1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int minDays(int[][] grid) {
        n = grid.length;
        m = n > 0 ? grid[0].length : 0;
        if (cnt(grid) != 1)
            return 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j]!=0) {
                    grid[i][j] = 0;
                    if (cnt(grid) != 1)
                        return 1;
                    grid[i][j] = 1;
                }
        return 2;
    }
    
    int cnt(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1) {
                    cnt++;
                    dfs(grid, i, j);
                }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] > 0)
                    grid[i][j] = 1;
        return cnt;
    }
    
    void dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] != 1)
            return;
        grid[x][y] = 2;
        for (int i = 0; i < next.length; i++)
            dfs(grid, x+next[i][0], y+next[i][1]);
    }
}
