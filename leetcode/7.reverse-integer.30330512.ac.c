/*
 * @lc app=leetcode id=7 lang=c
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (25.83%)
 * Total Accepted:    1.3M
 * Total Submissions: 5.1M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Note:
 * Assume we are dealing with an environment that could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 0 when the reversed
 * integer overflows.
 * 
 * 
 * Example 1:
 * Input: x = 123
 * Output: 321
 * Example 2:
 * Input: x = -123
 * Output: -321
 * Example 3:
 * Input: x = 120
 * Output: 21
 * Example 4:
 * Input: x = 0
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 
 * -2^31 <= x <= 2^31 - 1
 * 
 * 
 */
int reverse(int x) {
  int t	= x > 0	? 1 : -1;
  if (x < 0)
    x =	-x;
  int r	= 0;
  while	(x > 0) {
    if (r*10/10 != r)
      return 0;
    r *= 10;
    r += x%10;
    x /= 10;
  }

  return r * t;
}
