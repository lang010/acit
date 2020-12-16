/*
 * @lc app=leetcode id=201 lang=java
 *
 * [201] Bitwise AND of Numbers Range
 *
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
 *
 * algorithms
 * Medium (39.56%)
 * Total Accepted:    163.9K
 * Total Submissions: 414.4K
 * Testcase Example:  '5\n7'
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * 
 * Example 1:
 * 
 * 
 * Input: [5,7]
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [0,1]
 * Output: 0
 */
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int x = 1;
        int mask = 0xffffffff;
        while (n-1 >= m) {
            n = n & (n-1);
        }
        return n;
    }
}
