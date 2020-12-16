/*
 * @lc app=leetcode id=759 lang=java
 *
 * [759] Employee Free Time
 *
 * https://leetcode.com/problems/employee-free-time/description/
 *
 * algorithms
 * Hard (67.53%)
 * Total Accepted:    51.3K
 * Total Submissions: 76K
 * Testcase Example:  '[[[1,2],[5,6]],[[1,3]],[[4,10]]]'
 *
 * We are given a list schedule of employees, which represents the working time
 * for each employee.
 * 
 * Each employee has a list of non-overlapping Intervals, and these intervals
 * are in sorted order.
 * 
 * Return the list of finite intervals representing common, positive-length
 * free time for all employees, also in sorted order.
 * 
 * (Even though we are representing Intervals in the form [x, y], the objects
 * inside are Intervals, not lists or arrays. For example, schedule[0][0].start
 * = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).  Also,
 * we wouldn't include intervals like [5, 5] in our answer, as they have zero
 * length.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * Output: [[3,4]]
 * Explanation: There are a total of three employees, and all common
 * free time intervals would be [-inf, 1], [3, 4], [10, inf].
 * We discard any intervals that contain inf as they aren't finite.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
 * Output: [[5,6],[7,9]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= schedule.length , schedule[i].length <= 50
 * 0 <= schedule[i].start < schedule[i].end <= 10^8
 * 
 * 
 */
/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Interval> ls : schedule)
            for (Interval it : ls) {
                map.put(it.start, map.getOrDefault(it.start, 0) + 1);
                map.put(it.end, map.getOrDefault(it.end, 0) - 1);
            }
        int[][] arr = new int[map.size()][2];
        int t = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr[t][0] = entry.getKey();
            arr[t++][1] = entry.getValue();
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int pre = -1;
        int cur = 0;
        List<Interval> ans = new ArrayList<>();
        for (int[] it : arr)
            if (it[1] != 0) {
                if (cur == 0 && pre >= 0)
                    ans.add(new Interval(pre, it[0]));
                cur += it[1];
                if (cur == 0)
                    pre = it[0];
            }
        return ans;
    }
}
