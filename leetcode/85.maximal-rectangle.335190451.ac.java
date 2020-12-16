/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 *
 * https://leetcode.com/problems/maximal-rectangle/description/
 *
 * algorithms
 * Hard (38.92%)
 * Total Accepted:    206K
 * Total Submissions: 529.3K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest
 * rectangle containing only 1's and return its area.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix =
 * [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = []
 * Output: 0
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: matrix = [["0"]]
 * Output: 0
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: matrix = [["1"]]
 * Output: 1
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: matrix = [["0","0"]]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * rows == matrix.length
 * cols == matrix.length
 * 0 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'.
 * 
 * 
 */
class Solution {
    public int maximalRectangle(char[][] mat) {
        int n = mat.length;
        if (n < 1)
            return 0;
        int m = mat[0].length;
        int[] dp = new int[m];
        int max = 0;
        for (char[] r : mat) {
            for (int i = 0; i < m; i++)
                if (r[i] == '0')
                    dp[i] = 0;
                else
                    dp[i]++;
            for (int j = 0; j < m; j++) {
                int min = dp[j];
                int k = j;
                while (k < m && dp[k] > 0) {
                    min = Math.min(min, dp[k]);
                    k++;
                    max = Math.max(max, (k-j)*min);
                }
            }
        }
        return max;
    }
}
