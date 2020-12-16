/*
 * @lc app=leetcode id=1493 lang=java
 *
 * [1493] Longest Subarray of 1's After Deleting One Element
 *
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
 *
 * algorithms
 * Medium (58.49%)
 * Total Accepted:    16.2K
 * Total Submissions: 27.6K
 * Testcase Example:  '[1,1,0,1]'
 *
 * Given a binary array nums, you should delete one element from it.
 * 
 * Return the size of the longest non-empty subarray containing only 1's in the
 * resulting array.
 * 
 * Return 0 if there is no such subarray.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,0,1]
 * Output: 3
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3
 * numbers with value of 1's.
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 * Output: 5
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1]
 * longest subarray with value of 1's is [1,1,1,1,1].
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,1,1]
 * Output: 2
 * Explanation: You must delete one element.
 * 
 * Example 4:
 * 
 * 
 * Input: nums = [1,1,0,0,1,1,1,0,1]
 * Output: 4
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: nums = [0,0,0]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * nums[i] is either 0 or 1.
 * 
 * 
 */
class Solution {
    public int longestSubarray(int[] nums) {
        int pre = 0, cur = 0, max = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++)
            if (nums[i] == 1) {
                cur++;
                if (i == n-1)
                    max = Math.max(max, pre+cur);
            } else {
                if (i > 0 && nums[i-1] == 1) {
                    max = Math.max(max, pre+cur);
                    pre = cur;
                } else
                    pre = 0;
                cur = 0;
            }
        return Math.min(n-1, max);
    }
}
