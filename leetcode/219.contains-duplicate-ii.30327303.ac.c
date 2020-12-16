/*
 * @lc app=leetcode id=219 lang=c
 *
 * [219] Contains Duplicate II
 *
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 *
 * algorithms
 * Easy (38.36%)
 * Total Accepted:    304.1K
 * Total Submissions: 792.7K
 * Testcase Example:  '[1,2,3,1]\n3'
 *
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * 
 * 
 * 
 * 
 * 
 */

bool containsNearbyDuplicate(int* nums, int numsSize, int k) {
  for (int i = 1; i <= k; i++) {
    for	(int j = 0; j + i < numsSize; j++) {
      if (nums[j] == nums[i+j])
        return true;
    }
  }
  return false;
}

