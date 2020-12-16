/*
 * @lc app=leetcode id=363 lang=java
 *
 * [363] Max Sum of Rectangle No Larger Than K
 *
 * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/description/
 *
 * algorithms
 * Hard (38.23%)
 * Total Accepted:    50.2K
 * Total Submissions: 131.4K
 * Testcase Example:  '[[1,0,1],[0,-2,3]]\n2'
 *
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a
 * rectangle in the matrix such that its sum is no larger than k.
 * 
 * Example:
 * 
 * 
 * Input: matrix = [[1,0,1],[0,-2,3]], k = 2
 * Output: 2 
 * Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is
 * 2,
 * and 2 is the max number no larger than k (k = 2).
 * 
 * Note:
 * 
 * 
 * The rectangle inside the matrix must have an area > 0.
 * What if the number of rows is much larger than the number of columns?
 * 
 */
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int val) {
        int n = Math.min(matrix.length, matrix[0].length);
        int m = Math.max(matrix.length, matrix[0].length);
        boolean is = matrix.length > matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] sum = new int[m];
            for (int j = i; j < n; j++) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int tot = 0;
                for (int k = 0; k < m; k++) {
                    sum[k] += is ? matrix[k][j] : matrix[j][k];
                    tot += sum[k];
                    Integer v = set.ceiling(tot - val);
                    if (v != null)
                        ans = Math.max(ans, tot - v);
                    set.add(tot);
                }
            }
        }
        
        return ans;
    }
}
