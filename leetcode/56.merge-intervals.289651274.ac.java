/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (40.38%)
 * Total Accepted:    748.7K
 * Total Submissions: 1.9M
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 * 
 * 
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0]-b[0];
                }
                return a[1] - b[1];
            }
        });
        int pre = 0;
        int len = intervals.length;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[pre][1] >= intervals[i][0]) {
                intervals[pre][1] = Math.max(intervals[pre][1], intervals[i][1]);
                len--;
            } else {
                pre++;
                intervals[pre] = intervals[i];
            }
        }
        int[][] ans = new int[len][2];
        for (int i = 0; i < len; i++) {
            ans[i] = intervals[i];
        }
        return ans;
    }
}
