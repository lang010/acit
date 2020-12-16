/*
 * @lc app=leetcode id=397 lang=java
 *
 * [397] Integer Replacement
 *
 * https://leetcode.com/problems/integer-replacement/description/
 *
 * algorithms
 * Medium (33.30%)
 * Total Accepted:    60.6K
 * Total Submissions: 181.9K
 * Testcase Example:  '8'
 *
 * Given a positive integer n, you can apply one of the following
 * operations:
 * 
 * 
 * If n is even, replace n with n / 2.
 * If n is odd, replace n with either n + 1 or n - 1.
 * 
 * 
 * Return the minimum number of operations needed for n to become 1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 8
 * Output: 3
 * Explanation: 8 -> 4 -> 2 -> 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 7
 * Output: 4
 * Explanation: 7 -> 8 -> 4 -> 2 -> 1
 * or 7 -> 6 -> 3 -> 2 -> 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 4
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 2^31 - 1
 * 
 * 
 */
class Solution {
    public int integerReplacement(int n) {
        if (Integer.MAX_VALUE == n)
            return 32;
        int ans = 0;
        while (n != 1) {
            if ((n&1) == 0)
                n /= 2;
            else if (n == 3 || Integer.bitCount(n-1) < Integer.bitCount(n+1)) {
                n--;
            } else
                n++;
            ans++;
        }
        return ans;
    }
}
