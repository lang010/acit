/*
 * @lc app=leetcode id=308 lang=java
 *
 * [308] Range Sum Query 2D - Mutable
 *
 * https://leetcode.com/problems/range-sum-query-2d-mutable/description/
 *
 * algorithms
 * Hard (36.91%)
 * Total Accepted:    51.4K
 * Total Submissions: 139.3K
 * Testcase Example:  '["NumMatrix","sumRegion","update","sumRegion"]\n' +
  '[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[3,2,2],[2,1,4,3]]'
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
 * update(3, 2, 2)
 * sumRegion(2, 1, 4, 3) -> 10
 * 
 * 
 * 
 * Note:
 * 
 * The matrix is only modifiable by the update function.
 * You may assume the number of calls to update and sumRegion function is
 * distributed evenly.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 * 
 * 
 */
class NumMatrix {
    int[][] mat;
    int[][] sum;
    int n, m;

    public NumMatrix(int[][] matrix) {
        n = matrix.length+1;
        if (n == 1)
            return;
        m = matrix[0].length+1;
        sum = new int[n][m];
        mat = new int[n][m];
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < m-1; j++)
                update(i, j, matrix[i][j]);
    }
    
    public void update(int row, int col, int val) {
        row++;
        col++;
        int diff = val - mat[row][col];
        mat[row][col] = val;
        while (row < n) {
            int c = col;
            while (c < m) {
                sum[row][c] += diff;
                c += c & -c;
            }
            row += row & -row;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = cnt(row2, col2);
        if (row1 > 0)
            ans -= cnt(row1-1, col2);
        if (col1 > 0)
            ans -= cnt(row2, col1-1);
        if (row1 > 0 && col1 > 0)
            ans += cnt(row1-1, col1-1);
        return ans;
    }
    
    int cnt(int row, int col) {
        row++;
        col++;
        int ans = 0;
        while (row > 0) {
            int c = col;
            while (c > 0) {
                ans += sum[row][c];
                c -= c & -c;
            }
            row -= row & -row;
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
