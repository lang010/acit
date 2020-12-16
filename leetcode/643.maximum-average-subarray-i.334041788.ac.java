/*
 * @lc app=leetcode id=643 lang=java
 *
 * [643] Maximum Average Subarray I
 *
 * https://leetcode.com/problems/maximum-average-subarray-i/description/
 *
 * algorithms
 * Easy (41.89%)
 * Total Accepted:    89.3K
 * Total Submissions: 213.1K
 * Testcase Example:  '[1,12,-5,-6,50,3]\n4'
 *
 * Given an array consisting of n integers, find the contiguous subarray of
 * given length k that has the maximum average value. And you need to output
 * the maximum average value.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 * 
 * 
 * 
 * 
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        for (int i = 1; i < n; i++)
            nums[i] += nums[i-1];
        int sum = nums[k-1];
        for (int i = 0; i+k < n; i++)
            sum = Math.max(sum, nums[i+k]-nums[i]);
        return sum*1.0/k;
    }
}
