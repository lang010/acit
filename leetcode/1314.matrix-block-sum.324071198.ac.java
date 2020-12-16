/*
 * @lc app=leetcode id=1314 lang=java
 *
 * [1314] Matrix Block Sum
 *
 * https://leetcode.com/problems/matrix-block-sum/description/
 *
 * algorithms
 * Medium (73.53%)
 * Total Accepted:    25.4K
 * Total Submissions: 34.5K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]\n1'
 *
 * Given a m * n matrix mat and an integer K, return a matrix answer where each
 * answer[i][j] is the sum of all elements mat[r][c] for i - K <= r <= i + K, j
 * - K <= c <= j + K, and (r, c) is a valid position in the matrix.
 * 
 * Example 1:
 * 
 * 
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 * Output: [[12,21,16],[27,45,33],[24,39,28]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 * Output: [[45,45,45],[45,45,45],[45,45,45]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n, K <= 100
 * 1 <= mat[i][j] <= 100
 * 
 */
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 1; i < m; i++)
            mat[0][i] += mat[0][i-1];
        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += mat[i][j];
                mat[i][j] = sum + mat[i-1][j];
            }
        }
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                int ir = Math.min(i+K, n-1);
                int jr = Math.min(j+K, m-1);
                int il = i-K-1;
                int jl = j-K-1;
                ans[i][j] = mat[ir][jr];
                if (il >= 0)
                    ans[i][j] -= mat[il][jr];
                if (jl >= 0)
                    ans[i][j] -= mat[ir][jl];
                if (il >= 0 && jl >= 0)
                    ans[i][j] += mat[il][jl];
            }
        return ans;
    }
}
