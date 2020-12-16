/*
 * @lc app=leetcode id=694 lang=java
 *
 * [694] Number of Distinct Islands
 *
 * https://leetcode.com/problems/number-of-distinct-islands/description/
 *
 * algorithms
 * Medium (57.01%)
 * Total Accepted:    73.2K
 * Total Submissions: 128.5K
 * Testcase Example:  '[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]'
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.)  You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * Count the number of distinct islands.  An island is considered to be the
 * same as another if and only if one island can be translated (and not rotated
 * or reflected) to equal the other.
 * 
 * Example 1:
 * 
 * 11000
 * 11000
 * 00011
 * 00011
 * 
 * Given the above grid map, return 1.
 * 
 * 
 * Example 2:
 * 11011
 * 10000
 * 00001
 * 11011
 * Given the above grid map, return 3.
 * Notice that:
 * 
 * 11
 * 1
 * 
 * and
 * 
 * ⁠1
 * 11
 * 
 * are considered different island shapes, because we do not consider
 * reflection / rotation.
 * 
 * 
 * Note:
 * The length of each dimension in the given grid does not exceed 50.
 * 
 */
class Solution {
    int[][] next = {{ 0 , 1 }, {1, 0}, { -1, 0}, {0, -1}};
    
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] > 0) {
                    int m = grid[0].length;
                    queue.offer(i*m + j);
                    grid[i][j] = -1;
                    StringBuilder sb = new StringBuilder();
                    while (!queue.isEmpty()) {
                        int id = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = id/m + next[k][0];
                            int y = id%m + next[k][1];
                            if (x >= 0 && x < grid.length && y >= 0 && y < m && grid[x][y] > 0) {
                                grid[x][y] = -1;
                                sb.append(k+"#"+queue.size());
                                queue.offer(x*m+y);
                            }
                        }
                    }
                    set.add(sb.toString());
                }
        
        return set.size();
    }
}
