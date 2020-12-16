/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 *
 * https://leetcode.com/problems/majority-element-ii/description/
 *
 * algorithms
 * Medium (38.29%)
 * Total Accepted:    184.9K
 * Total Submissions: 482.8K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times.
 * 
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [3,2,3]
 * Output: [3]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1]
 * Output: [1]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2]
 * Output: [1,2]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int x, y, cx, cy;
        x = y = cx = cy = 0;
        for (int t : nums) {
            if (t == x)
                cx++;
            else if (t == y)
                cy++;
            else if (cx == 0) {
                x = t;
                cx = 1;
            } else if (cy == 0) {
                y = t;
                cy = 1;
            } else {
                cx--;
                cy--;
            }
        }
        cx = cy = 0;
        for (int t : nums)
            if (t == x)
                cx++;
            else if (t == y)
                cy++;
        List<Integer> ans = new ArrayList<>();
        if (cx > nums.length/3)
            ans.add(x);
        if (cy > nums.length/3)
            ans.add(y);
        return ans;
    }
}
