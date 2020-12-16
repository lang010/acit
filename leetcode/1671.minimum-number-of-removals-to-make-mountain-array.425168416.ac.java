/*
 * @lc app=leetcode id=1671 lang=java
 *
 * [1671] Minimum Number of Removals to Make Mountain Array
 *
 * https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/description/
 *
 * algorithms
 * Hard (46.60%)
 * Total Accepted:    3.3K
 * Total Submissions: 7.2K
 * Testcase Example:  '[1,3,1]'
 *
 * You may recall that an array arr is a mountain array if and only if:
 * 
 * 
 * arr.length >= 3
 * There exists some index i (0-indexed) with 0 < i < arr.length - 1 such
 * that:
 * 
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 
 * 
 * 
 * 
 * Given an integer array nums​​​, return the minimum number of elements to
 * remove to make nums​​​ a mountain array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,3,1]
 * Output: 0
 * Explanation: The array itself is a mountain array so we do not need to
 * remove any elements.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,1,1,5,6,2,3,1]
 * Output: 3
 * Explanation: One solution is to remove the elements at indices 0, 1, and 5,
 * making the array nums = [1,5,6,3,1].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [4,3,2,1,1,2,3,1]
 * Output: 4
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: nums = [1,2,3,4,4,3,2,1]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 3 <= nums.length <= 1000
 * 1 <= nums[i] <= 10^9
 * It is guaranteed that you can make a mountain array out of nums.
 * 
 * 
 */
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] l, r;
        l = new int[n];
        r = new int[n];
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (nums[j] == nums[i])
                    l[i] = Math.max(l[i], l[j]);
                else if (nums[j] < nums[i])
                    l[i] = Math.max(l[i], l[j]+1);
        for (int i = n-2; i >= 0; i--)
            for (int j = i+1; j < n; j++)
                if (nums[j] == nums[i])
                    r[i] = Math.max(r[i], r[j]);
                else if (nums[j] < nums[i])
                    r[i] = Math.max(r[i], r[j]+1);
        int ans = n;
        for (int i = 1; i < n-1; i++) {
            ans = Math.min(ans, n - l[i] - r[i] - 1);
        }
        return ans;
    }
}
