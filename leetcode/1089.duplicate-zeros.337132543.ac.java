/*
 * @lc app=leetcode id=1089 lang=java
 *
 * [1089] Duplicate Zeros
 *
 * https://leetcode.com/problems/duplicate-zeros/description/
 *
 * algorithms
 * Easy (52.10%)
 * Total Accepted:    108.7K
 * Total Submissions: 208.6K
 * Testcase Example:  '[1,0,2,3,0,4,5,0]'
 *
 * Given a fixed length array arr of integers, duplicate each occurrence of
 * zero, shifting the remaining elements to the right.
 * 
 * Note that elements beyond the length of the original array are not written.
 * 
 * Do the above modifications to the input array in place, do not return
 * anything from your function.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to:
 * [1,0,0,2,3,0,0,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3]
 * Output: null
 * Explanation: After calling your function, the input array is modified to:
 * [1,2,3]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 * 
 */
class Solution {
    public void duplicateZeros(int[] arr) {
        int cnt = 0;
        int l = 0;
        int n = arr.length;
        while (l+cnt < n) {
            if (arr[l] == 0) {
                cnt++;
            }
            l++;
        }
        l--;
        int r = arr.length-1;
        if (l+cnt == n) {
            arr[r--] = 0;
            l--;
        }
        while (l < r) {
            arr[r--] = arr[l];
            if (arr[l] == 0)
                arr[r--] = 0;
            l--;
        }
    }
}
