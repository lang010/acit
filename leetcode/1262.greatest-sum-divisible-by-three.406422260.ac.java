/*
 * @lc app=leetcode id=1262 lang=java
 *
 * [1262] Greatest Sum Divisible by Three
 *
 * https://leetcode.com/problems/greatest-sum-divisible-by-three/description/
 *
 * algorithms
 * Medium (48.99%)
 * Total Accepted:    22.2K
 * Total Submissions: 45.4K
 * Testcase Example:  '[3,6,5,1,8]'
 *
 * Given an array nums of integers, we need to find the maximum possible sum of
 * elements of the array such that it is divisible by three.
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [3,6,5,1,8]
 * Output: 18
 * Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum
 * divisible by 3).
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4]
 * Output: 0
 * Explanation: Since 4 is not divisible by 3, do not pick any number.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,3,4,4]
 * Output: 12
 * Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum
 * divisible by 3).
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 * 
 * 
 */
class Solution {
    public int maxSumDivThree(int[] nums) {
        int a, b, c;
        int aa, bb, cc;
        a = b = c = 0;
        for (int x : nums)
            switch (x%3) {
                case 0:
                    a += x;
                    b = b > 0 ? b+x : 0;
                    c = c > 0 ? c+x : 0;
                    break;
                case 1:
                    aa = c > 0 ? Math.max(a, c+x) : a;
                    bb = Math.max(b, a+x);
                    cc = b > 0 ? Math.max(c, b+x) : c;
                    a = aa; b = bb; c = cc;
                    break;
                case 2:
                    aa = b > 0 ? Math.max(a, b+x) : a;
                    bb = c > 0 ? Math.max(b, c+x) : b;
                    cc = Math.max(c, a+x);
                    a = aa; b = bb; c = cc;
                    break;
            }
        return a;
    }
}
