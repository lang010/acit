/*
 * @lc app=leetcode id=523 lang=java
 *
 * [523] Continuous Subarray Sum
 *
 * https://leetcode.com/problems/continuous-subarray-sum/description/
 *
 * algorithms
 * Medium (24.68%)
 * Total Accepted:    163.6K
 * Total Submissions: 663.1K
 * Testcase Example:  '[23,2,4,6,7]\n6'
 *
 * Given a list of non-negative numbers and a target integer k, write a
 * function to check if the array has a continuous subarray of size at least 2
 * that sums up to a multiple of k, that is, sums up to n*k where n is also an
 * integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up
 * to 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5
 * and sums up to 42.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The length of the array won't exceed 10,000.
 * You may assume the sum of all the numbers is in the range of a signed 32-bit
 * integer.
 * 
 * 
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k == 0) {
            for (int i = 0; i < nums.length-1; i++)
                if (nums[i] == 0 && nums[i+1] == 0) {
                    return true;
                }
            return false;
        }
        Set<Integer> set = new HashSet<>();
        nums[0] %= k;
        for (int i = 1; i < nums.length; i++)
            nums[i] = (nums[i-1] + nums[i]) % k;
        
        for (int i = 1; i < nums.length; i++)
            if (nums[i] == 0 || set.contains(nums[i]))
                return true;
            else
                set.add(nums[i-1]);
        
        return false;
    }
}
