/*
 * @lc app=leetcode id=498 lang=java
 *
 * [498] Diagonal Traverse
 *
 * https://leetcode.com/problems/diagonal-traverse/description/
 *
 * algorithms
 * Medium (49.03%)
 * Total Accepted:    99.5K
 * Total Submissions: 202.9K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of M x N elements (M rows, N columns), return all elements of
 * the matrix in diagonal order as shown in the below image.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * 
 * Output:  [1,2,4,7,5,3,6,8,9]
 * 
 * Explanation:
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The total number of elements of the given matrix will not exceed 10,000.
 * 
 */
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int i = 0, j = 0;
        int n = matrix.length;
        if (n == 0)
            return new int[0];
        int m = matrix[0].length;
        int cnt = 0;
        int[] ans = new int[n*m];
        while (cnt < n*m) {
            if (i < n && j < m)
                ans[cnt++] = matrix[i][j];
            if ((i+j)%2 == 0) {
                j++;i--;
            } else {
                i++;j--;
            }
            if (i < 0)
                i = 0;
            if (j < 0)
                j = 0;
        }
        return ans;
    }
}
