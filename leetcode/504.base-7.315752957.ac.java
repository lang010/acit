/*
 * @lc app=leetcode id=504 lang=java
 *
 * [504] Base 7
 *
 * https://leetcode.com/problems/base-7/description/
 *
 * algorithms
 * Easy (46.40%)
 * Total Accepted:    60.1K
 * Total Submissions: 129.5K
 * Testcase Example:  '100'
 *
 * Given an integer, return its base 7 string representation.
 * 
 * Example 1:
 * 
 * Input: 100
 * Output: "202"
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: -7
 * Output: "-10"
 * 
 * 
 * 
 * Note:
 * The input will be in range of [-1e7, 1e7].
 * 
 */
class Solution {
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        boolean negative = num < 0;
        if (negative)
            num = -num;
        while (num > 0) {
            sb.append(num%7);
            num /= 7;
        }
        if (negative)
            sb.append("-");
        return sb.reverse().toString();
    }
}
