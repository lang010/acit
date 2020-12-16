/*
 * @lc app=leetcode id=286 lang=java
 *
 * [286] Walls and Gates
 *
 * https://leetcode.com/problems/walls-and-gates/description/
 *
 * algorithms
 * Medium (55.68%)
 * Total Accepted:    142.4K
 * Total Submissions: 255.7K
 * Testcase Example:  '[[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]'
 *
 * You are given a m x n 2D grid initialized with these three possible
 * values.
 * 
 * 
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647
 * to represent INF as you may assume that the distance to a gate is less than
 * 2147483647.
 * 
 * 
 * Fill each empty room with the distance to its nearest gate. If it is
 * impossible to reach a gate, it should be filled with INF.
 * 
 * Example: 
 * 
 * Given the 2D grid:
 * 
 * 
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 * ⁠ 0  -1 INF INF
 * 
 * 
 * After running your function, the 2D grid should be:
 * 
 * 
 * ⁠ 3  -1   0   1
 * ⁠ 2   2   1  -1
 * ⁠ 1  -1   2  -1
 * ⁠ 0  -1   3   4
 * 
 * 
 */
class Solution {
    
    int[][] next = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++)
            for (int j = 0; j < rooms[i].length; j++)
                if (rooms[i][j] == 0)
                    dfs(rooms, i, j);
    }
    
    void dfs(int[][] rooms, int i, int j) {
        int dist = rooms[i][j]+1;
        for (int k = 0; k < next.length; k++) {
            int x = i+next[k][0];
            int y = j+next[k][1];
            if (x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length)
                continue;
            if (rooms[x][y] > dist) {
                rooms[x][y] = dist;
                dfs(rooms, x, y);
            }
        }
    }
}
