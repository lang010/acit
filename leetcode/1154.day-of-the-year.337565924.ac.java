/*
 * @lc app=leetcode id=1154 lang=java
 *
 * [1154] Day of the Year
 *
 * https://leetcode.com/problems/day-of-the-year/description/
 *
 * algorithms
 * Easy (49.26%)
 * Total Accepted:    20.4K
 * Total Submissions: 41.4K
 * Testcase Example:  '"2019-01-09"\r'
 *
 * Given a string date representing a Gregorian calendar date formatted as
 * YYYY-MM-DD, return the day number of the year.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: date = "2019-01-09"
 * Output: 9
 * Explanation: Given date is the 9th day of the year in 2019.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: date = "2019-02-10"
 * Output: 41
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: date = "2003-03-01"
 * Output: 60
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: date = "2004-03-01"
 * Output: 61
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * date.length == 10
 * date[4] == date[7] == '-', and all other date[i]'s are digits
 * date represents a calendar date between Jan 1st, 1900 and Dec 31, 2019.
 * 
 */
class Solution {
    int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    public int dayOfYear(String date) {
        int y = Integer.valueOf(date.substring(0, 4));
        int m = Integer.valueOf(date.substring(5, 7));
        int d = Integer.valueOf(date.substring(8, 10));
        int ans = d;
        for (int i = 1; i < m; i++)
            ans += days[i];
        if (m > 2 &&  ((y%4 == 0 && y%100 != 0) || y%400 == 0))
            ans++;
        return ans;
    }
}
