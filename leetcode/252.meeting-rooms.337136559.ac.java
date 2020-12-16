/*
 * @lc app=leetcode id=252 lang=java
 *
 * [252] Meeting Rooms
 *
 * https://leetcode.com/problems/meeting-rooms/description/
 *
 * algorithms
 * Easy (55.14%)
 * Total Accepted:    164.6K
 * Total Submissions: 298.4K
 * Testcase Example:  '[[0,30],[5,10],[15,20]]'
 *
 * Given an array of meeting time intervals where intervals[i] = [starti,
 * endi], determine if a person could attend all meetings.
 * 
 * 
 * Example 1:
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: false
 * Example 2:
 * Input: intervals = [[7,10],[2,4]]
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti < endi <= 10^6
 * 
 * 
 */
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length-1; i++)
            if (intervals[i][1] > intervals[i+1][0])
                return false;
        return true;
    }
}
