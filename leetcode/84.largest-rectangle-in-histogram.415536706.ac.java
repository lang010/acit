/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (36.18%)
 * Total Accepted:    308.7K
 * Total Submissions: 853K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * 
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * 
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10
 * unit.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: [2,1,5,6,2,3]
 * Output: 10
 * 
 * 
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        return helper(heights, 0, heights.length-1);
    }
    
    int helper(int[] h, int l, int r) {
        if (l > r)
            return 0;
        int min = Integer.MAX_VALUE;
        int m = 0;
        for (int i = l; i <= r; i++)
            if (min >= h[i]) {
                min = h[i];
                m = i;
            }
        return Math.max(min * (r-l+1), Math.max(helper(h, l, m-1), helper(h, m+1, r)));
    }
}
