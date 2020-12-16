/*
 * @lc app=leetcode id=1099 lang=java
 *
 * [1099] Two Sum Less Than K
 *
 * https://leetcode.com/problems/two-sum-less-than-k/description/
 *
 * algorithms
 * Easy (60.78%)
 * Total Accepted:    52.9K
 * Total Submissions: 87.1K
 * Testcase Example:  '[34,23,1,24,75,33,54,8]\n60'
 *
 * Given an array nums of integers and integer k, return the maximum sum such
 * that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j
 * exist satisfying this equation, return -1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [34,23,1,24,75,33,54,8], k = 60
 * Output: 58
 * Explanation: We can use 34 and 24 to sum 58 which is less than 60.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [10,20,30], k = 15
 * Output: -1
 * Explanation: In this case it is not possible to get a pair sum less that
 * 15.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 1000
 * 1 <= k <= 2000
 * 
 * 
 */
class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int l = 0;
        int r = A.length - 1;
        int max = -1;
        while (l < r) {
            int sum = A[l]+A[r];
            if (sum >= K)
                r--;
            else {
                if (sum > max)
                    max = sum;
                l++;
            }
        }
        return max;
    }
}
