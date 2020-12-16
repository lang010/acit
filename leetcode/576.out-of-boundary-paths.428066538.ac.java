/*
 * @lc app=leetcode id=576 lang=java
 *
 * [576] Out of Boundary Paths
 *
 * https://leetcode.com/problems/out-of-boundary-paths/description/
 *
 * algorithms
 * Medium (35.63%)
 * Total Accepted:    32.7K
 * Total Submissions: 91.8K
 * Testcase Example:  '2\n2\n2\n0\n0'
 *
 * There is an m by n grid with a ball. Given the start coordinate (i,j) of the
 * ball, you can move the ball to adjacent cell or cross the grid boundary in
 * four directions (up, down, left, right). However, you can at most move N
 * times. Find out the number of paths to move the ball out of grid boundary.
 * The answer may be very large, return it after mod 10^9 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: m = 2, n = 2, N = 2, i = 0, j = 0
 * Output: 6
 * Explanation:
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: m = 1, n = 3, N = 3, i = 0, j = 1
 * Output: 12
 * Explanation:
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * Once you move the ball out of boundary, you cannot move it back.
 * The length and height of the grid is in range [1,50].
 * N is in range [0,50].
 * 
 * 
 */
class Solution {
    int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][] map = new int[m][n];
        map[i][j] = 1;
        int ans = 0;
        for (int t = 0; t < N; t++) {
            int[][] tmp = new int[m][n];
            for (i = 0; i < m; i++)
                for (j = 0; j < n; j++)
                    if (map[i][j] > 0)
                        for (int[] d : dirs) {
                            int x = i+d[0];
                            int y = j+d[1];
                            if (x < 0 || y < 0 || x >= m || y >= n)
                                ans = (ans + map[i][j]) % 1000000007;
                            else
                                tmp[x][y] = (tmp[x][y] + map[i][j]) % 1000000007;
                        }
            map = tmp;
        }
        return ans;
    }
}
