/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (43.25%)
 * Total Accepted:    463.4K
 * Total Submissions: 1.1M
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * Given an integer array nums, return the length of the longest strictly
 * increasing subsequence.
 * 
 * A subsequence is a sequence that can be derived from an array by deleting
 * some or no elements without changing the order of the remaining elements.
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore
 * the length is 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2500
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * Could you come up with the O(n^2) solution?
 * Could you improve it to O(n log(n)) time complexity?
 * 
 * 
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int l = 1;
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int j = Arrays.binarySearch(dp, 0, l, nums[i]);
            if (j < 0) {
                j = -j - 1;
                dp[j] = nums[i];
                if (j == l)
                    l++;
            }
        }
        
        return l;
    }
}
