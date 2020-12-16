/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 *
 * https://leetcode.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (38.35%)
 * Total Accepted:    310.9K
 * Total Submissions: 810.6K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * Given an m x n binary matrix filled with 0's and 1's, find the largest
 * square containing only 1's and return its area.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix =
 * [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: matrix = [["0"]]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is '0' or '1'.
 * 
 * 
 */
class Solution {
    public int maximalSquare(char[][] mat) {
        int max = 0;
        int n = mat.length;
        if (n < 1)
            return max;
        int m = mat[0].length;
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                matrix[i][j] = mat[i][j] - '0';
                max = Math.max(max, matrix[i][j]);
            }

        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                if (matrix[i][j] == 1) {
                    matrix[i][j] = Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1]) + 1;
                    max = Math.max(max, matrix[i][j]);
                }
        return max * max;
    }
}
