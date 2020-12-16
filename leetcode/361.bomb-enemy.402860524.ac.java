/*
 * @lc app=leetcode id=361 lang=java
 *
 * [361] Bomb Enemy
 *
 * https://leetcode.com/problems/bomb-enemy/description/
 *
 * algorithms
 * Medium (46.45%)
 * Total Accepted:    48.8K
 * Total Submissions: 105.1K
 * Testcase Example:  '[["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]'
 *
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0'
 * (the number zero), return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted
 * point until it hits the wall since the wall is too strong to be destroyed.
 * Note: You can only put the bomb at an empty cell.
 * 
 * Example:
 * 
 * 
 * 
 * Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
 * Output: 3 
 * Explanation: For the given grid,
 * 
 * 0 E 0 0 
 * E 0 W E 
 * 0 E 0 0
 * 
 * Placing a bomb at (1,1) kills 3 enemies.
 * 
 * 
 */
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int n = grid.length;
        if (n == 0)
            return 0;
        int m = grid[0].length;
        int[] dp = new int[m];
        int ans = 0;
        for (int i = 0; i < m; i++)
            dp[i] = cnt(grid, 0, i);
        for (int i = 0; i < n; i++) {
            int l = 0;
            while (l < m) {
                if (grid[i][l] == 'W') {
                    dp[l] = cnt(grid, i+1, l);
                    l++;
                    continue;
                }
                int sum = 0;
                int st = l;
                while (l < m && grid[i][l] != 'W') {
                    if (grid[i][l] == 'E')
                        sum++;
                    l++;
                }
                for (int k = st; k < l; k++)
                    if (grid[i][k] == '0')
                        ans = Math.max(ans, sum + dp[k]);
            }
        }
        return ans;
    }
    
    int cnt(char[][] grid, int x, int y) {
        int ans = 0;
        while (x < grid.length) {
            if (grid[x][y] == 'W')
                break;
            if (grid[x][y] == 'E')
                ans++;
            x++;
        }
        return ans;
    }
}
