/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 *
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 *
 * algorithms
 * Medium (42.06%)
 * Total Accepted:    91.1K
 * Total Submissions: 216.6K
 * Testcase Example:  '[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]'
 *
 * Given an m x n matrix of non-negative integers representing the height of
 * each unit cell in a continent, the "Pacific ocean" touches the left and top
 * edges of the matrix and the "Atlantic ocean" touches the right and bottom
 * edges.
 * 
 * Water can only flow in four directions (up, down, left, or right) from a
 * cell to another one with height equal or lower.
 * 
 * Find the list of grid coordinates where water can flow to both the Pacific
 * and Atlantic ocean.
 * 
 * Note:
 * 
 * 
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given the following 5x5 matrix:
 * 
 * ⁠ Pacific ~   ~   ~   ~   ~ 
 * ⁠      ~  1   2   2   3  (5) *
 * ⁠      ~  3   2   3  (4) (4) *
 * ⁠      ~  2   4  (5)  3   1  *
 * ⁠      ~ (6) (7)  1   4   5  *
 * ⁠      ~ (5)  1   1   2   4  *
 * ⁠         *   *   *   *   * Atlantic
 * 
 * Return:
 * 
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with
 * parentheses in above matrix).
 * 
 * 
 * 
 * 
 */
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = matrix.length;
        if (matrix == null || n == 0)
            return ans;
        int m = matrix[0].length;
        int[][] flag = new int[n][m];
        for (int i = 0; i < n; i++) {
            flag[i][0] = 1;
            flag[i][m-1] |= 2;
        }
        for (int i = 0; i < m; i++) {
            flag[0][i] |= 1;
            flag[n-1][i] |= 2;
        }
        
        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++) {
                dfs(matrix, flag, i, j, 1);
                dfs(matrix, flag, n-i-1, m-j-1, 2);
            }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (flag[i][j] == 3) {
                    List<Integer> ls = new ArrayList<>();
                    ans.add(ls);
                    ls.add(i);
                    ls.add(j);
                }
        }
        
        return ans;
    }
    
    void dfs(int[][] mat, int[][] flag, int x, int y, int val) {
        if (!validate(x, y, mat))
            return;
        if ((flag[x][y] & val) > 0)
            return;
        int h = mat[x][y];
        if (validate(x, y-1, mat, flag, h, val)
            || validate(x-1, y, mat, flag, h, val)
            || validate(x+1, y, mat, flag, h, val)
            || validate(x, y+1, mat, flag, h, val)) {
            flag[x][y] |= val;
            dfs(mat, flag, x-1, y, val);
            dfs(mat, flag, x+1, y, val);
            dfs(mat, flag, x, y-1, val);
            dfs(mat, flag, x, y+1, val);
        }
    }
    
    boolean validate(int x, int y, int[][] mat, int[][] flag, int height, int val) {
        if (validate(x, y, mat)) {
            return mat[x][y] <= height && (flag[x][y] & val) > 0;
        }
        return false;
    }
    
    boolean validate(int x, int y, int[][] matrix) {
        return x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length;
    }
}
