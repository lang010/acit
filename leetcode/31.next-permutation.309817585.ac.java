/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 *
 * https://leetcode.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (33.11%)
 * Total Accepted:    437.4K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,2,3]'
 *
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such an arrangement is not possible, it must rearrange it as the lowest
 * possible order (i.e., sorted in ascending order).
 * 
 * The replacement must be in place and use only constant extra memory.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * Example 4:
 * Input: nums = [1]
 * Output: [1]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * 
 * 
 */
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) 
            return ;
        int i = nums.length - 1;
        while (i > 0 && nums[i-1] >= nums[i]) {
            i--;
        }
        if (i != 0) {
            int j = i;
            i--;
            while (j < nums.length && nums[i] < nums[j]) {
                j++;
            }
            j--;
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j = nums.length - 1;
            while (i < j) {
                t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }
        } else {
            i = 0;
            int j = nums.length - 1;
            while (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }
        }
    }
}
