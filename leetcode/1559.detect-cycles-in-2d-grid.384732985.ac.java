/*
 * @lc app=leetcode id=1559 lang=java
 *
 * [1559] Detect Cycles in 2D Grid
 *
 * https://leetcode.com/problems/detect-cycles-in-2d-grid/description/
 *
 * algorithms
 * Hard (44.65%)
 * Total Accepted:    8K
 * Total Submissions: 17.9K
 * Testcase Example:  '[["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]'
 *
 * Given a 2D array of characters grid of size m x n, you need to find if there
 * exists any cycle consisting of the same value in grid.
 * 
 * A cycle is a path of length 4 or more in the grid that starts and ends at
 * the same cell. From a given cell, you can move to one of the cells adjacent
 * to it - in one of the four directions (up, down, left, or right), if it has
 * the same value of the current cell.
 * 
 * Also, you cannot move to the cell that you visited in your last move. For
 * example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2)
 * we visited (1, 1) which was the last visited cell.
 * 
 * Return true if any cycle of the same value exists in grid, otherwise, return
 * false.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: grid =
 * [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
 * Output: true
 * Explanation: There are two valid cycles shown in different colors in the
 * image below:
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: grid =
 * [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c","c"]]
 * Output: true
 * Explanation: There is only one valid cycle highlighted in the image
 * below:
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * 
 * 
 * Input: grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 500
 * 1 <= n <= 500
 * grid consists only of lowercase English letters.
 * 
 * 
 */
class Solution {
    int[][] next = { {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int sx, sy;
    int[][] visited;
    int n, m;
    char cur;
    public boolean containsCycle(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                sx = i;
                sy = j;
                cur = grid[i][j];
                if (dfs(grid, i, j, 0))
                    return true;
            }
        return false;
    }
    
    boolean dfs(char[][] grid, int x, int y, int len) {
        if (x < 0 || y < 0 || x >= n || y >= m)
            return false;
        if (grid[x][y] != cur)
            return false;
        len++;
        if (visited[x][y] > 0) {
            if (len - visited[x][y] >= 4)
                return true;
            return false;
        }
        visited[x][y] = len;
        for (int i = 0; i < 4; i++) {
            if (dfs(grid, x+next[i][0], y+next[i][1], len))
                return true;
        }
        return false;
    }
}
