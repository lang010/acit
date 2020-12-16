/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (57.08%)
 * Total Accepted:    232.9K
 * Total Submissions: 408K
 * Testcase Example:  '3'
 *
 * Given a positive integer n, generate an n x n matrix filled with elements
 * from 1 to n^2 in spiral order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1
 * Output: [[1]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 20
 * 
 * 
 */
class Solution {
    int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int x = 0, y = -1;
        int k = 0;
        for (int i = 1; i <= n*n; i++) {
            int xx = x + next[k][0], yy = y + next[k][1];
            if (xx < 0 || yy < 0 || xx >= n || yy >= n || ans[xx][yy] != 0) {
                k = (k+1)%4;
            }
            x += next[k][0];
            y += next[k][1];
            ans[x][y] = i;
        }
        return ans;
    }
}
