/*
 * @lc app=leetcode id=456 lang=java
 *
 * [456] 132 Pattern
 *
 * https://leetcode.com/problems/132-pattern/description/
 *
 * algorithms
 * Medium (30.51%)
 * Total Accepted:    80.2K
 * Total Submissions: 262.8K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given an array of n integers nums, a 132 pattern is a subsequence of three
 * integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] <
 * nums[k] < nums[j].
 * 
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 * 
 * Follow up: The O(n^2) is trivial, could you come up with the O(n logn) or
 * the O(n) solution?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation: There is no 132 pattern in the sequence.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,1,4,2]
 * Output: true
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [-1,3,2,0]
 * Output: true
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1,
 * 3, 0] and [-1, 2, 0].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 1 <= n <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 */
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 1)
            return false;
        Stack<int[]> stack = new Stack<>();
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
                continue;
            }
            int[] cur = {min, nums[i]};
            while (!stack.isEmpty()) {
                int[] top = stack.peek();
                if (cur[1] <= top[0])
                    break;
                if (cur[1] < top[1])
                    return true;
                stack.pop();
            }
            stack.add(cur);
        }
        return false;
    }
}
