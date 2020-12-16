/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Medium (33.41%)
 * Total Accepted:    280.8K
 * Total Submissions: 840.6K
 * Testcase Example:  '[2,5,6,0,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return true,
 * otherwise return false.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * 
 * Follow up:
 * 
 * 
 * This is a follow up problem to Search in Rotated Sorted Array, where nums
 * may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 * 
 * 
 */
class Solution {
    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }
    
    boolean search(int[] nums, int l, int r, int target) {
        if (l > r)
            return false;
        if (nums[l] == target || nums[r] == target)
            return true;
        if (nums[l] == nums[r])
            return search(nums, l+1, r-1, target);
        int m = l+(r-l)/2;
        if (nums[m] == target)
            return true;
        if (nums[l] < nums[m]) {
            if (nums[m] > target && nums[l] < target)
                return binSearch(nums, l+1, m-1, target);
            else
                return search(nums, m+1, r-1, target);
        } else if (nums[m] < nums[r]) {
            if (nums[m] < target && nums[r] > target)
                return binSearch(nums, m+1, r-1, target);
            return search(nums, l+1, m-1, target);
        } else {
            return search(nums, l+1, m-1, target) || search(nums, m+1, r-1, target);
        }
    }
    
    boolean binSearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int m = l+(r-l)/2;
            if (nums[m] == target)
                return true;
            if (nums[m] < target)
                l = m+1;
            else
                r = m-1;
        }
        return false;
    }
}
