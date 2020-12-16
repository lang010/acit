/*
 * @lc app=leetcode id=1030 lang=java
 *
 * [1030] Matrix Cells in Distance Order
 *
 * https://leetcode.com/problems/matrix-cells-in-distance-order/description/
 *
 * algorithms
 * Easy (66.87%)
 * Total Accepted:    28K
 * Total Submissions: 41.8K
 * Testcase Example:  '1\n2\n0\n0'
 *
 * We are given a matrix with R rows and C columns has cells with integer
 * coordinates (r, c), where 0 <= r < R and 0 <= c < C.
 * 
 * Additionally, we are given a cell in that matrix with coordinates (r0, c0).
 * 
 * Return the coordinates of all cells in the matrix, sorted by their distance
 * from (r0, c0) from smallest distance to largest distance.  Here, the
 * distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance,
 * |r1 - r2| + |c1 - c2|.  (You may return the answer in any order that
 * satisfies this condition.)
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: R = 1, C = 2, r0 = 0, c0 = 0
 * Output: [[0,0],[0,1]]
 * Explanation: The distances from (r0, c0) to other cells are: [0,1]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: R = 2, C = 2, r0 = 0, c0 = 1
 * Output: [[0,1],[0,0],[1,1],[1,0]]
 * Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
 * The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: R = 2, C = 3, r0 = 1, c0 = 2
 * Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
 * There are other answers that would also be accepted as correct, such as
 * [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    int[][] ans;
    int cnt = 0;
    int R = 0;
    int C = 0;
    
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        this.R = R;
        this.C = C;
        cnt = 0;
        ans = new int[R*C][2];
        check(r0, c0);
        for (int d = 1; cnt < ans.length; d++) {
            int r = r0, c = c0;
            for (int i = 1; i < d; i++) {
                int j = d - i;
                check(r+i, c+j);
                check(r-i, c+j);
                check(r+i, c-j);
                check(r-i, c-j);
            }
            check(r, c+d);
            check(r, c-d);
            check(r+d, c);
            check(r-d, c);
        }
        return ans;
    }
    
    void check(int x, int y) {
        if (x >= 0 && x < R && y >= 0 && y < C) {
            ans[cnt][0] = x;
            ans[cnt][1] = y;
            cnt++;
        }
    }
}
