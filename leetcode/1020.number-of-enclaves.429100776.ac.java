/*
 * @lc app=leetcode id=1020 lang=java
 *
 * [1020] Number of Enclaves
 *
 * https://leetcode.com/problems/number-of-enclaves/description/
 *
 * algorithms
 * Medium (58.62%)
 * Total Accepted:    22.7K
 * Total Submissions: 38.7K
 * Testcase Example:  '[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]'
 *
 * Given a 2D array A, each cell is 0 (representing sea) or 1 (representing
 * land)
 * 
 * A move consists of walking from one land square 4-directionally to another
 * land square, or off the boundary of the grid.
 * 
 * Return the number of land squares in the grid for which we cannot walk off
 * the boundary of the grid in any number of moves.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation: 
 * There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed
 * because its on the boundary.
 * 
 * Example 2:
 * 
 * 
 * Input: [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * Output: 0
 * Explanation: 
 * All 1s are either on the boundary or can reach the boundary.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 500
 * 1 <= A[i].length <= 500
 * 0 <= A[i][j] <= 1
 * All rows have the same size.
 * 
 */
class Solution {
    int[][] dirs = new int[][] { {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int n, m;
    public int numEnclaves(int[][] A) {
        n = A.length;
        m = A[0].length;
        for (int i = 0; i < n; i++) {
            dfs(A, i, 0);
            dfs(A, i, m-1);
        }
        for (int i = 0; i < m; i++) {
            dfs(A, 0, i);
            dfs(A, n-1, i);
        }
        int ans = 0;
        for (int i = 1; i < n-1; i++)
            for (int j = 1; j < m-1; j++)
                ans += A[i][j];
        return ans;
    }
    
    void dfs(int[][] A, int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m)
            return;
        if (A[x][y] == 1) {
            A[x][y] = 0;
            for (int[] d : dirs)
                dfs(A, x + d[0], y + d[1]);
        }
    }
}
