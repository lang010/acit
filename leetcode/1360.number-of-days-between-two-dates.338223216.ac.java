/*
 * @lc app=leetcode id=1360 lang=java
 *
 * [1360] Number of Days Between Two Dates
 *
 * https://leetcode.com/problems/number-of-days-between-two-dates/description/
 *
 * algorithms
 * Easy (47.17%)
 * Total Accepted:    16.6K
 * Total Submissions: 35.2K
 * Testcase Example:  '"2019-06-29"\n"2019-06-30"'
 *
 * Write a program to count the number of days between two dates.
 * 
 * The two dates are given as strings, their format is YYYY-MM-DD as shown in
 * the examples.
 * 
 * 
 * Example 1:
 * Input: date1 = "2019-06-29", date2 = "2019-06-30"
 * Output: 1
 * Example 2:
 * Input: date1 = "2020-01-15", date2 = "2019-12-31"
 * Output: 15
 * 
 * 
 * Constraints:
 * 
 * 
 * The given dates are valid dates between the years 1971 and 2100.
 * 
 * 
 */
class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(cnt(date1) - cnt(date2));
    }
    
    int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    
    int cnt(String s) {
        int y = Integer.valueOf(s.substring(0, 4));
        int m = Integer.valueOf(s.substring(5, 7));
        int d = Integer.valueOf(s.substring(8, 10));
        y--;
        d += 365 * y;
        for (int i = 1; i < m; i++)
            d += days[i];
        if (m > 2)
            y++;
        d += y/4 - y/100 + y/400;
        return d;
    }
}
