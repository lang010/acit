/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 *
 * https://leetcode.com/problems/single-number-iii/description/
 *
 * algorithms
 * Medium (65.20%)
 * Total Accepted:    178.7K
 * Total Submissions: 274.1K
 * Testcase Example:  '[1,2,1,3,2,5]'
 *
 * Given an integer array nums, in which exactly two elements appear only once
 * and all the other elements appear exactly twice. Find the two elements that
 * appear only once. You can return the answer in any order.
 * 
 * Follow up: Your algorithm should run in linear runtime complexity. Could you
 * implement it using only constant space complexity?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,1,3,2,5]
 * Output: [3,5]
 * Explanation:  [5, 3] is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [-1,0]
 * Output: [-1,0]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [0,1]
 * Output: [1,0]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= nums.length <= 3 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * Each integer in nums will appear twice, only two integers will appear once.
 * 
 * 
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int x : nums) {
            diff ^= x;
        }
        diff = diff & (-diff);
        int[] ans = new int[2];
        for (int x : nums)
            if ((x & diff) == 0)
                ans[0] ^= x;
            else
                ans[1] ^= x;
        return ans;
    }
}
