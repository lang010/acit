/*
 * @lc app=leetcode id=1017 lang=java
 *
 * [1017] Convert to Base -2
 *
 * https://leetcode.com/problems/convert-to-base-2/description/
 *
 * algorithms
 * Medium (59.51%)
 * Total Accepted:    12.9K
 * Total Submissions: 21.7K
 * Testcase Example:  '2'
 *
 * Given a number N, return a string consisting of "0"s and "1"s that
 * represents its value in base -2 (negative two).
 * 
 * The returned string must have no leading zeroes, unless the string is
 * "0".
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: "110"
 * Explantion: (-2) ^ 2 + (-2) ^ 1 = 2
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 3
 * Output: "111"
 * Explantion: (-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 4
 * Output: "100"
 * Explantion: (-2) ^ 2 = 4
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 0 <= N <= 10^9
 * 
 * 
 * 
 * 
 */
class Solution {
    public String baseNeg2(int N) {
        if (N == 0)
            return "0";
        long x = 0, y = 0;
        long n = N;
        int i = 0;
        while (n >= (1l << i)) {
            if (i%2 == 0)
                x |= n & (1l << i);
            else {
                if ((n & (1l<<i)) > 0) {
                    n += 1l<<i;
                    y |= 1l<<i;
                }
            }
            i++;
        }
        return Long.toString(x+y, 2);
    }
}
