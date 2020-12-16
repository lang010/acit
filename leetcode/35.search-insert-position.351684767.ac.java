/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 *
 * https://leetcode.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (42.72%)
 * Total Accepted:    730.9K
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * 
 * 
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * Example 4:
 * Input: nums = [1,3,5,6], target = 0
 * Output: 0
 * Example 5:
 * Input: nums = [1], target = 0
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums contains distinct values sorted in ascending order.
 * -10^4 <= target <= 10^4
 * 
 * 
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (nums[m] == target)
                return m;
            if (nums[m] < target)
                l = m+1;
            else
                r = m-1;
        }
        return l;
    }
}
