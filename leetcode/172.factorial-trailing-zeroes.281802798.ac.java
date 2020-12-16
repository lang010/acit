/*
 * @lc app=leetcode id=172 lang=java
 *
 * [172] Factorial Trailing Zeroes
 *
 * https://leetcode.com/problems/factorial-trailing-zeroes/description/
 *
 * algorithms
 * Easy (38.22%)
 * Total Accepted:    235.2K
 * Total Submissions: 615.3K
 * Testcase Example:  '3'
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Follow up: Could you write a solution that works in logarithmic time
 * complexity?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 0
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^4
 * 
 * 
 */
class Solution {
    public int trailingZeroes(int n) {
        long sum = 0;
        long x = 5;
        while (n >= x) {
            sum += n/x;
            x = 5 * x;
        }
        return (int)sum;
    }
}
