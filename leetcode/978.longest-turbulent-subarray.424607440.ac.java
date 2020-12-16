/*
 * @lc app=leetcode id=978 lang=java
 *
 * [978] Longest Turbulent Subarray
 *
 * https://leetcode.com/problems/longest-turbulent-subarray/description/
 *
 * algorithms
 * Medium (46.61%)
 * Total Accepted:    34.7K
 * Total Submissions: 74.4K
 * Testcase Example:  '[9,4,2,10,7,8,8,1,9]'
 *
 * Given an integer array arr, return the length of a maximum size turbulent
 * subarray of arr.
 * 
 * A subarray is turbulent if the comparison sign flips between each adjacent
 * pair of elements in the subarray.
 * 
 * More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said
 * to be turbulent if and only if:
 * 
 * 
 * For i <= k < j:
 * 
 * 
 * arr[k] > arr[k + 1] when k is odd, and
 * arr[k] < arr[k + 1] when k is even.
 * 
 * 
 * Or, for i <= k < j:
 * 
 * arr[k] > arr[k + 1] when k is even, and
 * arr[k] < arr[k + 1] when k is odd.
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [9,4,2,10,7,8,8,1,9]
 * Output: 5
 * Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [4,8,12,16]
 * Output: 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: arr = [100]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 4 * 10^4
 * 0 <= arr[i] <= 10^9
 * 
 * 
 */
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n < 2)
            return n;
        int pre = 0;
        int len = 0;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i-1]) {
                pre = 0;
                len = 0;
                continue;
            }
            int cur = arr[i] > arr[i-1] ? 1 : -1;
            if (cur * pre == -1) {
                len++;
            } else {
                len = 1;
            }
            ans = Math.max(ans, len);
            pre = cur;
        }
        return ans+1;
    }
}
