/*
 * @lc app=leetcode id=1219 lang=java
 *
 * [1219] Path with Maximum Gold
 *
 * https://leetcode.com/problems/path-with-maximum-gold/description/
 *
 * algorithms
 * Medium (65.47%)
 * Total Accepted:    40.2K
 * Total Submissions: 61.5K
 * Testcase Example:  '[[0,6,0],[5,8,7],[0,9,0]]'
 *
 * In a gold mine grid of size m * n, each cell in this mine has an integer
 * representing the amount of gold in that cell, 0 if it is empty.
 * 
 * Return the maximum amount of gold you can collect under the
 * conditions:
 * 
 * 
 * Every time you are located in a cell you will collect all the gold in that
 * cell.
 * From your position you can walk one step to the left, right, up or down.
 * You can't visit the same cell more than once.
 * Never visit a cell with 0 gold.
 * You can start and stop collecting gold from any position in the grid that
 * has some gold.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
 * Output: 24
 * Explanation:
 * [[0,6,0],
 * ⁠[5,8,7],
 * ⁠[0,9,0]]
 * Path to get the maximum gold, 9 -> 8 -> 7.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 * Output: 28
 * Explanation:
 * [[1,0,7],
 * ⁠[2,0,6],
 * ⁠[3,4,5],
 * ⁠[0,3,0],
 * ⁠[9,0,20]]
 * Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= grid.length, grid[i].length <= 15
 * 0 <= grid[i][j] <= 100
 * There are at most 25 cells containing gold.
 * 
 * 
 */
class Solution {
    int[][] vi;
    int n, m;
    int max = 0;
    int[][] next = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
    public int getMaximumGold(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        vi = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dfs(grid, i, j, 0);
        return max;
    }
    
    void dfs(int[][] grid, int x, int y, int cur) {
        if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 0 || vi[x][y] != 0)
            return;
        vi[x][y] = 1;
        cur += grid[x][y];
        max = Math.max(max, cur);
        for (int i = 0; i < next.length; i++)
            dfs(grid, x+next[i][0], y+next[i][1], cur);
        vi[x][y] = 0;
    }
}
