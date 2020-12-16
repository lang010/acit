/*
 * @lc app=leetcode id=1574 lang=java
 *
 * [1574] Shortest Subarray to be Removed to Make Array Sorted
 *
 * https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/description/
 *
 * algorithms
 * Medium (32.40%)
 * Total Accepted:    7.6K
 * Total Submissions: 23.5K
 * Testcase Example:  '[1,2,3,10,4,2,3,5]'
 *
 * Given an integer array arr, remove a subarray (can be empty) from arr such
 * that the remaining elements in arr are non-decreasing.
 * 
 * A subarray is a contiguous subsequence of the array.
 * 
 * Return the length of the shortest subarray to remove.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [1,2,3,10,4,2,3,5]
 * Output: 3
 * Explanation: The shortest subarray we can remove is [10,4,2] of length 3.
 * The remaining elements after that will be [1,2,3,3,5] which are sorted.
 * Another correct solution is to remove the subarray [3,10,4].
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [5,4,3,2,1]
 * Output: 4
 * Explanation: Since the array is strictly decreasing, we can only keep a
 * single element. Therefore we need to remove a subarray of length 4, either
 * [5,4,3,2] or [4,3,2,1].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: arr = [1,2,3]
 * Output: 0
 * Explanation: The array is already non-decreasing. We do not need to remove
 * any elements.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: arr = [1]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 10^5
 * 0 <= arr[i] <= 10^9
 * 
 * 
 */
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int l = 0, r = n-1;
        while (l+1 < n && arr[l+1] >= arr[l])
            l++;
        if (l == n-1)
            return 0;
        while (r > 0 && arr[r-1] <= arr[r])
            r--;
        int ans = Math.max(l+1, n-r);
        for (int i = 0; i <= l && r < n; i++) {
            if (arr[i] <= arr[r]) {
                ans = Math.max(ans, i+1 + n-r);
            } else {
                i--;
                r++;
            }
        }
        return n - ans;
    }
}
