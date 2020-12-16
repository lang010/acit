/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (46.19%)
 * Total Accepted:    528.9K
 * Total Submissions: 1.1M
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 =
 * 2).
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * 
 * 
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n-2; i++) {
            int l = i+1;
            int r = n-1;
            int val = target - nums[i];
            while (l < r) {
                int tmp = val - nums[l] - nums[r];
                if (tmp < 0)
                    r--;
                else if (tmp > 0)
                    l++;
                else
                    return target;
                if (min > Math.abs(tmp)) {
                    min = Math.abs(tmp);
                    ans = target - tmp;
                }
            }
        }
        return ans;
    }
}
