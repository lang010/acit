/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (58.33%)
 * Total Accepted:    989.3K
 * Total Submissions: 1.7M
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int pre = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                continue;
            if (i == pre) {
                pre++;
            } else {
                nums[pre++] = nums[i];
            }
        }
        for (int i = pre; i < n; i++)
            nums[i] = 0;
    }
}
