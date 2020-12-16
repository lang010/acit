/*
 * @lc app=leetcode id=611 lang=java
 *
 * [611] Valid Triangle Number
 *
 * https://leetcode.com/problems/valid-triangle-number/description/
 *
 * algorithms
 * Medium (48.89%)
 * Total Accepted:    73K
 * Total Submissions: 149.4K
 * Testcase Example:  '[2,2,3,4]'
 *
 * Given an array consists of non-negative integers,  your task is to count the
 * number of triplets chosen from the array that can make triangles if we take
 * them as side lengths of a triangle.
 * 
 * Example 1:
 * 
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are: 
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * 
 * 
 * 
 * Note:
 * 
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 * 
 * 
 * 
 */
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                continue;
            int k = i+2;
            for (int j = i+1; j < n; j++) {
                while (k < n && nums[k] < nums[i] + nums[j])
                    k++;
                ans += k - j - 1;
            }
        }
        return ans;
    }
}
