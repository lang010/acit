/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 *
 * https://leetcode.com/problems/add-digits/description/
 *
 * algorithms
 * Easy (58.20%)
 * Total Accepted:    333.2K
 * Total Submissions: 572.5K
 * Testcase Example:  '38'
 *
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 * 
 * Example:
 * 
 * 
 * Input: 38
 * Output: 2 
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
 * Since 2 has only one digit, return it.
 * 
 * 
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
class Solution {
    public int addDigits(int n) {
        while (n > 9) {
            int t = 0;
            while (n > 0) {
                t += n%10;
                n /= 10;
            }
            n = t;
        }
        return n;
    }
}
