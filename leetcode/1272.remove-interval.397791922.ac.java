/*
 * @lc app=leetcode id=1272 lang=java
 *
 * [1272] Remove Interval
 *
 * https://leetcode.com/problems/remove-interval/description/
 *
 * algorithms
 * Medium (57.62%)
 * Total Accepted:    11.4K
 * Total Submissions: 19.8K
 * Testcase Example:  '[[0,2],[3,4],[5,7]]\n[1,6]'
 *
 * Given a sorted list of disjoint intervals, each interval intervals[i] = [a,
 * b] represents the set of real numbers x such that a <= x < b.
 * 
 * We remove the intersections between any interval in intervals and the
 * interval toBeRemoved.
 * 
 * Return a sorted list of intervals after all such removals.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: intervals = [[0,2],[3,4],[5,7]], toBeRemoved = [1,6]
 * Output: [[0,1],[6,7]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: intervals = [[0,5]], toBeRemoved = [2,3]
 * Output: [[0,2],[3,5]]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: intervals = [[-5,-4],[-3,-2],[1,2],[3,5],[8,9]], toBeRemoved = [-1,4]
 * Output: [[-5,-4],[-3,-2],[4,5],[8,9]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= intervals.length <= 10^4
 * -10^9 <= intervals[i][0] < intervals[i][1] <= 10^9
 * 
 * 
 */
class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] cur : intervals) {
            if (cur[0] >= toBeRemoved[0] && cur[1] <= toBeRemoved[1])
                continue;
            if (cur[0] < toBeRemoved[0] && cur[1] > toBeRemoved[1]) {
                ans.add(Arrays.asList(cur[0], toBeRemoved[0]));
                ans.add(Arrays.asList(toBeRemoved[1], cur[1]));
            } else if (cur[0] < toBeRemoved[0])
                ans.add(Arrays.asList(cur[0], Math.min(toBeRemoved[0], cur[1])));
            else
                ans.add(Arrays.asList(Math.max(toBeRemoved[1], cur[0]), cur[1]));
        }
        return ans;
    }
}
