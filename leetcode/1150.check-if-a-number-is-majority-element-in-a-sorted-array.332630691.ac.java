/*
 * @lc app=leetcode id=1150 lang=java
 *
 * [1150] Check If a Number Is Majority Element in a Sorted Array
 *
 * https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/description/
 *
 * algorithms
 * Easy (58.05%)
 * Total Accepted:    16.5K
 * Total Submissions: 28.4K
 * Testcase Example:  '[2,4,5,5,5,5,5,6,6]\n5'
 *
 * Given an array nums sorted in non-decreasing order, and a number target,
 * return True if and only if target is a majority element.
 * 
 * A majority element is an element that appears more than N/2 times in an
 * array of length N.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,4,5,5,5,5,5,6,6], target = 5
 * Output: true
 * Explanation: 
 * The value 5 appears 5 times and the length of the array is 9.
 * Thus, 5 is a majority element because 5 > 9/2 is true.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [10,100,101,101], target = 101
 * Output: false
 * Explanation: 
 * The value 101 appears 2 times and the length of the array is 4.
 * Thus, 101 is not a majority element because 2 > 4/2 is false.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10^9
 * 1 <= target <= 10^9
 * 
 * 
 */
class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        if (nums[(n-1)/2] != target)
            return false;
        int l = left(nums, 0, n-1, target);
        return nums[l+n/2] == target;
    }
    
    int left(int[] nums, int l, int r, int tar) {
        while (l < r) {
            int m = l + (r-l)/2;
            if (nums[m] == tar)
                r = m;
            else
                l = m+1;
        }
        return l;
    }
}
