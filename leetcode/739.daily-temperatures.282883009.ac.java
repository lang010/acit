/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 *
 * https://leetcode.com/problems/daily-temperatures/description/
 *
 * algorithms
 * Medium (64.17%)
 * Total Accepted:    200.9K
 * Total Submissions: 313.1K
 * Testcase Example:  '[73,74,75,71,69,72,76,73]'
 *
 * 
 * Given a list of daily temperatures T, return a list such that, for each day
 * in the input, tells you how many days you would have to wait until a warmer
 * temperature.  If there is no future day for which this is possible, put 0
 * instead.
 * 
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76,
 * 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * 
 * Note:
 * The length of temperatures will be in the range [1, 30000].
 * Each temperature will be an integer in the range [30, 100].
 * 
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        res[n-1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int j = i+1;
            while (T[i] >= T[j]) {
                if (res[j] == 0) {
                    break;
                }
                j += res[j];
            }
            if (T[i] < T[j]) {
                res[i] = j-i;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }
}
