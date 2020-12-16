/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 *
 * https://leetcode.com/problems/valid-perfect-square/description/
 *
 * algorithms
 * Easy (41.94%)
 * Total Accepted:    247K
 * Total Submissions: 589K
 * Testcase Example:  '16'
 *
 * Given a positive integer num, write a function which returns True if num is
 * a perfect square else False.
 * 
 * Follow up: Do not use any built-in library function such as sqrt.
 * 
 * 
 * Example 1:
 * Input: num = 16
 * Output: true
 * Example 2:
 * Input: num = 14
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= num <= 2^31 - 1
 * 
 * 
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2)
            return true;
        long l = 1;
        long r = num/2;
        long n = num;
        while (l <= r) {
            long m = l + (r-l)/2;
            if (m*m == n)
                return true;
            if (m*m > num)
                r = m-1;
            else
                l = m+1;
        }
        return false;
    }
}
