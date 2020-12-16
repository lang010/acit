/*
 * @lc app=leetcode id=1010 lang=java
 *
 * [1010] Pairs of Songs With Total Durations Divisible by 60
 *
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/description/
 *
 * algorithms
 * Medium (49.63%)
 * Total Accepted:    70.2K
 * Total Submissions: 141.6K
 * Testcase Example:  '[30,20,150,100,40]'
 *
 * You are given a list of songs where the i^th song has a duration of time[i]
 * seconds.
 * 
 * Return the number of pairs of songs for which their total duration in
 * seconds is divisible by 60. Formally, we want the number of indices i, j
 * such that i < j with (time[i] + time[j]) % 60 == 0.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: time = [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: time = [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is
 * divisible by 60.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= time.length <= 6 * 10^4
 * 1 <= time[i] <= 500
 * 
 * 
 */
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] sec = new int[60];
        for (int x : time)
            sec[x%60]++;
        int ans = sec[0]*(sec[0]-1)/2 + sec[30]*(sec[30]-1)/2;
        for (int i = 1; i < 30; i++)
            ans += sec[i]*sec[60-i];
        return ans;
    }
}
