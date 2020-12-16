/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 *
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (37.11%)
 * Total Accepted:    396.1K
 * Total Submissions: 1.1M
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: matrix = [], target = 0
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 0 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 * 
 * 
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1)
            return false;
        int l = 0;
        int m = matrix[0].length;
        int r = matrix.length * m - 1;
        while (l <= r) {
            int p = l + (r-l)/2;
            if (matrix[p/m][p%m] == target)
                return true;
            if (matrix[p/m][p%m] < target)
                l = p+1;
            else
                r = p-1;
        }
        return false;
    }
}
