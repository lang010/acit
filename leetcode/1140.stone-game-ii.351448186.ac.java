/*
 * @lc app=leetcode id=1140 lang=java
 *
 * [1140] Stone Game II
 *
 * https://leetcode.com/problems/stone-game-ii/description/
 *
 * algorithms
 * Medium (64.83%)
 * Total Accepted:    22K
 * Total Submissions: 34K
 * Testcase Example:  '[2,7,9,4,4]'
 *
 * Alice and Bob continue their games with piles of stones.  There are a number
 * of piles arranged in a row, and each pile has a positive integer number of
 * stones piles[i].  The objective of the game is to end with the most
 * stones. 
 * 
 * Alice and Bob take turns, with Alice starting first.  Initially, M = 1.
 * 
 * On each player's turn, that player can take all the stones in the first X
 * remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).
 * 
 * The game continues until all the stones have been taken.
 * 
 * Assuming Alice and Bob play optimally, return the maximum number of stones
 * Alice can get.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: piles = [2,7,9,4,4]
 * Output: 10
 * Explanation:  If Alice takes one pile at the beginning, Bob takes two piles,
 * then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 piles in total.
 * If Alice takes two piles at the beginning, then Bob can take all three piles
 * left. In this case, Alice get 2 + 7 = 9 piles in total. So we return 10
 * since it's larger. 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: piles = [1,2,3,4,5,100]
 * Output: 104
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 10^4
 * 
 * 
 */
class Solution {
    int[][] mem = new int[101][64];
    int[] sum;
    int n;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        for (int[] arr : mem)
            Arrays.fill(arr, -1);
        sum = new int[n];
        sum[n-1] = piles[n-1];
        for (int i = n-2; i >= 0; i--)
            sum[i] = sum[i+1] + piles[i];
        return dfs(0, 1);
    }
    
    int dfs(int i, int m) {
        if (i >= n)
            return 0;
        if (n-i < m*2)
            return sum[i];
        if (mem[i][m] > -1)
            return mem[i][m];
        int min = sum[i];
        for (int d = 1; d <= 2*m; d++)
            min = Math.min(min, dfs(i+d, Math.max(m, d)));
        mem[i][m] = sum[i] - min;
        return mem[i][m];
    }
}
