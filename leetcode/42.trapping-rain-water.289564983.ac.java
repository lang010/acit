/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (50.41%)
 * Total Accepted:    627.2K
 * Total Submissions: 1.2M
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array
 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue
 * section) are being trapped.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == height.length
 * 0 <= n <= 3 * 10^4
 * 0 <= height[i] <= 10^5
 * 
 * 
 */
class Solution {
    public int trap(int[] height) {
        int lh = 0;
        int rh = 0;
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while (l <= r) {
            if (lh < rh) {
                while (l <= r && height[l] <= lh) {
                    ans += lh - height[l];
                    l++;
                }
                if (l <= r)
                    lh = height[l];
            } else {
                while (l <= r && height[r] <= rh) {
                    ans += rh - height[r];
                    r--;
                }
                if (l <= r)
                    rh = height[r];
            }
        }
        return ans;
    }
}
