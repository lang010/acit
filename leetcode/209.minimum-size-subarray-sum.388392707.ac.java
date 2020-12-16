/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * algorithms
 * Medium (38.98%)
 * Total Accepted:    315.2K
 * Total Submissions: 808.6K
 * Testcase Example:  '7\n[2,3,1,2,4,3]'
 *
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * Example: 
 * 
 * 
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem
 * constraint.
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution of
 * which the time complexity is O(n log n). 
 * 
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int sum = 0;
        int n = nums.length;
        int min = n+1;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min(min, i-l+1);
                sum -= nums[l++];
            }
        }
        return min == n+1 ? 0 : min;
    }
}
