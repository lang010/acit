/*
 * @lc app=leetcode id=1185 lang=java
 *
 * [1185] Day of the Week
 *
 * https://leetcode.com/problems/day-of-the-week/description/
 *
 * algorithms
 * Easy (62.29%)
 * Total Accepted:    27.8K
 * Total Submissions: 44.6K
 * Testcase Example:  '31\n8\n2019'
 *
 * Given a date, return the corresponding day of the week for that date.
 * 
 * The input is given as three integers representing the day, month and year
 * respectively.
 * 
 * Return the answer as one of the following values {"Sunday", "Monday",
 * "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: day = 31, month = 8, year = 2019
 * Output: "Saturday"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: day = 18, month = 7, year = 1999
 * Output: "Sunday"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: day = 15, month = 8, year = 1993
 * Output: "Sunday"
 * 
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
    
    int[] months = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    
    public String dayOfTheWeek(int day, int month, int year) {
        int d = day;
        for (int i = 1; i < month; i++)
            d += months[i];
        d += --year * 365;
        if (month > 2)
            year++;
        d += year/4 - year/100 + year/400;
        return weekDays[d%7];
    }
}
