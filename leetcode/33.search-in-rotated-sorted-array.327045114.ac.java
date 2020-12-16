/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (35.42%)
 * Total Accepted:    865.9K
 * Total Submissions: 2.4M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * You are given an integer array nums sorted in ascending order, and an
 * integer target.
 * 
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e.,
 * [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * If target is found in the array return its index, otherwise, return -1.
 * 
 * 
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * All values of nums are unique.
 * nums is guranteed to be rotated at some pivot.
 * -10^4 <= target <= 10^4
 * 
 * 
 */
class Solution {
    public int search(int[] nums, int target) {
        return rqs(nums, 0, nums.length - 1, target);
    }
    
    int rqs(int[] nums, int l, int r, int x) {
        while(l <= r) {
            int m = (l+r)/2;
            if (x == nums[m])
                return m;
            if (nums[l] < nums[m]) {
                if (l <= m - 1 && x >= nums[l] && x <= nums[m-1])
                    return qs(nums, l, m-1, x);
                l = m + 1;
            } else {
                if (m+1 <= r && x >= nums[m+1] && x <= nums[r])
                    return qs(nums, m+1, r, x);
                r = m - 1;
            }
        }
        return -1;
    }
    
    int qs(int[] nums, int l, int r, int x) {
        while(l <= r) {
            int m = (l+r)/2;
            if (x < nums[m]) {
                r = m - 1;
            } else if (x > nums[m]) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
