/*
 * @lc app=leetcode id=548 lang=java
 *
 * [548] Split Array with Equal Sum
 *
 * https://leetcode.com/problems/split-array-with-equal-sum/description/
 *
 * algorithms
 * Medium (47.45%)
 * Total Accepted:    15K
 * Total Submissions: 31.7K
 * Testcase Example:  '[1,2,1,2,1,2,1]'
 *
 * 
 * Given an array with n integers, you need to find if there are triplets  (i,
 * j, k) which satisfies following conditions:
 * 
 * ⁠0 < i, i + 1 < j, j + 1 < k < n - 1 
 * ⁠Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n -
 * 1) should be equal. 
 * 
 * where we define that subarray (L, R) represents a slice of the original
 * array starting from the element indexed L to the element indexed R.
 * 
 * 
 * Example:
 * 
 * Input: [1,2,1,2,1,2,1]
 * Output: True
 * Explanation:
 * i = 1, j = 3, k = 5. 
 * sum(0, i - 1) = sum(0, 0) = 1
 * sum(i + 1, j - 1) = sum(2, 2) = 1
 * sum(j + 1, k - 1) = sum(4, 4) = 1
 * sum(k + 1, n - 1) = sum(6, 6) = 1
 * 
 * 
 * 
 * Note:
 * 
 * ⁠1 
 * ⁠Elements in the given array will be in range [-1,000,000, 1,000,000]. 
 * 
 */
class Solution {
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++)
            nums[i] += nums[i-1];
        for (int i = 3; i < n - 3; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 1; j < i-1; j++) {
                if (nums[i-1]-nums[j] == nums[j-1]) {
                    set.add(nums[j-1]);
                }
            }
            for (int k = i+2; k < n-1; k++)
                if (nums[k-1] - nums[i] == nums[n-1] - nums[k] && set.contains(nums[k-1]-nums[i]))
                    return true;
        }
        
        return false;
    }
}
