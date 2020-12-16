/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 *
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (43.89%)
 * Total Accepted:    374.8K
 * Total Submissions: 853.8K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * Given an m x n matrix. If an element is 0, set its entire row and column to
 * 0. Do it in-place.
 * 
 * Follow up:
 * 
 * 
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best
 * solution.
 * Could you devise a constant space solution?
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 * 
 * 
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int r = -1;
        int c = -1;
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    if (r < 0) {
                        r = i;
                        c = j;
                    } else {
                        matrix[r][j] = 0;
                        matrix[i][c] = 0;
                    }
                }
            }
        }
        if (r < 0)
            return;
        for (int j = 0; j < m; j++)
            if (matrix[r][j] == 0 && j != c) {
                for (int i = 0; i < n; i++)
                    matrix[i][j] = 0;
            }
        for (int i = 0; i < n; i++)
            if (matrix[i][c] == 0) {
                for (int j = 0; j < m; j++)
                    matrix[i][j] = 0;
            }
        for (int i = 0; i < n; i++)
            matrix[i][c] = 0;
    }
}
