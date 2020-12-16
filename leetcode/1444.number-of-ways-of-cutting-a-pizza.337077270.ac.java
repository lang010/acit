/*
 * @lc app=leetcode id=1444 lang=java
 *
 * [1444] Number of Ways of Cutting a Pizza
 *
 * https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/description/
 *
 * algorithms
 * Hard (53.49%)
 * Total Accepted:    7.5K
 * Total Submissions: 14K
 * Testcase Example:  '["A..","AAA","..."]\n3'
 *
 * Given a rectangular pizza represented as a rows x cols matrix containing the
 * following characters: 'A' (an apple) and '.' (empty cell) and given the
 * integer k. You have to cut the pizza into k pieces using k-1 cuts. 
 * 
 * For each cut you choose the direction: vertical or horizontal, then you
 * choose a cut position at the cell boundary and cut the pizza into two
 * pieces. If you cut the pizza vertically, give the left part of the pizza to
 * a person. If you cut the pizza horizontally, give the upper part of the
 * pizza to a person. Give the last piece of pizza to the last person.
 * 
 * Return the number of ways of cutting the pizza such that each piece contains
 * at least one apple. Since the answer can be a huge number, return this
 * modulo 10^9 + 7.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: pizza = ["A..","AAA","..."], k = 3
 * Output: 3 
 * Explanation: The figure above shows the three ways to cut the pizza. Note
 * that pieces must contain at least one apple.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: pizza = ["A..","AA.","..."], k = 3
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: pizza = ["A..","A..","..."], k = 1
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= rows, cols <= 50
 * rows == pizza.length
 * cols == pizza[i].length
 * 1 <= k <= 10
 * pizza consists of characters 'A' and '.' only.
 * 
 */
class Solution {
    int n;
    int m;
    long[][] dp;
    int[][] bufx;
    int[][] bufy;
    String[] pz;
    
    public int ways(String[] pizza, int k) {
        pz = pizza;
        n = pizza.length;
        m = pizza[0].length();
        dp = new long[n][m];
        bufx = new int[n][m];
        bufy = new int[n][m];
        
        for (int i = n-1; i >= 0; i--)
            for (int j = m-1; j >= 0; j--) {
                if (pizza[i].charAt(j) == 'A') {
                    dp[i][j] = 1;
                    continue;
                }
                if (i+1 < n && dp[i+1][j] > 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (j+1 < m && dp[i][j+1] > 0)
                    dp[i][j] = 1;
            }
        if (k == 1)
            return (int) dp[0][0];
        
        for (int t = 2; t < k; t++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    cnt(i, j);
        cnt(0, 0);
        return (int) dp[0][0];
    }
    
    void cnt(int x, int y) {
        long[][] dd = dp;
        dp[x][y] = 0;
        for (int i = bufX(x, y); i < n; i++)
            dp[x][y] += dp[i][y];
        for (int j = bufY(x, y); j < m; j++)
            dp[x][y] += dp[x][j];
        dp[x][y] %= 1000000007l;
    }
    
    int bufX(int x, int y) {
        if (bufx[x][y] > 0)
            return bufx[x][y];
        for (int i = x; i < n; i++)
            for (int j = y; j < m; j++)
                if (pz[i].charAt(j) == 'A') {
                    bufx[x][y] = i+1;
                    return i+1;
                }
        bufx[x][y] = n;
        return n;
    }
    
    int bufY(int x, int y) {
        if (bufy[x][y] > 0)
            return bufy[x][y];
        for (int j = y; j < m; j++)
            for (int i = x; i < n; i++)
                if (pz[i].charAt(j) == 'A') {
                    bufy[x][y] = j+1;
                    return j+1;
                }
        bufy[x][y] = m;
        return m;
    }
}
