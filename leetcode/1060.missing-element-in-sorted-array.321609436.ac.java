/*
 * @lc app=leetcode id=1060 lang=java
 *
 * [1060] Missing Element in Sorted Array
 *
 * https://leetcode.com/problems/missing-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (54.56%)
 * Total Accepted:    53.2K
 * Total Submissions: 97.6K
 * Testcase Example:  '[4,7,9,10]\n1'
 *
 * Given a sorted array A of unique numbers, find the K-th missing number
 * starting from the leftmost number of the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [4,7,9,10], K = 1
 * Output: 5
 * Explanation: 
 * The first missing number is 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = [4,7,9,10], K = 3
 * Output: 8
 * Explanation: 
 * The missing numbers are [5,6,8,...], hence the third missing number is 8.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: A = [1,2,4], K = 3
 * Output: 6
 * Explanation: 
 * The missing numbers are [3,5,6,7,...], hence the third missing number is
 * 6.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 50000
 * 1 <= A[i] <= 1e7
 * 1 <= K <= 1e8
 * 
 */
class Solution {
    public int missingElement(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        if (nums[r] - nums[l] - r < k)
            return nums[r] + k - (nums[r]-nums[l] -r);
        while (r-l > 1) {
            int mid = l + (r-l)/2;
            if (nums[mid] - nums[l] - (mid-l) < k) {
                k -= nums[mid] - nums[l] - (mid-l);
                l = mid;
            } else {
                r = mid;
            }
        }
        return nums[l] + k;
    }
}
