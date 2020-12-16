/*
 * @lc app=leetcode id=507 lang=java
 *
 * [507] Perfect Number
 *
 * https://leetcode.com/problems/perfect-number/description/
 *
 * algorithms
 * Easy (35.87%)
 * Total Accepted:    71.8K
 * Total Submissions: 200.1K
 * Testcase Example:  '28'
 *
 * A perfect number is a positive integer that is equal to the sum of its
 * positive divisors, excluding the number itself. A divisor of an integer x is
 * an integer that can divide x evenly.
 * 
 * Given an integer n, return true if n is a perfect number, otherwise return
 * false.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: num = 28
 * Output: true
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, and 14 are all divisors of 28.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: num = 6
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: num = 496
 * Output: true
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: num = 8128
 * Output: true
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: num = 2
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= num <= 10^8
 * 
 * 
 */
class Solution {
    public boolean checkPerfectNumber(int n) {
        if (n < 5)
            return false;
        int ans = 1;
        int i;
        for (i = 2; i*i < n; i++) {
            if (n%i == 0) {
                ans += i + n/i;
            }
        }
        if (i*i == n)
            ans += n;
        return ans == n;
    }
}
