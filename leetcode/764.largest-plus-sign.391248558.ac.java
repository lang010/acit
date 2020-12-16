/*
 * @lc app=leetcode id=764 lang=java
 *
 * [764] Largest Plus Sign
 *
 * https://leetcode.com/problems/largest-plus-sign/description/
 *
 * algorithms
 * Medium (46.15%)
 * Total Accepted:    23.2K
 * Total Submissions: 50.4K
 * Testcase Example:  '5\n[[4,2]]'
 *
 * 
 * In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1, except
 * those cells in the given list mines which are 0.  What is the largest
 * axis-aligned plus sign of 1s contained in the grid?  Return the order of the
 * plus sign.  If there is none, return 0.
 * 
 * An "axis-aligned plus sign of 1s of order k" has some center grid[x][y] = 1
 * along with 4 arms of length k-1 going up, down, left, and right, and made of
 * 1s.  This is demonstrated in the diagrams below.  Note that there could be
 * 0s or 1s beyond the arms of the plus sign, only the relevant area of the
 * plus sign is checked for 1s.
 * 
 * 
 * Examples of Axis-Aligned Plus Signs of Order k:
 * Order 1:
 * 000
 * 010
 * 000
 * 
 * Order 2:
 * 00000
 * 00100
 * 01110
 * 00100
 * 00000
 * 
 * Order 3:
 * 0000000
 * 0001000
 * 0001000
 * 0111110
 * 0001000
 * 0001000
 * 0000000
 * 
 * 
 * Example 1:
 * Input: N = 5, mines = [[4, 2]]
 * Output: 2
 * Explanation:
 * 11111
 * 11111
 * 11111
 * 11111
 * 11011
 * In the above grid, the largest plus sign can only be order 2.  One of them
 * is marked in bold.
 * 
 * 
 * Example 2:
 * Input: N = 2, mines = []
 * Output: 1
 * Explanation:
 * There is no plus sign of order 2, but there is of order 1.
 * 
 * 
 * Example 3:
 * Input: N = 1, mines = [[0, 0]]
 * Output: 0
 * Explanation:
 * There is no plus sign, so return 0.
 * 
 * 
 * Note:
 * N will be an integer in the range [1, 500].
 * mines will have length at most 5000.
 * mines[i] will be length 2 and consist of integers in the range [0, N-1].
 * (Additionally, programs submitted in C, C++, or C# will be judged with a
 * slightly smaller time limit.)
 * 
 */
class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] map = new int[N][N];
        for (int[] cod : mines)
            map[cod[0]][cod[1]] = 1;
        int[] u, d, l, r;
        u = new int[N];
        d = new int[N];
        l = new int[N];
        r = new int[N];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1)
                    u[j] = d[j] = l[j] = 0;
                else {
                    if (j > 0)
                        l[j] = l[j-1]+1;
                    else
                        l[j] = 1;
                    u[j]++;
                    if (d[j] > 0)
                        d[j]--;
                    else {
                        for (int k = i; k < N && map[k][j] == 0; k++)
                            d[j]++;
                    }
                }
            }
            for (int j = N-1; j >= 0; j--)
                if (map[i][j] == 1)
                    r[j] = 0;
                else {
                    if (j == N-1)
                        r[j] = 1;
                    else
                        r[j] = r[j+1]+1;
                    int val = Math.min(Math.min(u[j], d[j]), Math.min(l[j], r[j]));
                    ans = Math.max(ans, val);
                }
        }
        return ans;
    }
}
