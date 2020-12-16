/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (30.71%)
 * Total Accepted:    565.5K
 * Total Submissions: 1.8M
 * Testcase Example:  '2.00000\n10'
 *
 * Implement pow(x, n), which calculates x raised to the power n (i.e. x^n).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * -10^4 <= x^n <= 10^4
 * 
 * 
 */
class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long p = n;
        if (p < 0) {
            x = 1/x;
            p = -p;
        }
        double cur = x;
        for (long i = p; i > 0; i /= 2) {
            if (i%2 == 1)
                ans *= cur;
            cur = cur * cur;
        }
        
        return ans;
    }
}
