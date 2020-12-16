/*
 * @lc app=leetcode id=1636 lang=java
 *
 * [1636] Sort Array by Increasing Frequency
 *
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/description/
 *
 * algorithms
 * Easy (66.63%)
 * Total Accepted:    10K
 * Total Submissions: 15.1K
 * Testcase Example:  '[1,1,2,2,2,3]'
 *
 * Given an array of integers nums, sort the array in increasing order based on
 * the frequency of the values. If multiple values have the same frequency,
 * sort them in decreasing order.
 * 
 * Return the sorted array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has
 * a frequency of 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,3,1,3,2]
 * Output: [1,3,3,2,2]
 * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in
 * decreasing order.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [-1,1,-6,4,5,-6,1,4,1]
 * Output: [5,-1,4,4,-6,-6,1,1,1]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 * 
 * 
 */
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int t = 0;
        Integer[] arr = new Integer[n];
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0)+1);
            arr[t++] = x;
        }
        Arrays.sort(arr, (x, y) -> map.get(x) == map.get(y) ? y - x : map.get(x) - map.get(y));
        t = 0;
        for (int x : arr)
            nums[t++] = x;
        return nums;
    }
}
