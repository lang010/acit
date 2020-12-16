/*
 * @lc app=leetcode id=665 lang=java
 *
 * [665] Non-decreasing Array
 *
 * https://leetcode.com/problems/non-decreasing-array/description/
 *
 * algorithms
 * Easy (19.59%)
 * Total Accepted:    113.4K
 * Total Submissions: 579.1K
 * Testcase Example:  '[4,2,3]'
 *
 * Given an array nums with n integers, your task is to check if it could
 * become non-decreasing by modifying at most 1 element.
 * 
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for
 * every i (0-based) such that (0 <= i <= n - 2).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing
 * array.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You can't get a non-decreasing array by modify at most one
 * element.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 * 
 * 
 */
class Solution {
    public boolean checkPossibility(int[] nums) {
        int l = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) {
                if (l > 0) {
                    return false;
                }
                l = i;
            }
        }
        if (l > 1 && l < nums.length - 1) {
            if (nums[l-2] <= nums[l] || nums[l-1] <= nums[l+1]) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}
