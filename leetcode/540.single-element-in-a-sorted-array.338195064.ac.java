/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 *
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 *
 * algorithms
 * Medium (57.91%)
 * Total Accepted:    170.3K
 * Total Submissions: 294.1K
 * Testcase Example:  '[1,1,2,3,3,4,4,8,8]'
 *
 * You are given a sorted array consisting of only integers where every element
 * appears exactly twice, except for one element which appears exactly once.
 * Find this single element that appears only once.
 * 
 * Follow up: Your solution should run in O(log n) time and O(1) space.
 * 
 * 
 * Example 1:
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 * 
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if (r == 0)
            return nums[0];
        while (l < r) {
            int m = l + (r-l)/2;
            if (nums[m] == nums[m+1]) {
                if ((m - l) % 2 == 0)
                    l = m + 2;
                else
                    r = m - 1;
            } else if (nums[m-1] == nums[m]) {
                if ((m+1-l)%2 == 0)
                    l = m + 1;
                else
                    r = m - 2;
            } else
                return nums[m];
        }
        return nums[l];
    }
}
