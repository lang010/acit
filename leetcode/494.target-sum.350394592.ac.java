/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 *
 * https://leetcode.com/problems/target-sum/description/
 *
 * algorithms
 * Medium (45.93%)
 * Total Accepted:    201.6K
 * Total Submissions: 438.9K
 * Testcase Example:  '[1,1,1,1,1]\n3'
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a
 * target, S. Now you have 2 symbols + and -. For each integer, you should
 * choose one from + and - as its new symbol.
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to
 * target S.
 * 
 * Example 1:
 * 
 * 
 * Input: nums is [1, 1, 1, 1, 1], S is 3. 
 * Output: 5
 * Explanation: 
 * 
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 * 
 * 
 */
class Solution {
    
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int x : nums)
            sum += x;
        if (sum < S)
            return 0;
        int[] dp = new int[sum*2+2];
        int[] pre = new int[sum*2+2];
        dp[sum] = 1;
        for (int x : nums) {
            int[] tmp = pre;
            pre = dp;
            dp = tmp;
            Arrays.fill(dp, 0);
            for (int i = -sum; i <= sum; i++) {
                if (Math.abs(i+x) <= sum)
                    dp[i+x+sum] += pre[i+sum];
                if (Math.abs(i-x) <= sum)
                    dp[i-x+sum] += pre[i+sum];
            }
        }
        return dp[sum+S];
    }
    
    int[][] buf;
    
    public int findTargetSumWays0(int[] nums, int S) {
        buf = new int[nums.length][2000];
        for (int i = 0; i < nums.length; i++)
            Arrays.fill(buf[i], -1);
        return dfs(nums, 0, 0, S);
    }
    
    int dfs(int[] nums, int d, int cur, int tar) {
        if (d == nums.length) {
            if (cur == tar)
                return 1;
            else
                return 0;
        }
        if (buf[d][1000+cur] >= 0)
            return buf[d][1000+cur];
        int ans = dfs(nums, d+1, cur+nums[d], tar) + dfs(nums, d+1, cur-nums[d], tar);
        buf[d][1000+cur] = ans;
        return ans;
    }
}
