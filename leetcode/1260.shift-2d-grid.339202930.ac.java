/*
 * @lc app=leetcode id=1260 lang=java
 *
 * [1260] Shift 2D Grid
 *
 * https://leetcode.com/problems/shift-2d-grid/description/
 *
 * algorithms
 * Easy (61.74%)
 * Total Accepted:    22.2K
 * Total Submissions: 36K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]\n1'
 *
 * Given a 2D grid of size m x n and an integer k. You need to shift the grid k
 * times.
 * 
 * In one shift operation:
 * 
 * 
 * Element at grid[i][j] moves to grid[i][j + 1].
 * Element at grid[i][n - 1] moves to grid[i + 1][0].
 * Element at grid[m - 1][n - 1] moves to grid[0][0].
 * 
 * 
 * Return the 2D grid after applying shift operation k times.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * Output: [[9,1,2],[3,4,5],[6,7,8]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * Output: [[1,2,3],[4,5,6],[7,8,9]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 * 
 * 
 */
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for (int[] r : grid)
            shiftRight(r, k);
        int m = grid[0].length;
        int t = k/m;
        k %= m;
        for (int i = 0; i < m; i++)
            if (i < k)
                shiftDown(grid, i, t+1);
            else
                shiftDown(grid, i, t);
        
        return convert(grid);
    }
    
    void shiftDown(int[][] grid, int i, int k) {
        if (k == 0)
            return;
        int n = grid.length;
        k = k%n;
        reverse(grid, i, 0, n);
        reverse(grid, i, 0, k);
        reverse(grid, i, k, n);
    }
    
    void reverse(int[][] grid, int i, int l, int r) {
        r--;
        while (l < r) {
            int t = grid[l][i];
            grid[l][i] = grid[r][i];
            grid[r][i] = t;
            l++;
            r--;
        }
    }
    
    void shiftRight(int[] r, int k) {
        int n = r.length;
        reverse(r, 0, n);
        k = k%n;
        reverse(r, 0, k);
        reverse(r, k, n);
    }
    
    void reverse(int[] row, int l, int r) {
        r--;
        while (l < r) {
            int t = row[l];
            row[l] = row[r];
            row[r] = t;
            l++;
            r--;
        }
    }
    
    public List<List<Integer>> shiftGrid1(int[][] grid, int k) {
        for (int i = 0; i < k; i++)
            shift(grid);

        return convert(grid);
    }
    
    List<List<Integer>> convert(int[][] grid) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] r : grid) {
            List<Integer> ls = new ArrayList<>(r.length);
            ans.add(ls);
            for (int x : r)
                ls.add(x);
        }
        return ans;
    }
    
    void shift(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int[] r : grid) {
            int x = r[m-1];
            for (int i = m-1; i > 0; i--)
                r[i] = r[i-1];
            r[0] = x;
        }
        int t = grid[n-1][0];
        for (int i = n-1; i > 0; i--)
            grid[i][0] = grid[i-1][0];
        grid[0][0] = t;
    }
}
