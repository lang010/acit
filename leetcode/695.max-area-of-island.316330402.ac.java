/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 *
 * https://leetcode.com/problems/max-area-of-island/description/
 *
 * algorithms
 * Medium (63.98%)
 * Total Accepted:    191.4K
 * Total Submissions: 299.2K
 * Testcase Example:  '[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]'
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * Find the maximum area of an island in the given 2D array. (If there is no
 * island, the maximum area is 0.)
 * 
 * Example 1:
 * 
 * 
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * ⁠[0,1,1,0,1,0,0,0,0,0,0,0,0],
 * ⁠[0,1,0,0,1,1,0,0,1,0,1,0,0],
 * ⁠[0,1,0,0,1,1,0,0,1,1,1,0,0],
 * ⁠[0,0,0,0,0,0,0,0,0,0,1,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 
 * Given the above grid, return 6. Note the answer is not 11, because the
 * island must be connected 4-directionally.
 * 
 * Example 2:
 * 
 * 
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * 
 * Note: The length of each dimension in the given grid does not exceed 50.
 * 
 */
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length < 1)
            return 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (!visited[i][j] && grid[i][j] != 0) {
                    ans = Math.max(ans, cnt(grid, visited, i, j));
                }
        
        return ans;
    }
    
    int cnt(int[][] grid, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
            return 0;
        if (grid[x][y] == 0 || visited[x][y])
            return 0;
        visited[x][y] = true;
        return 1 + cnt(grid, visited, x-1, y)
             + cnt(grid, visited, x+1, y)
             + cnt(grid, visited, x, y-1)
             + cnt(grid, visited, x, y+1);
    }
}
