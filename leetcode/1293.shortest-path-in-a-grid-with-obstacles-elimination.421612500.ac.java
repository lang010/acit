/*
 * @lc app=leetcode id=1293 lang=java
 *
 * [1293] Shortest Path in a Grid with Obstacles Elimination
 *
 * https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/description/
 *
 * algorithms
 * Hard (42.68%)
 * Total Accepted:    20.7K
 * Total Submissions: 48.6K
 * Testcase Example:  '[[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]]\n1'
 *
 * Given a m * n grid, where each cell is either 0 (empty) or 1 (obstacle). In
 * one step, you can move up, down, left or right from and to an empty cell.
 * 
 * Return the minimum number of steps to walk from the upper left corner (0, 0)
 * to the lower right corner (m-1, n-1) given that you can eliminate at most k
 * obstacles. If it is not possible to find such walk return -1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * grid = 
 * [[0,0,0],
 * [1,1,0],
 * ⁠[0,0,0],
 * [0,1,1],
 * ⁠[0,0,0]], 
 * k = 1
 * Output: 6
 * Explanation: 
 * The shortest path without eliminating any obstacle is 10. 
 * The shortest path with one obstacle elimination at position (3,2) is 6. Such
 * path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * grid = 
 * [[0,1,1],
 * [1,1,1],
 * [1,0,0]], 
 * k = 1
 * Output: -1
 * Explanation: 
 * We need to eliminate at least two obstacles to find such a walk.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * grid.length == m
 * grid[0].length == n
 * 1 <= m, n <= 40
 * 1 <= k <= m*n
 * grid[i][j] == 0 or 1
 * grid[0][0] == grid[m-1][n-1] == 0
 * 
 * 
 */
class Solution {
    public int shortestPath(int[][] grid, int k) {
        int[][] dirs = { {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new ArrayDeque<>();
        int n = grid.length-1, m = grid[0].length-1;
        int ans = 0;
        int[][] visited = new int[n+1][m+1];
        queue.offer(new int[] {0, 0, 0});
        visited[0][0] = k+1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == n && cur[1] == m)
                return cur[2];
            for (int[] d : dirs) {
                int x = d[0] + cur[0];
                int y = d[1] + cur[1];
                int z = cur[2];
                if (x >= 0 && x <= n && y >= 0 && y <= m) {
                    if (visited[cur[0]][cur[1]] - grid[x][y] > visited[x][y]) {
                        visited[x][y] = visited[cur[0]][cur[1]] - grid[x][y];
                        queue.offer(new int[] {x, y, z+1});
                    }
                }
            }
        }
        return -1;
    }
}
