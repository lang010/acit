/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 *
 * https://leetcode.com/problems/house-robber-ii/description/
 *
 * algorithms
 * Medium (37.30%)
 * Total Accepted:    218.5K
 * Total Submissions: 585.7K
 * Testcase Example:  '[2,3,2]'
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have a security system connected, and it
 * will automatically contact the police if two adjacent houses were broken
 * into on the same night.
 * 
 * Given a list of non-negative integers nums representing the amount of money
 * of each house, return the maximum amount of money you can rob tonight
 * without alerting the police.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money
 * = 2), because they are adjacent houses.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [0]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * 
 * 
 */
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 1)
            return 0;
        if (n < 2)
            return nums[0];
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n-1));
    }
    
    int rob(int[] nums, int l, int r) {
        int pre1 = 0;
        int pre2 = nums[l];
        for (int i = l+1; i <= r; i++) {
            int tmp = Math.max(pre2, pre1 + nums[i]);
            pre1 = pre2;
            pre2 = tmp;
        }
        return pre2;
    }
}
