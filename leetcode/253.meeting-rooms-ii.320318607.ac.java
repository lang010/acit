/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 *
 * https://leetcode.com/problems/meeting-rooms-ii/description/
 *
 * algorithms
 * Medium (46.42%)
 * Total Accepted:    359.6K
 * Total Submissions: 774.5K
 * Testcase Example:  '[[0,30],[5,10],[15,20]]'
 *
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * Example 1:
 * 
 * 
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * 
 * Example 2:
 * 
 * 
 * Input: [[7,10],[2,4]]
 * Output: 1
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length < 1)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> ans = new PriorityQueue<>();
        ans.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int end = intervals[i][1];
            if (intervals[i][0] >= ans.peek()) {
                ans.poll();
            }
            ans.offer(end);
        }
        return ans.size();
    }
}
