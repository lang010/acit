/*
 * @lc app=leetcode id=1287 lang=java
 *
 * [1287] Element Appearing More Than 25% In Sorted Array
 *
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/description/
 *
 * algorithms
 * Easy (60.15%)
 * Total Accepted:    33.5K
 * Total Submissions: 55.8K
 * Testcase Example:  '[1,2,2,6,6,6,6,7,10]'
 *
 * Given an integer array sorted in non-decreasing order, there is exactly one
 * integer in the array that occurs more than 25% of the time.
 * 
 * Return that integer.
 * 
 * 
 * Example 1:
 * Input: arr = [1,2,2,6,6,6,6,7,10]
 * Output: 6
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 * 
 */
class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        if (check(arr, arr[n/4]))
            return arr[n/4];
        if (check(arr, arr[n/2]))
            return arr[n/2];
        return arr[n*3/4];
    }
    
    boolean check(int[] arr, int x) {
        int l = binSearch(arr, x);
        int n = arr.length;
        int r = l + n/4;
        return r < n && arr[l] == arr[r];
    }
    
    int binSearch(int[] arr, int x) {
        int l = 0, r = arr.length-1;
        while (l < r) {
            int m = l + (r-l)/2;
            if (arr[m] == x)
                r = m;
            else if (arr[m] < x)
                l = m+1;
            else
                r = m-1;
        }
        return l;
    }
}
