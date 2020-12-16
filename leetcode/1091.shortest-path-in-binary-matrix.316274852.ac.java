/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 *
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
 *
 * algorithms
 * Medium (38.81%)
 * Total Accepted:    49.8K
 * Total Submissions: 128.4K
 * Testcase Example:  '[[0,1],[1,0]]'
 *
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 * 
 * A clear path from top-left to bottom-right has length k if and only if it is
 * composed of cells C_1, C_2, ..., C_k such that:
 * 
 * 
 * Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are
 * different and share an edge or corner)
 * C_1 is at location (0, 0) (ie. has value grid[0][0])
 * C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
 * If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] ==
 * 0).
 * 
 * 
 * Return the length of the shortest such clear path from top-left to
 * bottom-right.  If such a path does not exist, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [[0,1],[1,0]]
 * 
 * 
 * Output: 2
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[0,0,0],[1,1,0],[1,1,0]]
 * 
 * 
 * Output: 4
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= grid.length == grid[0].length <= 100
 * grid[r][c] is 0 or 1
 * 
 * 
 */
class Solution {
    static class Pos {
        int x, y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int[][] next = new int[][] {
        {-1, -1},
        {-1, 0},
        {-1, 1},
        {1, -1},
        {1, 0},
        {1, 1},
        {0, -1},
        {0, 1}
    };
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] > 0)
            return -1;
        Queue<Pos> queue = new LinkedList<>();
        int n = grid.length;
        if (n == 1)
            return 1;
        queue.add(new Pos(0, 0));
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            for (int i = 0; i < next.length; i++) {
                Pos p = new Pos(cur.x+next[i][0], cur.y+next[i][1]);
                if (isValidated(grid, p)) {
                    queue.add(p);
                    grid[p.x][p.y] = grid[cur.x][cur.y] + 1;
                }
            }
        }
        
        return grid[n-1][n-1] > 1 ? grid[n-1][n-1] : -1;
    }
    
    boolean isValidated(int[][] grid, Pos p) {
        int n = grid.length;
        if (p.x < n && p.y < n && p.x > -1 && p.y > -1)
            return grid[p.x][p.y] == 0;
        return false;
    }
}
