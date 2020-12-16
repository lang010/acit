/*
 * @lc app=leetcode id=448 lang=java
 *
 * [448] Find All Numbers Disappeared in an Array
 *
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 * algorithms
 * Easy (56.06%)
 * Total Accepted:    318.3K
 * Total Submissions: 567.8K
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 * 
 * Example:
 * 
 * Input:
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [5,6]
 * 
 * 
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        int n = nums.length;
        for (int x : nums) {
            nums[x%n] += n;
        }
        List<Integer> ret = new ArrayList<>(n);
        for (int i = 1; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i);
            }
        }
        if (nums[0] <= n) {
            ret.add(n);
        }
        return ret;
    }
}
