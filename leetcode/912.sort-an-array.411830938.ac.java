/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 *
 * https://leetcode.com/problems/sort-an-array/description/
 *
 * algorithms
 * Medium (64.29%)
 * Total Accepted:    114.5K
 * Total Submissions: 178.1K
 * Testcase Example:  '[5,2,3,1]'
 *
 * Given an array of integers nums, sort the array in ascending order.
 * 
 * 
 * Example 1:
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Example 2:
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 * 
 * 
 */
class Solution {
    public int[] sortArray(int[] nums) {
        int n = 50000;
        int[] cnt = new int[n*2+1];
        for (int x : nums)
            cnt[x+n]++;
        int id = 0;
        for (int i = 0; i <= n*2; i++)
            while (cnt[i] > 0) {
                nums[id++] = i-n;
                cnt[i]--;
            }
        return nums;
    }
}
