/*
 * @lc app=leetcode id=1509 lang=java
 *
 * [1509] Minimum Difference Between Largest and Smallest Value in Three Moves
 *
 * https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/description/
 *
 * algorithms
 * Medium (51.79%)
 * Total Accepted:    9.6K
 * Total Submissions: 18.6K
 * Testcase Example:  '[5,3,2,4]'
 *
 * Given an array nums, you are allowed to choose one element of nums and
 * change it by any value in one move.
 * 
 * Return the minimum difference between the largest and smallest value of nums
 * after perfoming at most 3 moves.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,3,2,4]
 * Output: 0
 * Explanation: Change the array [5,3,2,4] to [2,2,2,2].
 * The difference between the maximum and minimum is 2-2 = 0.
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,5,0,10,14]
 * Output: 1
 * Explanation: Change the array [1,5,0,10,14] to [1,1,0,1,1]. 
 * The difference between the maximum and minimum is 1-0 = 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [6,6,0,1,1,4,6]
 * Output: 2
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: nums = [1,5,6,14,15]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 
 */
class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n < 5)
            return 0;
        Arrays.sort(nums);
        int ans = nums[n-1] - nums[0];
        for (int i = 0; i <= 3; i++)
            ans = Math.min(ans, nums[n-(4-i)] - nums[i]);
        
        return ans;
    }
}
