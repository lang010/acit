/*
 * @lc app=leetcode id=941 lang=java
 *
 * [941] Valid Mountain Array
 *
 * https://leetcode.com/problems/valid-mountain-array/description/
 *
 * algorithms
 * Easy (33.64%)
 * Total Accepted:    120.2K
 * Total Submissions: 357.3K
 * Testcase Example:  '[2,1]'
 *
 * Given an array of integers arr, return true if and only if it is a valid
 * mountain array.
 * 
 * Recall that arr is a mountain array if and only if:
 * 
 * 
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * 
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * Input: arr = [2,1]
 * Output: false
 * Example 2:
 * Input: arr = [3,5,5]
 * Output: false
 * Example 3:
 * Input: arr = [0,3,2,1]
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^4
 * 
 * 
 */
class Solution {
    public boolean validMountainArray(int[] A) {
        int n = A.length;
        if (n < 3)
            return false;
        int l = 1;
        while (l < n && A[l] > A[l-1])
            l++;
        int r = n-2;
        while (r >= 0 && A[r] > A[r+1])
            r--;
        return l-1 == r+1 && l > 1 && r < n-2;
    }
}
