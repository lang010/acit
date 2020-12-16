/*
 * @lc app=leetcode id=790 lang=java
 *
 * [790] Domino and Tromino Tiling
 *
 * https://leetcode.com/problems/domino-and-tromino-tiling/description/
 *
 * algorithms
 * Medium (39.71%)
 * Total Accepted:    17K
 * Total Submissions: 42.9K
 * Testcase Example:  '3'
 *
 * We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape.
 * These shapes may be rotated.
 * 
 * 
 * XX  <- domino
 * 
 * XX  <- "L" tromino
 * X
 * 
 * 
 * Given N, how many ways are there to tile a 2 x N board? Return your answer
 * modulo 10^9 + 7.
 * 
 * (In a tiling, every square must be covered by a tile. Two tilings are
 * different if and only if there are two 4-directionally adjacent cells on the
 * board such that exactly one of the tilings has both squares occupied by a
 * tile.)
 * 
 * 
 * 
 * Example:
 * Input: 3
 * Output: 5
 * Explanation: 
 * The five different ways are listed below, different letters indicates
 * different tiles:
 * XYZ XXZ XYY XXY XYY
 * XYZ YYZ XZZ XYY XXY
 * 
 * Note:
 * 
 * 
 * N  will be in range [1, 1000].
 * 
 * 
 * 
 * 
 */
class Solution {
    public int numTilings(int N) {
        long[] dp = new long[N+1];
        long mod = 1000000007;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % mod;
            for (int j = i-3; j >= 0; j -= 2)
                dp[i] = (dp[i] + dp[j] * 2) % mod;
            for (int j = i-4; j >= 0; j -= 2)
                dp[i] = (dp[i] + dp[j] * 2) % mod;
        }
        return (int) dp[N];
    }
}
