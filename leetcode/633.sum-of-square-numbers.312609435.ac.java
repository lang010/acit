/*
 * @lc app=leetcode id=633 lang=java
 *
 * [633] Sum of Square Numbers
 *
 * https://leetcode.com/problems/sum-of-square-numbers/description/
 *
 * algorithms
 * Medium (32.33%)
 * Total Accepted:    76.9K
 * Total Submissions: 237.7K
 * Testcase Example:  '5'
 *
 * Given a non-negative integer c, decide whether there're two integers a and b
 * such that a^2 + b^2 = c.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: c = 3
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: c = 4
 * Output: true
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: c = 2
 * Output: true
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: c = 1
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= c <= 2^31 - 1
 * 
 * 
 */
class Solution {
    public boolean judgeSquareSum(int c) {
        if (c == 0)
            return true;
        int n = (int) Math.sqrt(c);
        for (int i = 1; i <= n; i++) {
            if (check(c - i * i))
                return true;
        }
        return false;
    }
    
    boolean check(int x) {
        int t = (int) Math.sqrt(x);
        return t * t == x;
    }
}
