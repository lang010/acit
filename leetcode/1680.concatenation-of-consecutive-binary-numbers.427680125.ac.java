/*
 * @lc app=leetcode id=1680 lang=java
 *
 * [1680] Concatenation of Consecutive Binary Numbers
 *
 * https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/description/
 *
 * algorithms
 * Medium (44.41%)
 * Total Accepted:    7.3K
 * Total Submissions: 16.5K
 * Testcase Example:  '1'
 *
 * Given an integer n, return the decimal value of the binary string formed by
 * concatenating the binary representations of 1 to n in order, modulo 10^9 +
 * 7.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 1
 * Output: 1
 * Explanation: "1" in binary corresponds to the decimal value 1. 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 3
 * Output: 27
 * Explanation: In binary, 1, 2, and 3 corresponds to "1", "10", and "11".
 * After concatenating them, we have "11011", which corresponds to the decimal
 * value 27.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 12
 * Output: 505379714
 * Explanation: The concatenation results in
 * "1101110010111011110001001101010111100".
 * The decimal value of that is 118505380540.
 * After modulo 10^9 + 7, the result is 505379714.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^5
 * 
 * 
 */
class Solution {
    public int concatenatedBinary(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans = ((ans << cnt(i)) + i) % 1000000007l;
        }
        return (int) ans;
    }
    
    int cnt(int x) {
        int ans = 0;
        while (x > 0) {
            ans++;
            x /= 2;
        }
        return ans;
    }
}
