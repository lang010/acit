/*
 * @lc app=leetcode id=673 lang=java
 *
 * [673] Number of Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (38.27%)
 * Total Accepted:    71.4K
 * Total Submissions: 186.7K
 * Testcase Example:  '[1,3,5,4,7]'
 *
 * Given an integer array nums, return the number of longest increasing
 * subsequences.
 * 
 * Notice that the sequence has to be strictly increasing.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and
 * [1, 3, 5, 7].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1,
 * and there are 5 subsequences' length is 1, so output 5.
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2000
 * -10^6 <= nums[i] <= 10^6
 * 
 * 
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        int ans = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            int sum = 1;
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j]) {
                    if (max == dp[j]) {
                        sum += cnt[j];
                    } else if (max < dp[j]) {
                        max = dp[j];
                        sum = cnt[j];
                    }
                }
            dp[i] = max+1;
            cnt[i] = sum;
            if (maxLen == dp[i])
                ans += cnt[i];
            else if (maxLen < dp[i]) {
                maxLen = dp[i];
                ans = cnt[i];
            }
        }
        return ans;
    }
}
