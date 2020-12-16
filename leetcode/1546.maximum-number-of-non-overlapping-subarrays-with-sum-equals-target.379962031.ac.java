/*
 * @lc app=leetcode id=1546 lang=java
 *
 * [1546] Maximum Number of Non-Overlapping Subarrays With Sum Equals Target
 *
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/description/
 *
 * algorithms
 * Medium (43.60%)
 * Total Accepted:    11.8K
 * Total Submissions: 27K
 * Testcase Example:  '[1,1,1,1,1]\n2'
 *
 * Given an array nums and an integer target.
 * 
 * Return the maximum number of non-empty non-overlapping subarrays such that
 * the sum of values in each subarray is equal to target.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,1,1,1], target = 2
 * Output: 2
 * Explanation: There are 2 non-overlapping subarrays [1,1,1,1,1] with sum
 * equals to target(2).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [-1,3,5,1,4,2,-9], target = 6
 * Output: 2
 * Explanation: There are 3 subarrays with sum equal to 6.
 * ([5,1], [4,2], [3,5,1,4,2,-9]) but only the first 2 are non-overlapping.
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [-2,6,6,3,5,4,1,2,8], target = 10
 * Output: 3
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: nums = [0,0,0], target = 0
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 0 <= target <= 10^6
 * 
 * 
 */
class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] dp = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            dp[i] = sum == target ? 1 : 0;
            if (i > 0 && dp[i] < dp[i-1])
                dp[i] = dp[i-1];
            if (map.containsKey(sum-target)) {
                dp[i] = Math.max(dp[i], dp[map.get(sum-target)]+1);
            }
            map.put(sum, i);
        }
        return dp[n-1];
    }
}
