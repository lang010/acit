/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 *
 * https://leetcode.com/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (33.23%)
 * Total Accepted:    417.2K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,2,0]'
 *
 * Given an unsorted integer array nums, find the smallest missing positive
 * integer.
 * 
 * Follow up: Could you implement an algorithm that runs in O(n) time and uses
 * constant extra space.?
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Example 3:
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 300
 * -2^31 <= nums[i] <= 2^31 - 1
 * 
 * 
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++)
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i]-1]) {
                int t = nums[i];
                nums[i] = nums[t-1];
                nums[t-1] = t;
                i--;
            }
        for (int i = 0; i < n; i++)
            if (i+1 != nums[i])
                return i+1;
        return n+1;
    }
}
