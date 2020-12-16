/*
 * @lc app=leetcode id=840 lang=java
 *
 * [840] Magic Squares In Grid
 *
 * https://leetcode.com/problems/magic-squares-in-grid/description/
 *
 * algorithms
 * Medium (37.70%)
 * Total Accepted:    26.8K
 * Total Submissions: 71.1K
 * Testcase Example:  '[[4,3,8,4],[9,5,1,9],[2,7,6,2]]'
 *
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to
 * 9 such that each row, column, and both diagonals all have the same sum.
 * 
 * Given a row x col grid of integers, how many 3 x 3 "magic square" subgrids
 * are there?  (Each subgrid is contiguous).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
 * Output: 1
 * Explanation: 
 * The following subgrid is a 3 x 3 magic square:
 * 
 * while this one is not:
 * 
 * In total, there is only one magic square inside the given grid.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [[8]]
 * Output: 0
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: grid = [[4,4],[3,3]]
 * Output: 0
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: grid = [[4,7,8],[9,5,1],[2,3,6]]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 10
 * 0 <= grid[i][j] <= 15
 * 
 * 
 */
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length - 2; i++)
            for (int j = 0; j < grid[0].length - 2; j++)
                ans += check(i, j, grid);
        return ans;
    }
    
    int check(int n, int m, int[][] grid) {
        int[] cnt = new int[10];
        for (int i = 0; i < 3; i++) {
            int r, c;
            r = c = 0;
            for (int j = 0; j < 3; j++) {
                int cur = grid[n+i][m+j];
                if (cur < 1 || cur > 9 || cnt[cur] > 0)
                    return 0;
                cnt[cur]++;
                r += grid[n+i][m+j];
                c += grid[n+j][m+i];
            }
            if (r != 15 || c != 15)
                return 0;
        }
        if (15 != grid[n][m]+grid[n+1][m+1]+grid[n+2][m+2]
            || 15 != grid[n+2][m]+grid[n+1][m+1]+grid[n][m+2])
            return 0;
        return 1;
    }
}
