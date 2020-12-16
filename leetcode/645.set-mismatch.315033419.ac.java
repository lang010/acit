/*
 * @lc app=leetcode id=645 lang=java
 *
 * [645] Set Mismatch
 *
 * https://leetcode.com/problems/set-mismatch/description/
 *
 * algorithms
 * Easy (42.39%)
 * Total Accepted:    83.1K
 * Total Submissions: 196K
 * Testcase Example:  '[1,2,2,4]'
 *
 * 
 * The set S originally contains numbers from 1 to n. But unfortunately, due to
 * the data error, one of the numbers in the set got duplicated to another
 * number in the set, which results in repetition of one number and loss of
 * another number. 
 * 
 * 
 * 
 * Given an array nums representing the data status of this set after the
 * error. Your task is to firstly find the number occurs twice and then find
 * the number that is missing. Return them in the form of an array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * 
 * 
 * 
 * Note:
 * 
 * The given array size will in the range [2, 10000].
 * The given array's numbers won't have any order.
 * 
 * 
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i+1 != nums[i]) {
                while (i+1 != nums[i] && nums[i] != nums[nums[i]-1]) {
                    swap(nums, i, nums[i]-1);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i+1 != nums[i]) {
                return new int[] {nums[i], i+1};
            }
        }
        return null;
    }
    
    void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
}
