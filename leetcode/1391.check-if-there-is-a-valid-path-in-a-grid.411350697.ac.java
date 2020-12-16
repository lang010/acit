/*
 * @lc app=leetcode id=1391 lang=java
 *
 * [1391] Check if There is a Valid Path in a Grid
 *
 * https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/description/
 *
 * algorithms
 * Medium (44.99%)
 * Total Accepted:    12.5K
 * Total Submissions: 27.9K
 * Testcase Example:  '[[2,4,3],[6,5,2]]'
 *
 * Given a m x n grid. Each cell of the grid represents a street. The street of
 * grid[i][j] can be:
 * 
 * 1 which means a street connecting the left cell and the right cell.
 * 2 which means a street connecting the upper cell and the lower cell.
 * 3 which means a street connecting the left cell and the lower cell.
 * 4 which means a street connecting the right cell and the lower cell.
 * 5 which means a street connecting the left cell and the upper cell.
 * 6 which means a street connecting the right cell and the upper cell.
 * 
 * 
 * 
 * 
 * You will initially start at the street of the upper-left cell (0,0). A valid
 * path in the grid is a path which starts from the upper left cell (0,0) and
 * ends at the bottom-right cell (m - 1, n - 1). The path should only follow
 * the streets.
 * 
 * Notice that you are not allowed to change any street.
 * 
 * Return true if there is a valid path in the grid or false otherwise.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[2,4,3],[6,5,2]]
 * Output: true
 * Explanation: As shown you can start at cell (0, 0) and visit all the cells
 * of the grid to reach (m - 1, n - 1).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [[1,2,1],[1,2,1]]
 * Output: false
 * Explanation: As shown you the street at cell (0, 0) is not connected with
 * any street of any other cell and you will get stuck at cell (0, 0)
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: grid = [[1,1,2]]
 * Output: false
 * Explanation: You will get stuck at cell (0, 1) and you cannot reach cell (0,
 * 2).
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: grid = [[1,1,1,1,1,1,3]]
 * Output: true
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: grid = [[2],[2],[2],[2],[2],[2],[6]]
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * 1 <= grid[i][j] <= 6
 * 
 * 
 */
class Solution {
    
    int[][][] dir = {{}, {{0, 1}, {0, -1}}, {{1, 0}, {-1, 0}}, {{0, -1}, {1, 0}},
                     {{0, 1}, {1, 0}}, {{-1, 0}, {0, -1}}, {{-1, 0}, {0, 1}}};
    int[][][] val = {{}, {{0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 0, 1, 0, 1}},
                     {{0, 0, 1, 0, 0, 1, 1}, {0, 0, 1, 1, 1, 0, 0}},
                     {{0, 1, 0, 0, 1, 0, 1}, {0, 0, 1, 0, 0, 1, 1}},
                     {{0, 1, 0, 1, 0, 1, 0}, {0, 0, 1, 0, 0, 1, 1}},
                     {{0, 0, 1, 1, 1, 0, 0}, {0, 1, 0, 0, 1, 0, 1}},
                     {{0, 0, 1, 1, 1, 0, 0}, {0, 1, 0, 1, 0, 1, 0}}};
    
    int n, m;
    boolean[][] visited;
    
    public boolean hasValidPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        
        return dfs(grid, 0, 0);
    }

    boolean dfs(int[][] grid, int x, int y) {
        visited[x][y] = true;
        if (x == n-1 && y == m-1)
            return true;
        int cur = grid[x][y];
        for (int i = 0; i < 2; i++) {
            int[] d = dir[cur][i];
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]
                && val[cur][i][grid[nx][ny]] == 1 && dfs(grid, nx, ny)) {
                return true;
            }
        }
        return false;
    }
}
