/*
 * @lc app=leetcode id=628 lang=java
 *
 * [628] Maximum Product of Three Numbers
 *
 * https://leetcode.com/problems/maximum-product-of-three-numbers/description/
 *
 * algorithms
 * Easy (46.97%)
 * Total Accepted:    135.2K
 * Total Submissions: 287.8K
 * Testcase Example:  '[1,2,3]'
 *
 * Given an integer array nums, find three numbers whose product is maximum and
 * return the maximum product.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: 6
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: 24
 * Example 3:
 * Input: nums = [-1,-2,-3]
 * Output: -6
 * 
 * 
 * Constraints:
 * 
 * 
 * 3 <= nums.length <= 10^4
 * -1000 <= nums[i] <= 1000
 * 
 * 
 */
class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = max1, max3 = max1;
        int min1 = Integer.MAX_VALUE;
        int min2 = min1;
        for (int x : nums) {
            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
}
