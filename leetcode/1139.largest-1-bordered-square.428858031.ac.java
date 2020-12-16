/*
 * @lc app=leetcode id=1139 lang=java
 *
 * [1139] Largest 1-Bordered Square
 *
 * https://leetcode.com/problems/largest-1-bordered-square/description/
 *
 * algorithms
 * Medium (48.13%)
 * Total Accepted:    11.9K
 * Total Submissions: 24.8K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * Given a 2D grid of 0s and 1s, return the number of elements in the largest
 * square subgrid that has all 1s on its border, or 0 if such a subgrid doesn't
 * exist in the grid.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 9
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [[1,1,0,0]]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= grid.length <= 100
 * 1 <= grid[0].length <= 100
 * grid[i][j] is 0 or 1
 * 
 */
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] lens = new int[n][m];
        int[] hs = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    hs[j] = 0;
                    lens[i][j] = 0;
                } else {
                    hs[j]++;
                    lens[i][j] = j > 0 ? lens[i][j-1]+1 : 1;
                    int d = Math.min(hs[j], lens[i][j]);
                    while (max < d) {
                        if (hs[j-d+1] >= d && lens[i-d+1][j] >= d)
                            max = d;
                        d--;
                    }
                }
            }
        }
        return max*max;
    }

}
