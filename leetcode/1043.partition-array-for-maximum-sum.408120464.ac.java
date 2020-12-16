/*
 * @lc app=leetcode id=1043 lang=java
 *
 * [1043] Partition Array for Maximum Sum
 *
 * https://leetcode.com/problems/partition-array-for-maximum-sum/description/
 *
 * algorithms
 * Medium (66.59%)
 * Total Accepted:    24.4K
 * Total Submissions: 36.6K
 * Testcase Example:  '[1,15,7,9,2,5,10]\n3'
 *
 * Given an integer array arr, you should partition the array into (contiguous)
 * subarrays of length at most k. After partitioning, each subarray has their
 * values changed to become the maximum value of that subarray.
 * 
 * Return the largest sum of the given array after partitioning.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [1,15,7,9,2,5,10], k = 3
 * Output: 84
 * Explanation: arr becomes [15,15,15,9,10,10,10]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * Output: 83
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: arr = [1], k = 1
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^9
 * 1 <= k <= arr.length
 * 
 * 
 */
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < k && i - j >= 0; j++) {
                max = Math.max(max, arr[i-j]);
                int val = i>j ? dp[i-j-1] : 0;
                dp[i] = Math.max(dp[i], val + max*(j+1));
            }
        }
        return dp[n-1];
    }
}
