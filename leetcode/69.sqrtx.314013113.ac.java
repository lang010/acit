/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 *
 * https://leetcode.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (34.64%)
 * Total Accepted:    640.3K
 * Total Submissions: 1.8M
 * Testcase Example:  '4'
 *
 * Given a non-negative integer x, compute and return the square root of x.
 * 
 * Since the return type is an integer, the decimal digits are truncated, and
 * only the integer part of the result is returned.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: x = 4
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part
 * is truncated, 2 is returned.
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= x <= 2^31 - 1
 * 
 * 
 */
class Solution {
    public int mySqrt(int x) {
        if (x < 2)
            return x;
        int l = 1;
        int r = x;
        while (l <= r) {
            int m = l + (r-l)/2;
            int sqrt = x/m;
            if (m == sqrt)
                return m;
            if (m < sqrt) {
                l = m + 1;
            } else
                r = m - 1;
        }
        return l-1;
    }
}
