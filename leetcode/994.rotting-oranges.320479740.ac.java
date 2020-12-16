/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 *
 * https://leetcode.com/problems/rotting-oranges/description/
 *
 * algorithms
 * Medium (49.45%)
 * Total Accepted:    179.9K
 * Total Submissions: 363.8K
 * Testcase Example:  '[[2,1,1],[1,1,0],[0,1,1]]'
 *
 * In a given grid, each cell can have one of three values:
 * 
 * 
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * 
 * 
 * Every minute, any fresh orange that is adjacent (4-directionally) to a
 * rotten orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange.  If this is impossible, return -1 instead.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is
 * never rotten, because rotting only happens 4-directionally.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the
 * answer is just 0.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    int[][] next = { {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.addLast(i*m+j);
                    while (!queue.isEmpty()) {
                        int cur = queue.removeFirst();
                        int days = grid[cur/m][cur%m] + 1;
                        for (int k = 0; k < 4; k++) {
                            int x = cur/m + next[k][0];
                            int y = cur%m + next[k][1];
                            if (x < 0 || y < 0 || x >= n || y >= m)
                                continue;
                            if (grid[x][y] == 1 || grid[x][y] > days) {
                                grid[x][y] = days;
                                queue.addLast(x*m + y);
                            }
                        }
                    }
                }
            }
        }
        int len = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (grid[x][y] == 1)
                    return -1;
                else if (grid[x][y] > len)
                    len = grid[x][y];
            }
        }
        
        return len > 2 ? len-2 : 0;
    }
}
