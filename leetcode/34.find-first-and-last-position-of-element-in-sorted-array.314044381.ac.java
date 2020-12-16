/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (36.88%)
 * Total Accepted:    606.9K
 * Total Submissions: 1.6M
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 * 
 * 
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non-decreasing array.
 * -10^9 <= target <= 10^9
 * 
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[] {-1, -1};
        int l = mostLeft(nums, 0, nums.length-1, target);
        if (nums[l] != target)
            return new int[] { -1, -1 };
        int r = mostRight(nums, l, nums.length-1, target);
        return new int[] {l, r};
    }
    
    int mostLeft(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = l + (r-l)/2;
            if (nums[m] >= target)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
    
    int mostRight(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = l + (r-l+1)/2;
            if (nums[m] <= target)
                l = m;
            else
                r = m - 1;
        }
        return l;
    }
}
