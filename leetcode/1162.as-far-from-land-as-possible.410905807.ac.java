/*
 * @lc app=leetcode id=1162 lang=java
 *
 * [1162] As Far from Land as Possible
 *
 * https://leetcode.com/problems/as-far-from-land-as-possible/description/
 *
 * algorithms
 * Medium (44.55%)
 * Total Accepted:    27.1K
 * Total Submissions: 60.9K
 * Testcase Example:  '[[1,0,1],[0,0,0],[1,0,1]]'
 *
 * Given an n x n grid containing only values 0 and 1, where 0 represents water
 * and 1 represents land, find a water cell such that its distance to the
 * nearest land cell is maximized, and return the distance. If no land or water
 * exists in the grid, return -1.
 * 
 * The distance used in this problem is the Manhattan distance: the distance
 * between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 * Explanation: The cell (1, 1) is as far as possible from all the land with
 * distance 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
 * Output: 4
 * Explanation: The cell (2, 2) is as far as possible from all the land with
 * distance 4.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] is 0 or 1
 * 
 * 
 */
class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1)
                    queue.offer(i*n+j);
        int ans = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int v = queue.poll();
            int x = v/n;
            int y = v%n;
            for (int[] d : dirs) {
                int xx = x + d[0];
                int yy = y + d[1];
                if (xx >= 0 && yy >= 0 && xx < n && yy < n && grid[xx][yy] == 0) {
                    grid[xx][yy] = grid[x][y] + 1;
                    ans = Math.max(ans, grid[xx][yy]);
                    queue.offer(xx*n + yy);
                }
            }
        }
        return ans-1;
    }
}
