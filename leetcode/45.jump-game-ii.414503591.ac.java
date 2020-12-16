/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 *
 * https://leetcode.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (31.16%)
 * Total Accepted:    299.6K
 * Total Submissions: 961.4K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers nums, you are initially positioned
 * at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * You can assume that you can always reach the last index.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump
 * 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i] <= 10^5
 * 
 * 
 */
class Solution {
    public int jump(int[] nums) {
        int ans = 1;
        int next = nums[0];
        int cur = 0;
        int n = nums.length;
        if (n == 1)
            return 0;
        for (int i = 1; i < n; i++) {
            if (next >= n-1)
                break;
            if (i > cur) {
                cur = next;
                next = i;
                ans++;
            }
            next = Math.max(next, nums[i] + i);
        }
        return ans;
    }
}
