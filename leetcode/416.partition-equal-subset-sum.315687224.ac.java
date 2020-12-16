/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 *
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 *
 * algorithms
 * Medium (44.60%)
 * Total Accepted:    241.8K
 * Total Submissions: 542.3K
 * Testcase Example:  '[1,5,11,5]'
 *
 * Given a non-empty array nums containing only positive integers, find if the
 * array can be partitioned into two subsets such that the sum of elements in
 * both subsets is equal.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 
 * 
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        if (sum % 2 == 1)
            return false;
        sum /= 2;
        boolean[] ans = new boolean[sum+1];
        ans[0] = true;
        for (int x : nums) {
            for (int i = sum; i > 0 ; i--) {
                if (i - x >= 0 && ans[i-x])
                    ans[i] = true;
            }
        }
        
        return ans[sum];
    }
}
