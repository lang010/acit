/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 *
 * https://leetcode.com/problems/burst-balloons/description/
 *
 * algorithms
 * Hard (53.55%)
 * Total Accepted:    121.9K
 * Total Submissions: 227.7K
 * Testcase Example:  '[3,1,5,8]'
 *
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a
 * number on it represented by array nums. You are asked to burst all the
 * balloons. If the you burst balloon i you will get nums[left] * nums[i] *
 * nums[right] coins. Here left and right are adjacent indices of i. After the
 * burst, the left and right then becomes adjacent.
 * 
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * 
 * Note:
 * 
 * 
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can
 * not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 
 * 
 * Example:
 * 
 * 
 * Input: [3,1,5,8]
 * Output: 167 
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  -->
 * []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * 
 */
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length+2;
        int[][] dp = new int[n][n];
        int[] arr = new int[n];
        for (int i = 1; i < n-1; i++)
            arr[i] = nums[i-1];
        arr[0] = arr[n-1] = 1;
        for (int t = 2; t < n; t++)
            for (int l = 0; l+t < n; l++) {
                int r = l+t;
                for (int i = l+1; i < r; i++)
                    dp[l][r] = Math.max(arr[l]*arr[i]*arr[r] + dp[l][i] + dp[i][r], dp[l][r]);
            }
        return dp[0][n-1];
    }
}
