/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 *
 * https://leetcode.com/problems/range-sum-query-2d-immutable/description/
 *
 * algorithms
 * Medium (39.94%)
 * Total Accepted:    135.2K
 * Total Submissions: 338.6K
 * Testcase Example:  '["NumMatrix","sumRegion","sumRegion","sumRegion"]\n' +
  '[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]'
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2,
 * col2).
 * 
 * 
 * 
 * The above rectangle (with the red border) is defined by (row1, col1) = (2,
 * 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * 
 * 
 * Example:
 * 
 * Given matrix = [
 * ⁠ [3, 0, 1, 4, 2],
 * ⁠ [5, 6, 3, 2, 1],
 * ⁠ [1, 2, 0, 1, 5],
 * ⁠ [4, 1, 0, 1, 7],
 * ⁠ [1, 0, 3, 0, 5]
 * ]
 * 
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * 
 * 
 * 
 * Note:
 * 
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 * 
 * 
 */
class NumMatrix {
    
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        if (n < 1)
            return;
        int m = matrix[0].length;
        sum = new int[n][m];
        sum[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            sum[0][i] = sum[0][i-1] + matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            sum[i][0] = matrix[i][0];
            for (int j = 1; j < m; j++)
                sum[i][j] = sum[i][j-1] + matrix[i][j];
            for (int j = 0; j < m; j++)
                sum[i][j] += sum[i-1][j];
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = sum[row2][col2];
        if (row1 > 0)
            ans -= sum[row1-1][col2];
        if (col1 > 0)
            ans -= sum[row2][col1-1];
        if (row1 > 0 && col1 > 0)
            ans += sum[row1-1][col1-1];
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
