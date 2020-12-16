/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (32.50%)
 * Total Accepted:    419.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 */
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int left = 1;
        int right = 1;
        int cur = 1;
        int cnt = 0;
        int len = 0;
        for (int x : nums) {
            len++;
            if (x > 0) {
                cur *= x;
                if (cnt == 0)
                    left *= x;
                if (cnt > 0)
                    right *= x;
            } else if (x < 0) {
                cnt++;
                x = -x;
                cur *= x;
                if (cnt == 1) {
                    left *= x;
                }
                right = x;
            } else {
                // Zero
                if (cnt % 2 == 1) {
                    cur = left > right ? cur/right : cur/left;
                }
                if (len == 1 || len == 2 && cnt == 1)
                    max = Math.max(0, max);
                else
                    max = Math.max(cur, max);
                cnt = len = 0;
                cur = left = right = 1;
            }
        }
        // the last ones.
        if (cnt % 2 == 1) {
            cur = left > right ? cur/right : cur/left;
        }
        if (len == 1 && cnt == 1)
            max = Math.max(-left, max);
        else if (len > 0)
            max = Math.max(cur, max);
        
        return max;
    }
}
