/*
 * @lc app=leetcode id=861 lang=java
 *
 * [861] Score After Flipping Matrix
 *
 * https://leetcode.com/problems/score-after-flipping-matrix/description/
 *
 * algorithms
 * Medium (73.32%)
 * Total Accepted:    24.1K
 * Total Submissions: 32.9K
 * Testcase Example:  '[[0,0,1,1],[1,0,1,0],[1,1,0,0]]'
 *
 * We have a two dimensional matrix A where each value is 0 or 1.
 * 
 * A move consists of choosing any row or column, and toggling each value in
 * that row or column: changing all 0s to 1s, and all 1s to 0s.
 * 
 * After making any number of moves, every row of this matrix is interpreted as
 * a binary number, and the score of the matrix is the sum of these numbers.
 * 
 * Return the highest possible score.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * Output: 39
 * Explanation:
 * Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] is 0 or 1.
 * 
 * 
 * 
 */
class Solution {
    public int matrixScore(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        for (int i = 0; i < n; i++)
            if (A[i][0] == 0)
                for (int j = 0; j < m; j++)
                    A[i][j] = A[i][j] ^ 1;
        return helper(A);
        /*
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                A[i][j] = A[i][j] ^ 1;
        return Math.max(x, helper(A));
        */
    }
    
    int helper(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++)
                if (A[j][i] == 1)
                    cnt++;
            cnt = Math.max(n-cnt, cnt);
            ans += (1<<(m-1-i)) * cnt;
        }
        return ans;
    }
}
