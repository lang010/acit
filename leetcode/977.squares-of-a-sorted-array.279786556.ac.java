/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 *
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 *
 * algorithms
 * Easy (72.16%)
 * Total Accepted:    363.4K
 * Total Submissions: 502.6K
 * Testcase Example:  '[-4,-1,0,3,10]'
 *
 * Given an integer array nums sorted in non-decreasing order, return an array
 * of the squares of each number sorted in non-decreasing order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums is sorted in non-decreasing order.
 * 
 * 
 */
class Solution {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int l = 0, r = A.length - 1;
        int id = A.length - 1;
        while (l <= r) {
            int vl = A[l] < 0 ? -A[l] : A[l];
            int vr = A[r] < 0 ? -A[r] : A[r];
            if (vl > vr) {
                res[id--] = vl * vl;
                l++;
            } else {
                res[id--] = vr * vr;
                r--;
            }
        }
        return res;
    }
}
