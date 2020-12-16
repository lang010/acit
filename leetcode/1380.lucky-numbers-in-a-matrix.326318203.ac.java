/*
 * @lc app=leetcode id=1380 lang=java
 *
 * [1380] Lucky Numbers in a Matrix
 *
 * https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/
 *
 * algorithms
 * Easy (70.87%)
 * Total Accepted:    35.8K
 * Total Submissions: 50.4K
 * Testcase Example:  '[[3,7,8],[9,11,13],[15,16,17]]'
 *
 * Given a m * n matrix of distinct numbers, return all lucky numbers in the
 * matrix in any order.
 * 
 * A lucky number is an element of the matrix such that it is the minimum
 * element in its row and maximum in its column.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * Output: [15]
 * Explanation: 15 is the only lucky number since it is the minimum in its row
 * and the maximum in its column
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * Output: [12]
 * Explanation: 12 is the only lucky number since it is the minimum in its row
 * and the maximum in its column.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: matrix = [[7,8],[1,2]]
 * Output: [7]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5.
 * All elements in the matrix are distinct.
 * 
 * 
 */
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int[] max = new int[m];
        for (int j = 0; j < m; j++) {
            max[j] = matrix[0][j];
            for (int i = 1; i < n; i++)
                max[j] = Math.max(max[j], matrix[i][j]);
        }
        for (int i = 0; i < n; i++) {
            int minJ = 0;
            for (int j = 1; j < m; j++)
                if (matrix[i][minJ] > matrix[i][j])
                    minJ = j;
            if (matrix[i][minJ] == max[minJ])
                ans.add(max[minJ]);
        }
        
        return ans;
    }
}
