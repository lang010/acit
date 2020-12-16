/*
 * @lc app=leetcode id=1344 lang=java
 *
 * [1344] Angle Between Hands of a Clock
 *
 * https://leetcode.com/problems/angle-between-hands-of-a-clock/description/
 *
 * algorithms
 * Medium (61.26%)
 * Total Accepted:    47.7K
 * Total Submissions: 77.9K
 * Testcase Example:  '12\n30'
 *
 * Given two numbers, hour and minutes. Return the smaller angle (in degrees)
 * formed between the hour and the minute hand.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: hour = 12, minutes = 30
 * Output: 165
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: hour = 3, minutes = 30
 * Output: 75
 * 
 * 
 * Example 3:
 * 
 * 
 * 
 * 
 * Input: hour = 3, minutes = 15
 * Output: 7.5
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: hour = 4, minutes = 50
 * Output: 155
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: hour = 12, minutes = 0
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= hour <= 12
 * 0 <= minutes <= 59
 * Answers within 10^-5 of the actual value will be accepted as correct.
 * 
 * 
 */
class Solution {
    public double angleClock(int hour, int minutes) {
        double val = Math.abs(30.0 * hour + 0.5 * minutes - 6 * minutes);
        return Math.min(val, 360-val);
    }
}
