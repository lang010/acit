/*
 * @lc app=leetcode id=892 lang=java
 *
 * [892] Surface Area of 3D Shapes
 *
 * https://leetcode.com/problems/surface-area-of-3d-shapes/description/
 *
 * algorithms
 * Easy (59.50%)
 * Total Accepted:    20.8K
 * Total Submissions: 34.9K
 * Testcase Example:  '[[2]]'
 *
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 * 
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of
 * grid cell (i, j).
 * 
 * Return the total surface area of the resulting shapes.
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
 * Input: [[2]]
 * Output: 10
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,2],[3,4]]
 * Output: 34
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [[1,0],[0,2]]
 * Output: 16
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 32
 * 
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 46
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        if (n == 1)
            return 4*grid[0][0] + 2;
        int ans = 0;
        for (int[] r : grid) {
            ans += r[0] + r[n-1];
            if (r[0] > 0)
                ans += 2;
            for (int i = 1; i < n; i++) {
                ans += Math.abs(r[i]-r[i-1]);
                if (r[i] > 0)
                    ans += 2;
            }
        }
        for (int i = 0; i < n; i++) {
            ans += grid[0][i] + grid[n-1][i];
            for (int j = 1; j < n; j++)
                ans += Math.abs(grid[j][i] - grid[j-1][i]);
        }
        return ans;
    }
}
