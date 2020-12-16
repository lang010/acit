/*
 * @lc app=leetcode id=1563 lang=java
 *
 * [1563] Stone Game V
 *
 * https://leetcode.com/problems/stone-game-v/description/
 *
 * algorithms
 * Hard (40.05%)
 * Total Accepted:    7.2K
 * Total Submissions: 18.1K
 * Testcase Example:  '[6,2,3,4,5,5]'
 *
 * There are several stones arranged in a row, and each stone has an associated
 * value which is an integer given in the array stoneValue.
 * 
 * In each round of the game, Alice divides the row into two non-empty rows
 * (i.e. left row and right row), then Bob calculates the value of each row
 * which is the sum of the values of all the stones in this row. Bob throws
 * away the row which has the maximum value, and Alice's score increases by the
 * value of the remaining row. If the value of the two rows are equal, Bob lets
 * Alice decide which row will be thrown away. The next round starts with the
 * remaining row.
 * 
 * The game ends when there is only one stone remaining. Alice's is initially
 * zero.
 * 
 * Return the maximum score that Alice can obtain.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: stoneValue = [6,2,3,4,5,5]
 * Output: 18
 * Explanation: In the first round, Alice divides the row to [6,2,3], [4,5,5].
 * The left row has the value 11 and the right row has value 14. Bob throws
 * away the right row and Alice's score is now 11.
 * In the second round Alice divides the row to [6], [2,3]. This time Bob
 * throws away the left row and Alice's score becomes 16 (11 + 5).
 * The last round Alice has only one choice to divide the row which is [2],
 * [3]. Bob throws away the right row and Alice's score is now 18 (16 + 2). The
 * game ends because only one stone is remaining in the row.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: stoneValue = [7,7,7,7,7,7,7]
 * Output: 28
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: stoneValue = [4]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= stoneValue.length <= 500
 * 1 <= stoneValue[i] <= 10^6
 * 
 * 
 */
class Solution {
    int[][] mem;
    int[] sum;
    int n;
    public int stoneGameV(int[] stoneValue) {
        n = stoneValue.length;
        mem = new int[n][n];
        sum = new int[n+1];
        for (int i = 0; i < n; i++)
            sum[i+1] += sum[i] + stoneValue[i];
        return helper(stoneValue, 0, n-1);
    }
    
    int helper(int[] st, int l, int r) {
        if (l == r)
            return 0;
        if (r-l == 1)
            return Math.min(st[l], st[r]);
        if (mem[l][r] > 0)
            return mem[l][r];
        int lSum = 0;
        int rSum = sum[r+1] - sum[l];
        int max = 0;
        for (int i = l; i < r; i++) {
            lSum += st[i];
            rSum -= st[i];
            if (lSum < rSum) {
                max = Math.max(max, lSum+helper(st, l, i));
            } else if (lSum > rSum) {
                max = Math.max(max, rSum+helper(st, i+1, r));
            } else {
                max = Math.max(max, Math.max(lSum+helper(st, l, i), rSum+helper(st, i+1, r)));
            }
        }
        return mem[l][r] = max;
    }
}
