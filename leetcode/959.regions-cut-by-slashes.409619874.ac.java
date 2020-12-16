/*
 * @lc app=leetcode id=959 lang=java
 *
 * [959] Regions Cut By Slashes
 *
 * https://leetcode.com/problems/regions-cut-by-slashes/description/
 *
 * algorithms
 * Medium (66.76%)
 * Total Accepted:    23.3K
 * Total Submissions: 34.9K
 * Testcase Example:  '[" /","/ "]'
 *
 * In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a
 * /, \, or blank space.  These characters divide the square into contiguous
 * regions.
 * 
 * (Note that backslash characters are escaped, so a \ is represented as
 * "\\".)
 * 
 * Return the number of regions.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * " /",
 * "/ "
 * ]
 * Output: 2
 * Explanation: The 2x2 grid is as follows:
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * [
 * " /",
 * "  "
 * ]
 * Output: 1
 * Explanation: The 2x2 grid is as follows:
 * 
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * [
 * "\\/",
 * "/\\"
 * ]
 * Output: 4
 * Explanation: (Recall that because \ characters are escaped, "\\/" refers to
 * \/, and "/\\" refers to /\.)
 * The 2x2 grid is as follows:
 * 
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input:
 * [
 * "/\\",
 * "\\/"
 * ]
 * Output: 5
 * Explanation: (Recall that because \ characters are escaped, "/\\" refers to
 * /\, and "\\/" refers to \/.)
 * The 2x2 grid is as follows:
 * 
 * 
 * 
 * 
 * Example 5:
 * 
 * 
 * Input:
 * [
 * "//",
 * "/ "
 * ]
 * Output: 3
 * Explanation: The 2x2 grid is as follows:
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= grid.length == grid[0].length <= 30
 * grid[i][j] is either '/', '\', or ' '.
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    int[][][] map;
    int n;
    int m;
    public int regionsBySlashes(String[] grid) {
        n = grid.length;
        m = grid[0].length();
        map = new int[n][m][4];
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                for (int k = 0; k < 4; k++)
                    if (map[i][j][k] == 0)
                        dfs(grid, i, j, k, ++ans);
        
        return ans;
    }
    
    int[][] nextK = {{3, 1, -1, 0, 2},
                     {2, 0, 0, 1, 3},
                     {1, 3, 1, 0, 0},
                     {0, 2, 0, -1, 1}};
    
    void dfs(String[] grid, int x, int y, int k, int v) {
        if (x < 0 || y < 0 || x >= n || y >= m || map[x][y][k] != 0)
            return;
        map[x][y][k] = v;
        char c = grid[x].charAt(y);
        if (c == ' ')
            for (int i = 0; i < 4; i++)
                dfs(grid, x, y, i, v);
        else if (c == '/')
            dfs(grid, x, y, nextK[k][0], v);
        else
            dfs(grid, x, y, nextK[k][1], v);
        dfs(grid, x + nextK[k][2], y + nextK[k][3], nextK[k][4], v);
    }
}
