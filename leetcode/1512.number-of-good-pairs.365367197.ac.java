/*
 * @lc app=leetcode id=1512 lang=java
 *
 * [1512] Number of Good Pairs
 *
 * https://leetcode.com/problems/number-of-good-pairs/description/
 *
 * algorithms
 * Easy (87.90%)
 * Total Accepted:    102.1K
 * Total Submissions: 116.1K
 * Testcase Example:  '[1,2,3,1,1,3]'
 *
 * Given an array of integers nums.
 * 
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 * 
 * Return the number of good pairs.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 
 */
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++)
                if (nums[i] == nums[j])
                    cnt++;
        return cnt;
    }
}
