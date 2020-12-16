/*
 * @lc app=leetcode id=259 lang=java
 *
 * [259] 3Sum Smaller
 *
 * https://leetcode.com/problems/3sum-smaller/description/
 *
 * algorithms
 * Medium (48.50%)
 * Total Accepted:    77.6K
 * Total Submissions: 160K
 * Testcase Example:  '[-2,0,1,3]\n2'
 *
 * Given an array of n integers nums and an integer target, find the number of
 * index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition
 * nums[i] + nums[j] + nums[k] < target.
 * 
 * Follow up: Could you solve it in O(n^2) runtime?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [-2,0,1,3], target = 2
 * Output: 2
 * Explanation: Because there are two triplets which sums are less than 2:
 * [-2,0,1]
 * [-2,0,3]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [], target = 0
 * Output: 0
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [0], target = 0
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 0 <= n <= 300
 * -100 <= nums[i] <= 100
 * -100 <= target <= 100
 * 
 * 
 */
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int val = target - nums[i];
            int l = i+1;
            int r = n-1;
            while (l < r) {
                if (nums[l] + nums[r] < val) {
                    ans += r - l;
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}
