/*
 * @lc app=leetcode id=436 lang=java
 *
 * [436] Find Right Interval
 *
 * https://leetcode.com/problems/find-right-interval/description/
 *
 * algorithms
 * Medium (48.29%)
 * Total Accepted:    59.5K
 * Total Submissions: 123.3K
 * Testcase Example:  '[[1,2]]'
 *
 * You are given an array of intervals, where intervals[i] = [starti, endi] and
 * each starti is unique.
 * 
 * The right interval for an interval i is an interval j such that startj >=
 * endi and startj is minimized.
 * 
 * Return an array of right interval indices for each interval i. If no right
 * interval exists for interval i, then put -1 at index i.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: intervals = [[1,2]]
 * Output: [-1]
 * Explanation: There is only one interval in the collection, so it outputs
 * -1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: intervals = [[3,4],[2,3],[1,2]]
 * Output: [-1,0,1]
 * Explanation: There is no right interval for [3,4].
 * The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start
 * that is >= end1 = 3.
 * The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start
 * that is >= end2 = 2.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: intervals = [[1,4],[2,3],[3,4]]
 * Output: [-1,2,-1]
 * Explanation: There is no right interval for [1,4] and [3,4].
 * The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start
 * that is >= end1 = 3.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= intervals.length <= 2 * 10^4
 * intervals[i].length == 2
 * -10^6 <= starti <= endi <= 10^6
 * The start point of each interval is unique.
 * 
 * 
 */
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++)
            map.put(intervals[i][0], i);
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> id = map.ceilingEntry(intervals[i][1]);
            if (id == null)
                ans[i] = -1;
            else
                ans[i] = id.getValue();
        }
        return ans;
    }
}
