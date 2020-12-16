/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (59.65%)
 * Total Accepted:    750.2K
 * Total Submissions: 1.3M
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 */
class Solution {
    public int majorityElement(int[] nums) {
        int yes = 1;
        int no = 0;
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (ans == nums[i]) {
                yes++;
            } else {
                no++;
                if (no == yes) {
                    ans = nums[i];
                    no = 0;
                    yes = 1;
                }
            }
        }
        return ans;
    }
}
