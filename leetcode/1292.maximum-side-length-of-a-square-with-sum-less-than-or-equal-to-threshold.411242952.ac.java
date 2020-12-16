/*
 * @lc app=leetcode id=1292 lang=java
 *
 * [1292] Maximum Side Length of a Square with Sum Less than or Equal to Threshold
 *
 * https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/description/
 *
 * algorithms
 * Medium (50.32%)
 * Total Accepted:    15.5K
 * Total Submissions: 30.9K
 * Testcase Example:  '[[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]]\r\n4\r'
 *
 * Given a m x n matrix mat and an integer threshold. Return the maximum
 * side-length of a square with a sum less than or equal to threshold or return
 * 0 if there is no such square.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold =
 * 4
 * Output: 2
 * Explanation: The maximum side length of square with sum less than 4 is 2 as
 * shown.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]],
 * threshold = 1
 * Output: 0
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: mat = [[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]], threshold = 6
 * Output: 3
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: mat = [[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]],
 * threshold = 40184
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= m, n <= 300
 * m == mat.length
 * n == mat[i].length
 * 0 <= mat[i][j] <= 10000
 * 0 <= threshold <= 10^5
 * 
 * 
 */
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;
        int l = 0, r = Math.min(n, m);
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                if (mat[i][j] <= threshold)
                    l = 1;
                sum += mat[i][j];
                mat[i][j] = sum;
                if (i > 0)
                    mat[i][j] += mat[i-1][j];
            }
        }
        if (l == 0)
            return 0;
        
        while (l < r) {
            int len = l + (r-l+1)/2;
            boolean is = false;
            for (int i = len-1; i < n; i++) {
                for (int j = len-1; j < m; j++) {
                    int v = mat[i][j];
                    if (i >= len)
                        v -= mat[i-len][j];
                    if (j >= len)
                        v -= mat[i][j-len];
                    if (i >= len && j >= len)
                        v += mat[i-len][j-len];
                    if (v <= threshold) {
                        is = true;
                        break;
                    }
                }
                if (is)
                    break;
            }
            if (is)
                l = len;
            else
                r = len - 1;
        }
        return l;
    }
}
