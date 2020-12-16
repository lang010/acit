/*
 * @lc app=leetcode id=1507 lang=java
 *
 * [1507] Reformat Date
 *
 * https://leetcode.com/problems/reformat-date/description/
 *
 * algorithms
 * Easy (60.31%)
 * Total Accepted:    15.5K
 * Total Submissions: 25.7K
 * Testcase Example:  '"20th Oct 2052"'
 *
 * Given a date string in the form Day Month Year, where:
 * 
 * 
 * Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
 * Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
 * "Sep", "Oct", "Nov", "Dec"}.
 * Year is in the range [1900, 2100].
 * 
 * 
 * Convert the date string to the format YYYY-MM-DD, where:
 * 
 * 
 * YYYY denotes the 4 digit year.
 * MM denotes the 2 digit month.
 * DD denotes the 2 digit day.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: date = "20th Oct 2052"
 * Output: "2052-10-20"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: date = "6th Jun 1933"
 * Output: "1933-06-06"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: date = "26th May 1960"
 * Output: "1960-05-26"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The given dates are guaranteed to be valid, so no error handling is
 * necessary.
 * 
 * 
 */
class Solution {
    public String reformatDate(String date) {
        String[] m = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] ls = date.split(" ");
        String ans = ls[2];
        for (int i = 0; i < m.length; i++) {
            if (m[i].equals(ls[1])) {
                i++;
                if (i < 10)
                    ans = ans + "-0" + i;
                else
                    ans = ans + "-" + i;
                break;
            }
        }
        if (ls[0].length() < 4)
            return ans + "-0" + ls[0].charAt(0);
        else
            return ans + "-" + ls[0].substring(0, 2);
    }
}
