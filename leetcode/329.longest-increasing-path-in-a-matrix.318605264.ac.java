/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 *
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
 *
 * algorithms
 * Hard (44.17%)
 * Total Accepted:    179.3K
 * Total Submissions: 406K
 * Testcase Example:  '[[9,9,4],[6,6,8],[2,1,1]]'
 *
 * Given an integer matrix, find the length of the longest increasing path.
 * 
 * From each cell, you can either move to four directions: left, right, up or
 * down. You may NOT move diagonally or move outside of the boundary (i.e.
 * wrap-around is not allowed).
 * 
 * Example 1:
 * 
 * 
 * Input: nums = 
 * [
 * ⁠ [9,9,4],
 * ⁠ [6,6,8],
 * ⁠ [2,1,1]
 * ] 
 * Output: 4 
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = 
 * [
 * ⁠ [3,4,5],
 * ⁠ [3,2,6],
 * ⁠ [2,2,1]
 * ] 
 * Output: 4 
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally
 * is not allowed.
 * 
 * 
 */
class Solution {
    int[][] len;
    int n;
    int m;
    int[][] next = { {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length < 1)
            return 0;
        n = matrix.length;
        m = matrix[0].length;
        len = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (len[i][j] == 0) {
                    dfs(matrix, i, j);
                    if (len[i][j] > ans)
                       ans = len[i][j];
                }
        }
        return ans;
    }
    
    int dfs(int[][] matrix, int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m)
           return 0;
        if (len[x][y] != 0)
            return len[x][y];
        len[x][y] = 1;
        int val = matrix[x][y];
        for (int i = 0; i < next.length; i++) {
            int nx = x + next[i][0];
            int ny = y + next[i][1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue;
            if (val < matrix[nx][ny])
                len[x][y] = Math.max(dfs(matrix, nx, ny) + 1, len[x][y]);
        }
        return len[x][y];
    }
}
