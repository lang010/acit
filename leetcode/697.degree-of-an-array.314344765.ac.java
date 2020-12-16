/*
 * @lc app=leetcode id=697 lang=java
 *
 * [697] Degree of an Array
 *
 * https://leetcode.com/problems/degree-of-an-array/description/
 *
 * algorithms
 * Easy (54.21%)
 * Total Accepted:    96.1K
 * Total Submissions: 177.3K
 * Testcase Example:  '[1,2,2,3,1]'
 *
 * Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 * 
 * Your task is to find the smallest possible length of a (contiguous) subarray
 * of nums, that has the same degree as nums.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation: 
 * The input array has a degree of 2 because both elements 1 and 2 appear
 * twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation: 
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 * 
 * 
 */
class Solution {
    public int findShortestSubArray(int[] nums) {
        int max = 1;
        int len = 1;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (!left.containsKey(x))
                left.put(x, i);
            int f = freq.getOrDefault(x, 0);
            f++;
            freq.put(x, f);
            if (f > max) {
                max = f;
                len = i - left.get(x);
            } else if (f == max && i-left.get(x) < len) {
                len = i - left.get(x);
            }
        }
        
        return len+1;
    }
}
