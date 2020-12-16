/*
 * @lc app=leetcode id=1329 lang=java
 *
 * [1329] Sort the Matrix Diagonally
 *
 * https://leetcode.com/problems/sort-the-matrix-diagonally/description/
 *
 * algorithms
 * Medium (78.95%)
 * Total Accepted:    27.1K
 * Total Submissions: 34.3K
 * Testcase Example:  '[[3,3,1,1],[2,2,1,2],[1,1,1,2]]'
 *
 * Given a m * n matrix mat of integers, sort it diagonally in ascending order
 * from the top-left to the bottom-right then return the sorted array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
 * Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * 1 <= mat[i][j] <= 100
 * 
 */
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] buf = new int[Math.max(n, m)];
        for (int i = 0; i < n; i++) {
            int cnt = copy(mat, buf, i, 0);
            Arrays.sort(buf, 0, cnt);
            copy(buf, mat, i, 0);
        }
        for (int i = 0; i < m; i++) {
            int cnt = copy(mat, buf, 0, i);
            Arrays.sort(buf, 0, cnt);
            copy(buf, mat, 0, i);
        }
        return mat;
    }
    
    int copy(int[][] mat, int[] buf, int i, int j) {
        int id = 0;
        while (i < mat.length && j < mat[0].length)
            buf[id++] = mat[i++][j++];
        return id;
    }
    
    int copy(int[] buf, int[][] mat, int i, int j) {
        int id = 0;
        while (i < mat.length && j < mat[0].length) {
            mat[i++][j++] = buf[id++];
        }
        return id;
    }
}
