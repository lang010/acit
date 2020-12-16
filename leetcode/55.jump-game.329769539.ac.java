/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 *
 * https://leetcode.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (34.97%)
 * Total Accepted:    556.1K
 * Total Submissions: 1.6M
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i][j] <= 10^5
 * 
 * 
 */
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length < 2)
            return true;
        int n = nums[0];
        for (int i = 0; i <= n; i++) {
            n = Math.max(n, i+nums[i]);
            if (n >= nums.length-1)
                return true;
        }
        return false;
    }
}
