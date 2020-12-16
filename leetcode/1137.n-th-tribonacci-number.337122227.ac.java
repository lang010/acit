/*
 * @lc app=leetcode id=1137 lang=java
 *
 * [1137] N-th Tribonacci Number
 *
 * https://leetcode.com/problems/n-th-tribonacci-number/description/
 *
 * algorithms
 * Easy (56.14%)
 * Total Accepted:    59.8K
 * Total Submissions: 106.5K
 * Testcase Example:  '4'
 *
 * The Tribonacci sequence Tn is defined as follows: 
 * 
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * 
 * Given n, return the value of Tn.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 25
 * Output: 1389537
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= n <= 37
 * The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31
 * - 1.
 * 
 */
class Solution {
    public int tribonacci(int n) {
        if (n < 2)
            return n;
        if (n < 4)
            return n-1;
        int t0 = 1, t1 = 1, t2 = 2;
        for (int i = 4; i <= n; i++) {
            int t = t0+t1+t2;
            t0 = t1;
            t1 = t2;
            t2 = t;
        }
        return t2;
    }
}
