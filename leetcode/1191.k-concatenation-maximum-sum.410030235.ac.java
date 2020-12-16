/*
 * @lc app=leetcode id=1191 lang=java
 *
 * [1191] K-Concatenation Maximum Sum
 *
 * https://leetcode.com/problems/k-concatenation-maximum-sum/description/
 *
 * algorithms
 * Medium (25.41%)
 * Total Accepted:    14.4K
 * Total Submissions: 56.8K
 * Testcase Example:  '[1,2]\n3'
 *
 * Given an integer array arr and an integer k, modify the array by repeating
 * it k times.
 * 
 * For example, if arr = [1, 2] and k = 3 then the modified array will be [1,
 * 2, 1, 2, 1, 2].
 * 
 * Return the maximum sub-array sum in the modified array. Note that the length
 * of the sub-array can be 0 and its sum in that case is 0.
 * 
 * As the answer can be very large, return the answer modulo 10^9 + 7.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [1,2], k = 3
 * Output: 9
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [1,-2,1], k = 5
 * Output: 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: arr = [-1,-2], k = 7
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 10^5
 * 1 <= k <= 10^5
 * -10^4 <= arr[i] <= 10^4
 * 
 * 
 */
class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long sum, preMax, preMin, max;
        sum = preMax = preMin = max = 0;
        for (int x : arr) {
            sum += x;
            max = Math.max(max, sum - preMin);
            preMin = Math.min(preMin, sum);
            preMax = Math.max(preMax, sum);
        }
        long sufixMax = sum > preMin ? sum - preMin : 0;
        long ans = 0;
        ans = Math.max(ans, sum * k);
        ans = Math.max(ans, max);
        if (k > 1) {
            ans = Math.max(ans, sufixMax + preMax);
            ans = Math.max(ans, sufixMax + preMax + (k-2) * sum);
        }
        
        return (int) (ans%1000000007);
    }
}
