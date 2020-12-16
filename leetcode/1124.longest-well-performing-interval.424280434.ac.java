/*
 * @lc app=leetcode id=1124 lang=java
 *
 * [1124] Longest Well-Performing Interval
 *
 * https://leetcode.com/problems/longest-well-performing-interval/description/
 *
 * algorithms
 * Medium (33.04%)
 * Total Accepted:    13.7K
 * Total Submissions: 41.4K
 * Testcase Example:  '[9,9,6,0,6,6,9]'
 *
 * We are given hours, a list of the number of hours worked per day for a given
 * employee.
 * 
 * A day is considered to be a tiring day if and only if the number of hours
 * worked is (strictly) greater than 8.
 * 
 * A well-performing interval is an interval of days for which the number of
 * tiring days is strictly larger than the number of non-tiring days.
 * 
 * Return the length of the longest well-performing interval.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: hours = [9,9,6,0,6,6,9]
 * Output: 3
 * Explanation: The longest well-performing interval is [9,9,6].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= hours.length <= 10000
 * 0 <= hours[i] <= 16
 * 
 * 
 */
class Solution {
    public int longestWPI(int[] hours) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0)
                ans = i+1;
            else {
                if (!map.containsKey(sum))
                    map.put(sum, i);
                if (map.containsKey(sum - 1))
                    ans = Math.max(ans, i - map.get(sum-1));
            }
        }
        return ans;
    }
}
