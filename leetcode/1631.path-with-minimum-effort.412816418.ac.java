/*
 * @lc app=leetcode id=1631 lang=java
 *
 * [1631] Path With Minimum Effort
 *
 * https://leetcode.com/problems/path-with-minimum-effort/description/
 *
 * algorithms
 * Medium (41.34%)
 * Total Accepted:    9.5K
 * Total Submissions: 23.1K
 * Testcase Example:  '[[1,2,2],[3,8,2],[5,3,5]]'
 *
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D
 * array of size rows x columns, where heights[row][col] represents the height
 * of cell (row, col). You are situated in the top-left cell, (0, 0), and you
 * hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e.,
 * 0-indexed). You can move up, down, left, or right, and you wish to find a
 * route that requires the minimum effort.
 * 
 * A route's effort is the maximum absolute difference in heights between two
 * consecutive cells of the route.
 * 
 * Return the minimum effort required to travel from the top-left cell to the
 * bottom-right cell.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
 * Output: 2
 * Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2
 * in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute
 * difference is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
 * Output: 1
 * Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1
 * in consecutive cells, which is better than route [1,3,5,3,5].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: heights =
 * [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * Output: 0
 * Explanation: This route does not require any effort.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 10^6
 * 
 * 
 */
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int n = heights.length;
        int m = heights[0].length;
        int[][] vals = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(vals[i], 1000000);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] {0, 0, 0});
        vals[0][0] = 0;
        while (true) {
            int[] cur = pq.poll();
            if (cur[0] == n-1 && cur[1] == m-1)
                return cur[2];
            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    int z = Math.max(cur[2], Math.abs(heights[cur[0]][cur[1]]-heights[x][y]));
                    if (z < vals[x][y]) {
                        vals[x][y] = z;
                        pq.offer(new int[] {x, y, z});
                    }
                }
            }
        }
    }
}
