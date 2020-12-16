/*
 * @lc app=leetcode id=1201 lang=java
 *
 * [1201] Ugly Number III
 *
 * https://leetcode.com/problems/ugly-number-iii/description/
 *
 * algorithms
 * Medium (26.32%)
 * Total Accepted:    11.7K
 * Total Submissions: 44.5K
 * Testcase Example:  '3\n2\n3\n5'
 *
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive integers which are divisible by a or b or c.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3, a = 2, b = 3, c = 5
 * Output: 4
 * Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
 * 
 * Example 2:
 * 
 * 
 * Input: n = 4, a = 2, b = 3, c = 4
 * Output: 6
 * Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is
 * 6.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 5, a = 2, b = 11, c = 13
 * Output: 10
 * Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is
 * 10.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: n = 1000000000, a = 2, b = 217983653, c = 336916467
 * Output: 1999999984
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n, a, b, c <= 10^9
 * 1 <= a * b * c <= 10^18
 * It's guaranteed that the result will be in range [1, 2 * 10^9]
 * 
 * 
 */
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int l = 1, r = Math.min(n*a, 2000000000);
        long ab = gcd(a, b), ac = gcd(a, c), bc = gcd(b, c), abc = gcd(a, bc);
        while (l < r) {
            int m = l + (r-l)/2;
            long t = m/a + m/b + m/c - m/ab - m/ac - m/bc + m/abc;
            if (t < n)
                l = m+1;
            else
                r = m;
        }
        return (int) l;
    }
    
    long gcd(long x, long y) {
        long a = x, b = y;
        while (a%b != 0) {
            long t = a;
            a = b;
            b = t%b;
        }
        return x*y/b;
    }
}
