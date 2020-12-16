/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (16.57%)
 * Total Accepted:    319.5K
 * Total Submissions: 1.9M
 * Testcase Example:  '10\n3'
 *
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division, and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero, which means losing its
 * fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) =
 * -2.
 * 
 * Note:
 * 
 * 
 * Assume we are dealing with an environment that could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For this
 * problem, assume that your function returns 2^31 − 1 when the division result
 * overflows.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: dividend = 0, divisor = 1
 * Output: 0
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: dividend = 1, divisor = 1
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * -2^31 <= dividend, divisor <= 2^31 - 1
 * divisor != 0
 * 
 * 
 */
class Solution {
    public int divide(int dividend, int divisor) {
        int ans = 0;
        int len = 30;
        long l = dividend, r = divisor;
        int neg = 1;
        if (l < 0 && r > 0 || l > 0 && r < 0) {
            neg = -1;
            len = 31;
        }
        l = l < 0 ? -l : l;
        r = r < 0 ? -r : r;
        while (l >= r && len >= 0) {
            long t = r << len;
            if (l >= t) {
                l -= t;
                ans += 1 << len;
            }
            len--;
        }
        
        return neg == 1 ? ans : -ans;
    }
}
