/*
 * @lc app=leetcode id=1277 lang=java
 *
 * [1277] Count Square Submatrices with All Ones
 *
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
 *
 * algorithms
 * Medium (72.93%)
 * Total Accepted:    80.7K
 * Total Submissions: 110.6K
 * Testcase Example:  '[[0,1,1,1],[1,1,1,1],[0,1,1,1]]'
 *
 * Given a m * n matrix of ones and zeros, return how many square submatrices
 * have all ones.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix =
 * [
 * [0,1,1,1],
 * [1,1,1,1],
 * [0,1,1,1]
 * ]
 * Output: 15
 * Explanation: 
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = 
 * [
 * ⁠ [1,0,1],
 * ⁠ [1,1,0],
 * ⁠ [1,1,0]
 * ]
 * Output: 7
 * Explanation: 
 * There are 6 squares of side 1.  
 * There is 1 square of side 2. 
 * Total number of squares = 6 + 1 = 7.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 * 
 * 
 */
class Solution {
    public int countSquares(int[][] matrix) {
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++)
            ans += matrix[i][0];
        for (int i = 1; i < m; i++)
            ans += matrix[0][i];
        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1]);
                    ans += matrix[i][j];
                }
            }
        return ans;
    }
}
