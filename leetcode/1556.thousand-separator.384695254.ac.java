/*
 * @lc app=leetcode id=1556 lang=java
 *
 * [1556] Thousand Separator
 *
 * https://leetcode.com/problems/thousand-separator/description/
 *
 * algorithms
 * Easy (58.58%)
 * Total Accepted:    17K
 * Total Submissions: 29.1K
 * Testcase Example:  '987'
 *
 * Given an integer n, add a dot (".") as the thousands separator and return it
 * in string format.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 987
 * Output: "987"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1234
 * Output: "1.234"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 123456789
 * Output: "123.456.789"
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: n = 0
 * Output: "0"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= n < 2^31
 * 
 * 
 */
class Solution {
    public String thousandSeparator(int n) {
        int a, b, c;
        a = b = c = 0;
        a = n/1000000000;
        n %= 1000000000;
        b = n/1000000;
        n %= 1000000;
        c = n/1000;
        n %= 1000;
        if (a > 0)
            return String.format("%d.%03d.%03d.%03d", a, b, c, n);
        if (b > 0)
            return String.format("%d.%03d.%03d", b, c, n);
        if (c > 0)
            return String.format("%d.%03d", c, n);
        return "" + n;
    }
}
