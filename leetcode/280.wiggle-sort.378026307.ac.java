/*
 * @lc app=leetcode id=280 lang=java
 *
 * [280] Wiggle Sort
 *
 * https://leetcode.com/problems/wiggle-sort/description/
 *
 * algorithms
 * Medium (64.36%)
 * Total Accepted:    94K
 * Total Submissions: 146.1K
 * Testcase Example:  '[3,5,2,1,6,4]'
 *
 * Given an unsorted array nums, reorder it in-place such that nums[0] <=
 * nums[1] >= nums[2] <= nums[3]....
 * 
 * Example:
 * 
 * 
 * Input: nums = [3,5,2,1,6,4]
 * Output: One possible answer is [3,5,1,6,2,4]
 * 
 */
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i-1] > nums[i])
                swap(nums, i-1, i);
            if (i+1 < n) {
                if (nums[i-1] > nums[i+1])
                    swap(nums, i-1, i+1);
                if (nums[i] < nums[i+1])
                    swap(nums, i, i+1);
                i++;
            }
        }
    }
    
    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
