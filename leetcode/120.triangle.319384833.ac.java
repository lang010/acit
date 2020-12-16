/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (45.20%)
 * Total Accepted:    274.2K
 * Total Submissions: 606.7K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n < 1)
            return 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> ls = triangle.get(i);
            if (i > 0) {
                ans[i] += ls.get(i) + ans[i-1];
            }
            for (int j = i-1; j > 0; j--) {
                ans[j] = ls.get(j) + Math.min(ans[j-1], ans[j]);
            }
            ans[0] += ls.get(0);
        }
        int min = ans[0];
        for (int i = 1; i < n; i++)
            min = Math.min(min, ans[i]);
        return min;
    }
}
