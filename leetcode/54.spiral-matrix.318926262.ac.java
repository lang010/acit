/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (35.14%)
 * Total Accepted:    436.3K
 * Total Submissions: 1.2M
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * 
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length < 1)
            return ans;
        int R = matrix.length;
        int C = matrix[0].length;
        int r1 = 0, r2 = R-1, c1 = 0, c2 = C-1;
        int cnt = R*C;
        while (ans.size() < cnt) {
            for (int i = c1; i <= c2; i++)
                ans.add(matrix[r1][i]);
            for (int i = r1+1; i < r2; i++)
                ans.add(matrix[i][c2]);
            if (r1 < r2)
                for (int i = c2; i >= c1; i--)
                    ans.add(matrix[r2][i]);
            if (c1 < c2)
                for (int i = r2-1; i > r1; i--)
                    ans.add(matrix[i][c1]);
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }
}
