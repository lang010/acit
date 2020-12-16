/*
 * @lc app=leetcode id=1254 lang=java
 *
 * [1254] Number of Closed Islands
 *
 * https://leetcode.com/problems/number-of-closed-islands/description/
 *
 * algorithms
 * Medium (61.23%)
 * Total Accepted:    30.3K
 * Total Submissions: 49.5K
 * Testcase Example:  '[[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]'
 *
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a
 * maximal 4-directionally connected group of 0s and a closed island is an
 * island totally (all left, top, right, bottom) surrounded by 1s.
 * 
 * Return the number of closed islands.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: grid =
 * [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation: 
 * Islands in gray are closed because they are completely surrounded by water
 * (group of 1s).
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: grid = [[1,1,1,1,1,1,1],
 * [1,0,0,0,0,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,0,0,0,0,1],
 * ⁠              [1,1,1,1,1,1,1]]
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 * 
 * 
 */
class Solution {
    int[][] next = { {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, m-1);
        }
        for (int i = 0; i < m; i++) {
            dfs(grid, 0, i);
            dfs(grid, n-1, i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 0) {
                    ans++;
                    dfs(grid, i, j);
                }
        return ans;
    }
    
    void dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
            return;
        if (grid[x][y] == 1)
            return;
        grid[x][y] = 1;
        for (int[] ne : next)
            dfs(grid, x+ne[0], y+ne[1]);
    }
}
