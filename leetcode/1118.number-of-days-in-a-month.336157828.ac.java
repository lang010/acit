/*
 * @lc app=leetcode id=1118 lang=java
 *
 * [1118] Number of Days in a Month
 *
 * https://leetcode.com/problems/number-of-days-in-a-month/description/
 *
 * algorithms
 * Easy (57.34%)
 * Total Accepted:    4.7K
 * Total Submissions: 8.1K
 * Testcase Example:  '1992\n7'
 *
 * Given a year Y and a month M, return how many days there are in that
 * month.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: Y = 1992, M = 7
 * Output: 31
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: Y = 2000, M = 2
 * Output: 29
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: Y = 1900, M = 2
 * Output: 28
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1583 <= Y <= 2100
 * 1 <= M <= 12
 * 
 * 
 */
class Solution {
    public int numberOfDays(int Y, int M) {
        if (M == 2) {
            if (Y%4 != 0)
                return 28;
            if (Y%100 == 0 && Y%400 != 0)
                return 28;
            return 29;
        }
        if (M%2 == 1 && M < 8 || M > 7 && M%2 == 0)
            return 31;
        return 30;
    }
}
