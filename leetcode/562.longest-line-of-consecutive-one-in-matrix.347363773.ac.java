/*
 * @lc app=leetcode id=562 lang=java
 *
 * [562] Longest Line of Consecutive One in Matrix
 *
 * https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/description/
 *
 * algorithms
 * Medium (46.15%)
 * Total Accepted:    31.8K
 * Total Submissions: 68.9K
 * Testcase Example:  '[[0,1,1,0],[0,1,1,0],[0,0,0,1]]'
 *
 * Given a 01 matrix M, find the longest line of consecutive one in the matrix.
 * The line could be horizontal, vertical, diagonal or anti-diagonal.
 * 
 * Example:
 * 
 * Input:
 * [[0,1,1,0],
 * ⁠[0,1,1,0],
 * ⁠[0,0,0,1]]
 * Output: 3
 * 
 * 
 * 
 * 
 * Hint:
 * The number of elements in the given matrix will not exceed 10,000.
 * 
 */
class Solution {
    public int longestLine(int[][] M) {
        int n = M.length;
        if (n == 0)
            return 0;
        int m = M[0].length;
        int[] vert = new int[m];
        int[] diag = new int[m];
        int[] anti = new int[m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 0) {
                    cnt = 0;
                    vert[j] = 0;
                    diag[j] = 0;
                } else {
                    max = Math.max(max, ++cnt);
                    max = Math.max(max, ++vert[j]);
                    if (j < m-1)
                        diag[j] = diag[j+1]+1;
                    else
                        diag[j] = 1;
                    max = Math.max(max, diag[j]);
                }
                int k = m-1-j;
                if (M[i][k] == 0)
                    anti[k] = 0;
                else {
                    if (k > 0)
                        anti[k] = anti[k-1]+1;
                    else
                        anti[k] = 1;
                    max = Math.max(max, anti[k]);
                }
            }
                
        }
        return max;
    }
}
