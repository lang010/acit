/*
 * @lc app=leetcode id=1536 lang=java
 *
 * [1536] Minimum Swaps to Arrange a Binary Grid
 *
 * https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/description/
 *
 * algorithms
 * Medium (43.01%)
 * Total Accepted:    7.8K
 * Total Submissions: 18.2K
 * Testcase Example:  '[[0,0,1],[1,1,0],[1,0,0]]'
 *
 * Given an n x n binary grid, in one step you can choose two adjacent rows of
 * the grid and swap them.
 * 
 * A grid is said to be valid if all the cells above the main diagonal are
 * zeros.
 * 
 * Return the minimum number of steps needed to make the grid valid, or -1 if
 * the grid cannot be valid.
 * 
 * The main diagonal of a grid is the diagonal that starts at cell (1, 1) and
 * ends at cell (n, n).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[0,0,1],[1,1,0],[1,0,0]]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]
 * Output: -1
 * Explanation: All rows are similar, swaps have no effect on the grid.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: grid = [[1,0,0],[1,1,0],[1,1,1]]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 200
 * grid[i][j] is 0 or 1
 * 
 * 
 */
class Solution {
    public int minSwaps(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            for (int j = n-1; j >= 0; j--)
                if (grid[i][j] == 1) {
                    arr[i] = j+1;
                    break;
                }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[j] <= i+1) {
                    ans += j-i;
                    while (j > i) {
                        int t = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = t;
                        j--;
                    }
                    break;
                }
            }
            if (arr[i] > i+1)
                return -1;
        }
        return ans;
    }
}
