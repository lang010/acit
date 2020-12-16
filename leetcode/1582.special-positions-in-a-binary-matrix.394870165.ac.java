/*
 * @lc app=leetcode id=1582 lang=java
 *
 * [1582] Special Positions in a Binary Matrix
 *
 * https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/
 *
 * algorithms
 * Easy (63.98%)
 * Total Accepted:    16.5K
 * Total Submissions: 25.8K
 * Testcase Example:  '[[1,0,0],[0,0,1],[1,0,0]]'
 *
 * Given a rows x cols matrix mat, where mat[i][j] is either 0 or 1, return the
 * number of special positions in mat.
 * 
 * A position (i,j) is called special if mat[i][j] == 1 and all other elements
 * in row i and column j are 0 (rows and columns are 0-indexed).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: mat = [[1,0,0],
 * [0,0,1],
 * [1,0,0]]
 * Output: 1
 * Explanation: (1,2) is a special position because mat[1][2] == 1 and all
 * other elements in row 1 and column 2 are 0.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: mat = [[1,0,0],
 * [0,1,0],
 * [0,0,1]]
 * Output: 3
 * Explanation: (0,0), (1,1) and (2,2) are special positions. 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: mat = [[0,0,0,1],
 * [1,0,0,0],
 * [0,1,1,0],
 * [0,0,0,0]]
 * Output: 2
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: mat = [[0,0,0,0,0],
 * [1,0,0,0,0],
 * [0,1,0,0,0],
 * [0,0,1,0,0],
 * [0,0,0,1,1]]
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] is 0 or 1.
 * 
 * 
 */
class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        if (n < 1)
            return 0;
        int m = mat[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (mat[i][j] != 0) {
                    row[i]++;
                    col[j]++;
                }
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (mat[i][j] == 1 && col[j] == 1 && row[i] == 1) {
                    ans++;
                }
        return ans;
    }
}
