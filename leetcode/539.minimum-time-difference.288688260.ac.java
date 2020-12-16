/*
 * @lc app=leetcode id=539 lang=java
 *
 * [539] Minimum Time Difference
 *
 * https://leetcode.com/problems/minimum-time-difference/description/
 *
 * algorithms
 * Medium (51.98%)
 * Total Accepted:    56.4K
 * Total Submissions: 108.5K
 * Testcase Example:  '["23:59","00:00"]'
 *
 * Given a list of 24-hour clock time points in "HH:MM" format, return the
 * minimum minutes difference between any two time-points in the list.
 * 
 * Example 1:
 * Input: timePoints = ["23:59","00:00"]
 * Output: 1
 * Example 2:
 * Input: timePoints = ["00:00","23:59","00:00"]
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= timePoints <= 2 * 10^4
 * timePoints[i] is in the format "HH:MM".
 * 
 * 
 */
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] minutes = new int[n];
        for (int i = 0; i < n; i++) {
            minutes[i] = convert(timePoints.get(i));
        }
        Arrays.sort(minutes);
        int min = diff(minutes[n-1], minutes[0] + 24 * 60);
        for (int i = 0; i < n-1; i++) {
            int d = diff(minutes[i], minutes[i+1]);
            if (min > d) {
                min = d;
            }
        }
        
        return min;
    }
    
    int diff(int a, int b) {
        return b - a;
    }
    
    int convert(String time) {
        String[] ls = time.split(":");
        return Integer.valueOf(ls[0]) * 60 + Integer.valueOf(ls[1]);
    }
}
