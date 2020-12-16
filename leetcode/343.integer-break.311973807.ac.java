/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 *
 * https://leetcode.com/problems/integer-break/description/
 *
 * algorithms
 * Medium (50.92%)
 * Total Accepted:    120.1K
 * Total Submissions: 236K
 * Testcase Example:  '2'
 *
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum
 * product you can get.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * 
 * Note: You may assume that n is not less than 2 and not larger than 58.
 * 
 * 
 */
class Solution {
    public int integerBreak(int n) {
        if (n < 3)
            return 1;
        if (n == 3)
            return 2;
        int[] ls = new int[n+1];
        ls[0] = ls[1] = 1;
        ls[2] = 2;
        ls[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                int k = i - j;
                ls[i] = Math.max(ls[i], ls[j] * ls[k]);
            }
        }
        return ls[n];
    }
}
