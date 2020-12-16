/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (47.36%)
 * Total Accepted:    1.2M
 * Total Submissions: 2.6M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1]
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [0]
 * Output: 0
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: nums = [-1]
 * Output: -1
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: nums = [-2147483647]
 * Output: -2147483647
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 
 * 
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int cur = nums[0];
        int max = cur;
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            max = Math.max(cur, max);
        }
        return max;
    }
}
